package com.hibernate.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	private FileInputStream fin;
	public void getEmployeeSalary(String name)throws IOException {
		XSSFSheet sheet=getSheet(0);
		Iterator<Row> rowIterator=sheet.iterator();
		XSSFRow row=(XSSFRow)rowIterator.next();
		while(rowIterator.hasNext()){
			row=(XSSFRow)rowIterator.next();
			XSSFCell cell=row.getCell(1);
			if(name.equalsIgnoreCase(cell.getStringCellValue())){
				cell=row.getCell(4);
				System.out.println(name+"'s salary is:"+ cell.getNumericCellValue());
				break;
			}
		}
		fin.close();
	}
	
	public XSSFSheet getSheet(int sheetNumber)throws IOException{
		fin=new FileInputStream(
				new File("C:/Documents and Settings/akash.gupta/Desktop/EmployeeRecords.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fin);
		XSSFSheet sheet=workbook.getSheetAt(0);
		return sheet;
	}
}