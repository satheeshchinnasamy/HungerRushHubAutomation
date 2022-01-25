package com.hub.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hub.constants.FrameworkConstants;
/**
 * <P>Method to read the data from excel and store it in the list</P>
 * 25-Jan-2022
 * @author satheesh.c
 * @Version 1.0
 */
public final class ExcelUtils {

/**
 * Private constructor to avoid external instantiation
 */
	private ExcelUtils() {

	}
	public static List<Map<String,String>> getTestDetails(String sheetname){

		List<Map<String,String>> list=null;
		FileInputStream fs=null;
		try {
			fs = new FileInputStream(FrameworkConstants.getExcelpath());
			XSSFWorkbook workbook=new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetname);

			int lastrownum = sheet.getLastRowNum();
			int lastcolumnnum = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list =new ArrayList<Map<String, String>>();
			
			for(int i=1; i<=lastrownum; i++) {
				map=new HashMap<String, String>();
				for(int j=0; j<lastcolumnnum; j++) {
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(Objects.nonNull(fs)) {
					fs.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;

	}
}
