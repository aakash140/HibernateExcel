package com.hibernate.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StoreRecords {

	private int rowNumber;
	private int cellNumber;
	public void storeInFile(List<Employee> list)throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("EmployeeRecords");
		XSSFRow row=spreadsheet.createRow(rowNumber++);
	    
	    
	    XSSFFont font=workbook.createFont();
	    font.setBold(true);
	    XSSFCellStyle style=workbook.createCellStyle();
	    style.setFont(font);
	    
	    
	    XSSFCell cell=row.createCell(cellNumber++);
	    cell.setCellValue("EMP ID");
	    cell.setCellStyle(style);
	    
	    cell=row.createCell(cellNumber++);
	    cell.setCellValue("FIRST NAME");
	    cell.setCellStyle(style);
	    
	    cell=row.createCell(cellNumber++);
	    cell.setCellValue("LAST NAME");
	    cell.setCellStyle(style);
	    
	    cell=row.createCell(cellNumber++);
	    cell.setCellValue("AGE");
	    cell.setCellStyle(style);
	    
	    cell=row.createCell(cellNumber++);
	    cell.setCellValue("SALARY");
	    cell.setCellStyle(style);
	    
		for(Employee employee:list){
			row=spreadsheet.createRow(rowNumber++);
			
	         cell=row.createCell(0);
	         cell.setCellValue(employee.getId());
	         
	         cell=row.createCell(1);
	         cell.setCellValue(employee.getFirstName());
	         
	         cell=row.createCell(2);
	         cell.setCellValue(employee.getLastName());
	         
	         cell=row.createCell(3);
	         cell.setCellValue(employee.getAge());
	         
	         cell=row.createCell(4);
	         cell.setCellValue(employee.getSalary());
	    }
		
		row=spreadsheet.createRow(rowNumber);
		cell=row.createCell(0);
		cell.setCellValue("TOTAL:");
		cell.setCellStyle(style);
		
		cell=row.createCell(4);
		cell.setCellType(XSSFCell.CELL_TYPE_FORMULA);
		cell.setCellFormula("SUM(E2:E6)");
		cell.setCellStyle(style);
		
		
		for(int i=0;i<cellNumber;i++)
			spreadsheet.autoSizeColumn(i);
		
		FileOutputStream out=
						new FileOutputStream("C:/Documents and Settings/akash.gupta/Desktop/EmployeeRecords.xlsx");
		workbook.write(out);
		out.close();
		System.out.println("Success");
	}
}