package com.hibernate.excel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExcelApp {

	public static void main(String[] args)throws IOException {
	Session session=configureHibernate();
	SelectRecords select=new SelectRecords();
	List<Employee> list=select.getRecords(session);
	StoreRecords records=new StoreRecords();
	records.storeInFile(list);
	ReadExcel read=new ReadExcel();
	read.getEmployeeSalary(getInput());
	}
	
	private static Session configureHibernate(){
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		return session;
	}
	private static String getInput(){
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter User Name: ");
		String input=scanner.next();
		scanner.close();
		return input;
	}
}