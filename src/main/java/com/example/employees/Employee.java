package com.example.employees;

import java.util.Date;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;

public class Employee {
	@CsvBindByName
	private int employeeId;
	@CsvBindByName
	private int projectId;
	@CsvDate(value = "yyyy/MM/dd")
	@CsvBindByName
	private Date dateFrom;
	@CsvCustomBindByName(converter = DateToConverter.class)
	private Date dateTo;
	
	
	public Employee() {
		super();
	}


	public Employee(int employeeId, int projectId, Date dateFrom, Date dateTo) {
		super();
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public Date getDateFrom() {
		return dateFrom;
	}


	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}


	public Date getDateTo() {
		return dateTo;
	}


	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
	public String toString() {
		return this.employeeId + " - " + this.projectId + " - " + this.dateFrom + " - " + this.dateTo; 
	}
}
