package com.test.portlet;

import com.test.constants.EmpControllerPortletKeys;
import com.test.model.Employee;
import com.test.service.EmployeeLocalService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Hog
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmpController", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmpControllerPortletKeys.EMPCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EmpControllerPortlet extends MVCPortlet {

	private static final String COMMA_DELIMITER = ",";

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private EmployeeLocalService employeeLocalService;

	@ProcessAction(name = "addEmployee")
	public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException {

		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		long employeeId = counterLocalService.increment(Employee.class.getName());
		String firstname = ParamUtil.getString(actionRequest, "firstname");
		String lastname = ParamUtil.getString(actionRequest, "lastname");
		String patronymic = ParamUtil.getString(actionRequest, "patronymic");
		Date birthdate = ParamUtil.getDate(actionRequest, "birthdate", format);
		boolean gender = ParamUtil.getBoolean(actionRequest, "gender");
		long positionTypeId = ParamUtil.getLong(actionRequest, "position");
		long electroTypeId = ParamUtil.getLong(actionRequest, "etype");

		Employee employee = employeeLocalService.createEmployee(employeeId);

		Date currentDate = new Date();

		if (birthdate.before(currentDate)) {

			employee.setEmployeeId(employeeId);
			employee.setFirstname(firstname);
			employee.setLastname(lastname);
			employee.setPatronymic(patronymic);
			employee.setBirthdate(birthdate);
			employee.setGender(gender);
			employee.setPositionTypeId(positionTypeId);

			employeeLocalService.addElectroTypeEmployee(electroTypeId, employeeId);

			employeeLocalService.addEmployee(employee);

		} else {

			try {

				throw new IllegalAccessException();
			} catch (Exception e) {

				SessionErrors.add(actionRequest, "wrongDate");
			}
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<Employee> employeeList = employeeLocalService.getEmployees(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("employeeList", employeeList);
		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = "updateEmployee")
	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {

		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		long employeeId = ParamUtil.getLong(actionRequest, "employeeId", GetterUtil.DEFAULT_LONG);
		String firstname = ParamUtil.getString(actionRequest, "firstname", GetterUtil.DEFAULT_STRING);
		String lastname = ParamUtil.getString(actionRequest, "lastname", GetterUtil.DEFAULT_STRING);
		String patronymic = ParamUtil.getString(actionRequest, "patronymic", GetterUtil.DEFAULT_STRING);
		Date birthdate = ParamUtil.getDate(actionRequest, "birthdate", format);
		boolean gender = ParamUtil.getBoolean(actionRequest, "gender", GetterUtil.DEFAULT_BOOLEAN);

		Employee employee = null;
		try {
			employee = employeeLocalService.getEmployee(employeeId);
		} catch (Exception e) {
			log.error(e.getCause(), e);
		}

		Date currentDate = new Date();

		if (Validator.isNotNull(employee)) {

			if (birthdate.before(currentDate)) {
				employee.setFirstname(firstname);
				employee.setLastname(lastname);
				employee.setPatronymic(patronymic);
				employee.setBirthdate(birthdate);
				employee.setGender(gender);

				employeeLocalService.updateEmployee(employee);

			} else {

				try {

					throw new IllegalAccessException();
				} catch (Exception e) {

					SessionErrors.add(actionRequest, "wrongDate");
				}
			}
		}
	}

	@ProcessAction(name = "deleteEmployee")
	public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse) {

		long employeeId = ParamUtil.getLong(actionRequest, "employeeId", GetterUtil.DEFAULT_LONG);
		try {
			employeeLocalService.deleteEmployee(employeeId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@ProcessAction(name = "importCsvEmployee")
	public void importCsvEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, ParseException {

		String pathZip = "D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-employee\\src\\main\\resources\\META-INF\\resources\\csv\\employee.zip";
		File destDir = new File(
				"D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-employee\\src\\main\\resources\\META-INF\\resources\\csv");

		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		List<List<String>> records = new ArrayList<>();

		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZip));
		ZipEntry zipEntry = zis.getNextEntry();

		String pathFile = null;

		while (zipEntry != null) {

			pathFile = "D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-employee\\src\\main\\resources\\META-INF\\resources\\csv\\"
					+ zipEntry.getName();

			File newFile = newFile(destDir, zipEntry);
			if (zipEntry.isDirectory()) {
				if (!newFile.isDirectory() && !newFile.mkdirs()) {
					throw new IOException("Failed to create directory " + newFile);
				}
			} else {

				File parent = newFile.getParentFile();
				if (!parent.isDirectory() && parent.mkdirs()) {
					throw new IOException("Failed to create directory " + parent);
				}

				final FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
			}
			try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] values = line.split(COMMA_DELIMITER);
					records.add(Arrays.asList(values));
				}
			}

			zipEntry = zis.getNextEntry();
		}

		zis.closeEntry();
		zis.close();

		for (int i = 0; i < records.size(); i++) {

			long employeeId = counterLocalService.increment(Employee.class.getName());

			String firstname = records.get(i).get(0);
			String lastname = records.get(i).get(1);
			String patronymic = records.get(i).get(2);
			Date birthdate = format.parse(records.get(i).get(3));
			boolean gender = Boolean.parseBoolean(records.get(i).get(4));
			long positionTypeId = Long.parseLong(records.get(i).get(5));
			long electroTypeId = Long.parseLong(records.get(i).get(6));

			Employee employee = employeeLocalService.createEmployee(employeeId);

			Date currentDate = new Date();

			if (birthdate.before(currentDate)) {

				employee.setEmployeeId(employeeId);
				employee.setFirstname(firstname);
				employee.setLastname(lastname);
				employee.setPatronymic(patronymic);
				employee.setBirthdate(birthdate);
				employee.setGender(gender);
				employee.setPositionTypeId(positionTypeId);

				employeeLocalService.addElectroTypeEmployee(electroTypeId, employeeId);

				employeeLocalService.addEmployee(employee);

			} else {

				try {

					throw new IllegalAccessException();
				} catch (Exception e) {

					SessionErrors.add(actionRequest, "wrongDate");
				}
			}

		}

	}

	private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {

		File destFile = new File(destinationDir, zipEntry.getName());
		String destDirPath = destinationDir.getCanonicalPath();
		String destFilePath = destFile.getCanonicalPath();

		if (!destFilePath.startsWith(destDirPath + File.separator)) {
			throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
		}
		return destFile;
	}
}