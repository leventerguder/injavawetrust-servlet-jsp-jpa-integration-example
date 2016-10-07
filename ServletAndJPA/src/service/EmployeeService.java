package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(String name, String surname, int salary);

	public Employee findEmployee(int id);

	public List<Employee> findAllEmployees();

	public void removeEmployee(int id);
}
