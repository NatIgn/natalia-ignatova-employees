package com.example.employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class DateToConverter extends AbstractBeanField {
    @Override
    protected Object convert(String dateTo) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
    	Date employeeDateTo = null;
        if (!dateTo.trim().equalsIgnoreCase("NULL")) {
			try {
				employeeDateTo = new SimpleDateFormat("yyyy/MM/dd").parse(dateTo);
			} catch (ParseException e) {
				Logger.getLogger(EmployeeHelper.class.getName()).log(Level.SEVERE, "Exception while parsing dateTo attribute", e);
			}  
		} else {
			employeeDateTo = new Date();
		}
        
        return employeeDateTo;
  }

}
