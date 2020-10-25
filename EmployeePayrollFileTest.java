package com.bl.assignment;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EmployeePayrollFileTest {

	@Test
	public void given3Employee_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, "Jeff Bezos", 100000),
				new EmployeePayrollData(2, "Bill Gates", 200000),
				new EmployeePayrollData(3, "Mark Zuckerberg", 300000) };
		EmployeePayrollService employeeService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeeService.writeEmployeeData(EmployeePayrollService.IOService.FILE_IO);
		long entries = employeeService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		employeeService.printData(EmployeePayrollService.IOService.FILE_IO);
		long value = 3;
		assertEquals(value, entries);

	}

}