package com.example.employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHelper {
	
	public long getMaxDaysWorkedTogether(Employee firstEmployee, Employee secondEmployee) {
		long maxDays = 0;
		long laterDateFrom = 0;
		long priorDateTo = 0;
		
		if (firstEmployee.getEmployeeId() == secondEmployee.getEmployeeId() || firstEmployee.getProjectId() != secondEmployee.getProjectId() 
				|| firstEmployee.getDateFrom().getTime() > secondEmployee.getDateTo().getTime() 
				|| firstEmployee.getDateTo().getTime() < secondEmployee.getDateFrom().getTime()) {
			
			return maxDays;
		} else {
			if (firstEmployee.getDateFrom().getTime() > secondEmployee.getDateFrom().getTime()) {
				laterDateFrom = firstEmployee.getDateFrom().getTime();
			} else {
				laterDateFrom = secondEmployee.getDateFrom().getTime();
			}
			
			if (firstEmployee.getDateTo().getTime() < secondEmployee.getDateTo().getTime()) {
				priorDateTo = firstEmployee.getDateTo().getTime();
			} else {
				priorDateTo = secondEmployee.getDateTo().getTime();
			}

			long difference = Math.abs(priorDateTo - laterDateFrom);
	        maxDays = difference / (24 * 60 * 60 * 1000);	
		}
				
		return maxDays;
	}
}
