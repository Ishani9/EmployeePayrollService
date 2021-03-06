package com.bl.assignment;

public class EmployeePayrollData {
	
	public int id;
	public String name;
	public double salary;

	public EmployeePayrollData(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return "ID = " + id + ", NAME = " + name  + ", SALARY = " + salary;
	}

}
