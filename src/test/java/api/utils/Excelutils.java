package api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.pojo.Address;
import api.pojo.ApiData;

public class Excelutils {

	/*
	 * public static List<ApiData> excelDataToListOfObjets_withApachePOI(String
	 * fileLocation, String matchTestCase) throws IOException { FileInputStream file
	 * = new FileInputStream(new File(fileLocation)); Workbook workbook = new
	 * XSSFWorkbook(file); Sheet sheet = workbook.getSheet("Userdata");
	 * List<ApiData> apiDataList = new ArrayList<ApiData>(); DataFormatter
	 * dataFormatter = new DataFormatter(); String testCase = null; for (int n = 1;
	 * n < sheet.getPhysicalNumberOfRows(); n++) { Row row = sheet.getRow(n);
	 * ApiData apiData = new ApiData(); int i = row.getFirstCellNum();
	 * if(matchTestCase.equalsIgnoreCase(dataFormatter.formatCellValue(row.getCell(i
	 * )))) { apiData.setTestCase(dataFormatter.formatCellValue(row.getCell(i)));
	 * apiData.setFirstName(dataFormatter.formatCellValue(row.getCell(++i)));
	 * apiData.setLastName(dataFormatter.formatCellValue(row.getCell(++i)));
	 * apiData.setContactInfo(dataFormatter.formatCellValue(row.getCell(++i)));
	 * apiData.setEmail(dataFormatter.formatCellValue(row.getCell(i)));
	 * apiDataList.add(apiData); } } return apiDataList; }
	 */

	public static String excelDataToJsonString(String fileLocation, String matchTestCase) throws IOException {
		FileInputStream file = new FileInputStream(new File(fileLocation));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("Userdata");
		DataFormatter dataFormatter = new DataFormatter();
		ApiData apiData = new ApiData();
		for (int n = 1; n < sheet.getPhysicalNumberOfRows(); n++) {
			Row row = sheet.getRow(n);
			int i = row.getFirstCellNum();
			if (matchTestCase.equalsIgnoreCase(dataFormatter.formatCellValue(row.getCell(i)))) {
				apiData.setFirstName(dataFormatter.formatCellValue(row.getCell(++i)));
				apiData.setLastName(dataFormatter.formatCellValue(row.getCell(++i)));
				apiData.setContactInfo(dataFormatter.formatCellValue(row.getCell(++i)));
				apiData.setEmail(dataFormatter.formatCellValue(row.getCell(++i)));
				Address address = new Address();
				address.setPlotNumber(dataFormatter.formatCellValue(row.getCell(++i)));
				address.setStreet(dataFormatter.formatCellValue(row.getCell(++i)));
				address.setState(dataFormatter.formatCellValue(row.getCell(++i)));
				address.setCountry(dataFormatter.formatCellValue(row.getCell(++i)));
				address.setZipCode(dataFormatter.formatCellValue(row.getCell(++i)));
				apiData.setUserAddress(address);
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(apiData);
		System.out.println(jsonString);
		return jsonString;
	}

	
}
