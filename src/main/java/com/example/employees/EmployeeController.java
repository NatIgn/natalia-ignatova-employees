package com.example.employees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class EmployeeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/upload-file")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select file from your file system to be uploaded!");
			model.addAttribute("status", false);
		} else {
			List<Employee> employeesList = null;
			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				CsvToBean<Employee> csvToBean = new CsvToBeanBuilder(reader).withType(Employee.class).withIgnoreLeadingWhiteSpace(true).build();
				employeesList = csvToBean.parse();
			} catch (Exception ex) {
				model.addAttribute("message", "An error occured");
				model.addAttribute("status", true);
			}
			EmployeeHelper empHelper = new EmployeeHelper();
			Map<EmployeesCouple, Long> pairsMaxDaysTogether = new HashMap<>();
			long maxDays = empHelper.getMaxDaysWorkedTogether(employeesList.get(0), employeesList.get(1));
			List<EmployeesPair> empsPairs = new ArrayList<>();
				
			for (int i = 0; i < employeesList.size() - 1; i++) {
				for (int j = i + 1; j < employeesList.size(); j++) {
					long max = empHelper.getMaxDaysWorkedTogether(employeesList.get(i), employeesList.get(j));
					if (max != 0) {
						EmployeesPair empsPair = null;
						if(employeesList.get(i).getEmployeeId() < employeesList.get(j).getEmployeeId()) {
							empsPair = new EmployeesPair(employeesList.get(i).getEmployeeId(), employeesList.get(j).getEmployeeId(), employeesList.get(i).getProjectId(), max);
						} else {
								empsPair = new EmployeesPair(employeesList.get(j).getEmployeeId(), employeesList.get(i).getEmployeeId(), employeesList.get(i).getProjectId(), max);
						}					
						empsPairs.add(empsPair);

						EmployeesCouple empsCouple = new EmployeesCouple(empsPair.getFirstEmployeeId(), empsPair.getSecondEmployeeId());
						if (pairsMaxDaysTogether.containsKey(empsCouple)) {
							long pairsMaxDays = pairsMaxDaysTogether.get(empsCouple) + max;
							pairsMaxDaysTogether.put(empsCouple, pairsMaxDays);
						} else {
							pairsMaxDaysTogether.put(empsCouple, max);
						}
					}
				}
			}
			long longestPeriodForPair = 0; 
			EmployeesCouple coupleWithLongestPeriod = null;
			for(EmployeesCouple emps: pairsMaxDaysTogether.keySet()) {
				if (pairsMaxDaysTogether.get(emps) > longestPeriodForPair) {
					longestPeriodForPair = pairsMaxDaysTogether.get(emps);
					coupleWithLongestPeriod = emps;
				}
			}
			List<EmployeesPair> projectPairsWorkedLongest = new ArrayList<>();
			
			for (EmployeesPair employeesPair : empsPairs) {
				if(employeesPair.getFirstEmployeeId() == coupleWithLongestPeriod.getFirstEmployeeId() && employeesPair.getSecondEmployeeId() == coupleWithLongestPeriod.getSecondEmployeeId()) {
					projectPairsWorkedLongest.add(employeesPair);
				}
			}
			
			model.addAttribute("couple", coupleWithLongestPeriod);
			model.addAttribute("empsPairs", projectPairsWorkedLongest);
			model.addAttribute("status", true);
		}
		return "file-upload-status";
	}
}
