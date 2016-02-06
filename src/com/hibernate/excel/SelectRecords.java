package com.hibernate.excel;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SelectRecords {

	public List<Employee> getRecords(Session session){
		Query query=session.createQuery("from Employee");
		List<Employee> list=query.list();
		return list;
	}
}