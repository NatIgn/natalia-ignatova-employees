package com.example.employees;

public class EmployeesCouple {
	public Employee firstEmployee;
	public Employee secondEmployee;
	
	public EmployeesCouple() {
		super();
	}

	public EmployeesCouple(Employee firstEmployee, Employee secondEmployee) {
		super();
		this.firstEmployee = firstEmployee;
		this.secondEmployee = secondEmployee;
	}

	public Employee getFirstEmployee() {
		return firstEmployee;
	}
	
	public void setFirstEmployee(Employee firstEmployee) {
		this.firstEmployee = firstEmployee;
	}

	public Employee getSecondEmployee() {
		return secondEmployee;
	}

	public void setSecondEmployee(Employee secondEmployee) {
		this.secondEmployee = secondEmployee;
	}

	@Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.firstEmployee.getEmployeeId();
        hash = 89 * hash + this.secondEmployee.getEmployeeId();
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

        return this.firstEmployee.getEmployeeId() == employeeCouple.getFirstEmployee().getEmployeeId() && this.secondEmployee.getEmployeeId() == employeeCouple.getSecondEmployee().getEmployeeId();
	}

}
