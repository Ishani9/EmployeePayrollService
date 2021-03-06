package com.bl.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	};

	public List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public EmployeePayrollService() {
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);

		String choice = "yes";
		do {
			if (choice.equalsIgnoreCase("yes")) {
				employeePayrollService.readEmployeeData(IOService.CONSOLE_IO);
				scanner.nextLine();
				System.out.println("Want to enter new employee payroll data?");
				choice = scanner.nextLine();
			}
		} while (choice.equalsIgnoreCase("yes"));
		employeePayrollService.writeEmployeeData(IOService.FILE_IO);
		employeePayrollService.readEmployeeData(IOService.FILE_IO);
	}

	public void readEmployeeData(IOService ioService) {
		Scanner scanner = new Scanner(System.in);
		if (ioService.equals(IOService.CONSOLE_IO)) {
			System.out.println("Enter Employee ID : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter Employee Name : ");
			String name = scanner.nextLine();
			System.out.println("Enter Employee Salary : ");
			double salary = scanner.nextDouble();
			employeePayrollList.add(new EmployeePayrollData(id, name, salary));
		} else if (ioService.equals(IOService.FILE_IO)) {
			System.out.println("reading data from file");
			new EmployeePayrollFile().printData();
		}
	}

	public void writeEmployeeData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
		else if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFile().writeData(employeePayrollList);
		}
	}

	public long countEntries(IOService fileIo) {
		long entries = 0;
		if (fileIo.equals(IOService.FILE_IO)) {
			entries = new EmployeePayrollFile().countEntries();
		}
		return entries;
	}
	
	/**
	 * UC 5
	 * 
	 * Prints data from file to console
	 * 
	 * @param ioService
	 */
	public void printData(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFile().printData();
		}
		
	}

}