package com.test.portlet;

import com.test.constants.PurchaseControllerPortletKeys;
import com.test.model.Electronics;
import com.test.model.Employee;
import com.test.model.Purchase;
import com.test.service.ElectronicsLocalService;
import com.test.service.EmployeeLocalService;
import com.test.service.PurchaseLocalService;

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
import com.liferay.portal.kernel.exception.PortalException;
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
		"javax.portlet.display-name=PurchaseController", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PurchaseControllerPortletKeys.PURCHASECONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PurchaseControllerPortlet extends MVCPortlet {

	private static final String COMMA_DELIMITER = ",";

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private PurchaseLocalService purchaseLocalService;

	@Reference
	private ElectronicsLocalService electronicsLocalService;

	@Reference
	private EmployeeLocalService employeeLocalService;

	@ProcessAction(name = "addPurchase")
	public void addPurchase(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, IllegalAccessException {

		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		long purchaseId = counterLocalService.increment(Purchase.class.getName());
		Date purchaseDate = ParamUtil.getDate(actionRequest, "purchaseDate", format);
		long employeeId = ParamUtil.getLong(actionRequest, "employee");
		long electronicsId = ParamUtil.getLong(actionRequest, "electronics");
		long purchaseTypeId = ParamUtil.getLong(actionRequest, "purchase-type");

		Purchase purchase = purchaseLocalService.createPurchase(purchaseId);

		Electronics electronics = electronicsLocalService.getElectronics(electronicsId);

		List<Employee> empList = employeeLocalService.getElectroTypeEmployees(electronics.getElectroTypeId());

		int actualCount = electronics.getCount();
		Date currentDate = new Date();

		if (actualCount > 0) {

			actualCount = actualCount - 1;

			for (int i = 0; i < empList.size(); i++) {

				if (empList.get(i).getEmployeeId() == employeeId) {

					if (purchaseDate.before(currentDate)) {

						purchase.setPurchaseDate(purchaseDate);
						purchase.setPurchaseId(purchaseId);
						purchase.setEmployeeId(employeeId);
						purchase.setElectronicsId(electronicsId);
						purchase.setPurchaseTypeId(purchaseTypeId);

						electronics.setCount(actualCount);

						electronicsLocalService.updateElectronics(electronics);

						purchaseLocalService.addPurchase(purchase);
						i = empList.size();

					} else {

						try {

							throw new IllegalAccessException();

						} catch (Exception e) {

							SessionErrors.add(actionRequest, "wrongDate");
						}
					}

					i = empList.size();

				} else if (i == empList.size() - 1) {

					try {

						throw new IllegalAccessException();

					} catch (Exception e) {

						SessionErrors.add(actionRequest, "wrongEtype");
					}
				}
			}
		} else {

			try {

				throw new IllegalAccessException();

			} catch (Exception e) {

				SessionErrors.add(actionRequest, "emptyCount");
			}
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<Purchase> purchaseList = purchaseLocalService.getPurchases(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("purchaseList", purchaseList);
		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = "updatePurchase")
	public void updatePurchase(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {

		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		long purchaseId = ParamUtil.getLong(actionRequest, "purchaseId", GetterUtil.DEFAULT_LONG);
		Date purchaseDate = ParamUtil.getDate(actionRequest, "purchaseDate", format);
		long employeeId = ParamUtil.getLong(actionRequest, "employeeId", GetterUtil.DEFAULT_LONG);
		long electronicsId = ParamUtil.getLong(actionRequest, "electronicsId", GetterUtil.DEFAULT_LONG);

		Purchase purchase = null;
		try {
			purchase = purchaseLocalService.getPurchase(purchaseId);
		} catch (Exception e) {
			log.error(e.getCause(), e);
		}

		Electronics electronics = electronicsLocalService.getElectronics(electronicsId);
		List<Employee> empList = employeeLocalService.getElectroTypeEmployees(electronics.getElectroTypeId());

		Date currentDate = new Date();

		if (Validator.isNotNull(purchase)) {

			for (int i = 0; i < empList.size(); i++) {

				if (empList.get(i).getEmployeeId() == employeeId) {

					if (purchaseDate.before(currentDate)) {

						purchase.setPurchaseDate(purchaseDate);
						purchase.setEmployeeId(employeeId);
						purchase.setElectronicsId(electronicsId);

						purchaseLocalService.updatePurchase(purchase);
						i = empList.size();

					} else {

						try {

							throw new IllegalAccessException();
						} catch (Exception e) {

							SessionErrors.add(actionRequest, "wrongDate");
						}
					}

					i = empList.size();

				} else if (i == empList.size() - 1) {

					try {

						throw new IllegalAccessException();

					} catch (Exception e) {

						SessionErrors.add(actionRequest, "wrongEtype");
					}
				}
			}
		}
	}

	@ProcessAction(name = "deletePurchase")
	public void deletePurchase(ActionRequest actionRequest, ActionResponse actionResponse) {

		long purchaseId = ParamUtil.getLong(actionRequest, "purchaseId", GetterUtil.DEFAULT_LONG);
		try {
			purchaseLocalService.deletePurchase(purchaseId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@ProcessAction(name = "importCsvPurchase")
	public void importCsvEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, ParseException, PortalException {

		String pathZip = "D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-purchase\\src\\main\\resources\\META-INF\\resources\\csv\\purchase.zip";
		File destDir = new File(
				"D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-purchase\\src\\main\\resources\\META-INF\\resources\\csv");

		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		List<List<String>> records = new ArrayList<>();

		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZip));
		ZipEntry zipEntry = zis.getNextEntry();

		String pathFile = null;

		while (zipEntry != null) {

			pathFile = "D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-purchase\\src\\main\\resources\\META-INF\\resources\\csv\\"
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

			long purchaseId = counterLocalService.increment(Purchase.class.getName());

			Date purchaseDate = format.parse(records.get(i).get(0));
			long employeeId = Long.parseLong(records.get(i).get(1));
			long electronicsId = Long.parseLong(records.get(i).get(2));
			long purchaseTypeId = Long.parseLong(records.get(i).get(3));

			Purchase purchase = purchaseLocalService.createPurchase(purchaseId);

			Electronics electronics = electronicsLocalService.getElectronics(electronicsId);

			List<Employee> empList = employeeLocalService.getElectroTypeEmployees(electronics.getElectroTypeId());

			int actualCount = electronics.getCount();

			Date currentDate = new Date();

			if (actualCount > 0) {

				actualCount = actualCount - 1;

				for (int j = 0; j < empList.size(); j++) {

					if (empList.get(j).getEmployeeId() == employeeId) {

						if (purchaseDate.before(currentDate)) {

							purchase.setPurchaseDate(purchaseDate);
							purchase.setPurchaseId(purchaseId);
							purchase.setEmployeeId(employeeId);
							purchase.setElectronicsId(electronicsId);
							purchase.setPurchaseTypeId(purchaseTypeId);

							electronics.setCount(actualCount);

							electronicsLocalService.updateElectronics(electronics);

							purchaseLocalService.addPurchase(purchase);
							j = empList.size();

						} else {

							try {

								throw new IllegalAccessException();

							} catch (Exception e) {

								SessionErrors.add(actionRequest, "wrongDate");
							}
						}

						j = empList.size();

					} else if (j == empList.size() - 1) {

						try {

							throw new IllegalAccessException();

						} catch (Exception e) {

							SessionErrors.add(actionRequest, "wrongEtype");
						}
					}
				}
			} else {

				try {

					throw new IllegalAccessException();

				} catch (Exception e) {

					SessionErrors.add(actionRequest, "emptyCount");
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