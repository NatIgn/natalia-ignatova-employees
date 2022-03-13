package com.example.employees;

public class EmployeesPair {
	int firstEmployeeId;
	int secondEmployeeId;
	int projectId;
	long daysWorkedTogether;
	
	public EmployeesPair() {
		super();
	}

	public EmployeesPair(int firstEmployeeId, int secondEmployeeId, int projectId, long daysWorkedTogether) {
		super();
		this.firstEmployeeId = firstEmployeeId;
		this.secondEmployeeId = secondEmployeeId;
		this.projectId = projectId;
		this.daysWorkedTogether = daysWorkedTogether;
	}

	public int getFirstEmployeeId() {
		return firstEmployeeId;
	}

	public void setFirstEmployeeId(int firstEmployeeId) {
		this.firstEmployeeId = firstEmployeeId;
	}

	public int getSecondEmployeeId() {
		return secondEmployeeId;
	}

	public void setSecondEmployeeId(int secondEmployeeId) {
		this.secondEmployeeId = secondEmployeeId;
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
