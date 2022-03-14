package com.example.employees;

public class EmployeesPair {
	private Employee firstEmployee;
	private Employee secondEmployee;
	private int projectId;
	private long daysWorkedTogether;
	
	public EmployeesPair() {
		super();
	}

	public EmployeesPair(Employee firstEmployee, Employee secondEmployee, int projectId, long daysWorkedTogether) {
		super();
		this.firstEmployee = firstEmployee;
		this.secondEmployee = secondEmployee;
		this.projectId = projectId;
		this.daysWorkedTogether = daysWorkedTogether;
	}

	public Employee getFirstEmployee() {
		return firstEmployee;
	}

	public void setFirstEmployeeId(Employee firstEmployee) {
		this.firstEmployee = firstEmployee;
	}

	public Employee getSecondEmployee() {
		return secondEmployee;
	}

	public void setSecondEmployeeId(Employee secondEmployee) {
		this.secondEmployee = secondEmployee;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public long getDaysWorkedTogether() {
		return daysWorkedTogether;
	}

	public void setDaysWorkedTogether(long daysWorkedTogether) {
		this.daysWorkedTogether = daysWorkedTogether;
	}
}
