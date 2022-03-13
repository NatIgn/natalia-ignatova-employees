package com.example.employees;

public class EmployeesCouple {
	public int firstEmployeeId;
	public int secondEmployeeId;
	
	public EmployeesCouple() {
		super();
	}

	public EmployeesCouple(int firstEmployeeId, int secondEmployeeId) {
		super();
		this.firstEmployeeId = firstEmployeeId;
		this.secondEmployeeId = secondEmployeeId;
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

	@Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.firstEmployeeId;
        hash = 89 * hash + this.secondEmployeeId;
        return hash;
    }

	@Override 
	public boolean equals(Object empCouple) {
		if (empCouple == this) {
            return true;
        }

        if (!(empCouple instanceof EmployeesCouple)) {
            return false;
        }

        EmployeesCouple employeeCouple = (EmployeesCouple) empCouple;

        return this.firstEmployeeId == employeeCouple.firstEmployeeId && this.secondEmployeeId == employeeCouple.secondEmployeeId;
	}

}
