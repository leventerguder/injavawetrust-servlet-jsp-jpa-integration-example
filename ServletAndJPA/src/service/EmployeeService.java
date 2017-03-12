package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	
	public Employee insertEmployee(Employee employee);

	public Employee findEmployee(int id);

	public List<Employee> findAllEmployees();

	public void removeEmployee(int id);
}
