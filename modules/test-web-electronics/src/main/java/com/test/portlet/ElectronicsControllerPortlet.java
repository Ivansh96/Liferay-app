package com.test.portlet;

import com.test.constants.ElectronicsControllerPortletKeys;
import com.test.model.Electronics;
import com.test.service.ElectronicsLocalService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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
		"javax.portlet.display-name=ElectronicsController", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ElectronicsControllerPortletKeys.ELECTRONICSCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ElectronicsControllerPortlet extends MVCPortlet {

	private static final String COMMA_DELIMITER = ",";

	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ElectronicsLocalService electronicsLocalService;

	@ProcessAction(name = "addElectronics")
	public void addElectronics(ActionRequest actionRequest, ActionResponse actionResponse) {

		long electronicsId = counterLocalService.increment(Electronics.class.getName());
		String name = ParamUtil.getString(actionRequest, "name");
		long price = ParamUtil.getLong(actionRequest, "price");
		int count = ParamUtil.getInteger(actionRequest, "count");
		boolean inStock = ParamUtil.getBoolean(actionRequest, "inStock");
		boolean archive = ParamUtil.getBoolean(actionRequest, "archive");
		String description = ParamUtil.getString(actionRequest, "description");
		long electroTypeId = ParamUtil.getLong(actionRequest, "etype");

		Electronics electronics = electronicsLocalService.createElectronics(electronicsId);

		electronics.setElectronicsId(electronicsId);
		electronics.setName(name);
		electronics.setPrice(price);
		electronics.setCount(count);
		electronics.setInStock(inStock);
		electronics.setArchive(archive);
		electronics.setDescription(description);
		electronics.setElectroTypeId(electroTypeId);

		electronicsLocalService.addElectronics(electronics);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<Electronics> electronicsList = electronicsLocalService.getElectronicses(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		renderRequest.setAttribute("electronicsList", electronicsList);
		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = "updateElectronics")
	public void updateElectronics(ActionRequest actionRequest, ActionResponse actionResponse) {

		long electronicsId = ParamUtil.getLong(actionRequest, "electronicsId", GetterUtil.DEFAULT_LONG);
		String name = ParamUtil.getString(actionRequest, "name", GetterUtil.DEFAULT_STRING);
		long price = ParamUtil.getLong(actionRequest, "price", GetterUtil.DEFAULT_LONG);
		int count = ParamUtil.getInteger(actionRequest, "count", GetterUtil.DEFAULT_INTEGER);
		boolean inStock = ParamUtil.getBoolean(actionRequest, "inStock", GetterUtil.DEFAULT_BOOLEAN);
		boolean archive = ParamUtil.getBoolean(actionRequest, "archive", GetterUtil.DEFAULT_BOOLEAN);
		String description = ParamUtil.getString(actionRequest, "description", GetterUtil.DEFAULT_STRING);

		Electronics electronics = null;
		try {
			electronics = electronicsLocalService.getElectronics(electronicsId);
		} catch (Exception e) {
			log.error(e.getCause(), e);
		}

		if (Validator.isNotNull(electronics)) {
			electronics.setName(name);
			electronics.setPrice(price);
			electronics.setCount(count);
			electronics.setInStock(inStock);
			electronics.setArchive(archive);
			electronics.setDescription(description);

			electronicsLocalService.updateElectronics(electronics);
		}
	}

	@ProcessAction(name = "deleteElectronics")
	public void deleteElectronics(ActionRequest actionRequest, ActionResponse actionResponse) {

		long electronicsId = ParamUtil.getLong(actionRequest, "electronicsId", GetterUtil.DEFAULT_LONG);
		try {
			electronicsLocalService.deleteElectronics(electronicsId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@ProcessAction(name = "importCsvElectronics")
	public void importCsvEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, ParseException {

		String pathZip = "D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-electronics\\src\\main\\resources\\META-INF\\resources\\csv\\electronics.zip";
		File destDir = new File(
				"D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-electronics\\src\\main\\resources\\META-INF\\resources\\csv");

		List<List<String>> records = new ArrayList<>();

		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZip));
		ZipEntry zipEntry = zis.getNextEntry();

		String pathFile = null;

		while (zipEntry != null) {

			pathFile = "D:\\LiferayDev\\Workspace\\test-workspace\\modules\\test-web-electronics\\src\\main\\resources\\META-INF\\resources\\csv\\"
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

			long electronicsId = counterLocalService.increment(Electronics.class.getName());

			String name = records.get(i).get(0);
			long price = Long.parseLong(records.get(i).get(1));
			int count = Integer.parseInt(records.get(i).get(2));
			boolean inStock = Boolean.parseBoolean(records.get(i).get(3));
			boolean archive = Boolean.parseBoolean(records.get(i).get(4));
			String description = records.get(i).get(5);
			long electroTypeId = Long.parseLong(records.get(i).get(6));

			Electronics electronics = electronicsLocalService.createElectronics(electronicsId);

			electronics.setElectronicsId(electronicsId);
			electronics.setName(name);
			electronics.setPrice(price);
			electronics.setCount(count);
			electronics.setInStock(inStock);
			electronics.setArchive(archive);
			electronics.setDescription(description);
			electronics.setElectroTypeId(electroTypeId);

			electronicsLocalService.addElectronics(electronics);

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