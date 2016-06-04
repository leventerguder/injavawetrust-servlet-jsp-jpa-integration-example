package service;

import java.util.List;

import model.Employee;
import dao.EmployeeDAOImpl;

public class EmployeeServiceImpl {

	private static EmployeeDAOImpl employeeDAOImpl;

	public EmployeeServiceImpl() {
		employeeDAOImpl = new EmployeeDAOImpl();
	}

	private EmployeeDAOImpl getEmployeeDAOImpl() {
		return employeeDAOImpl;
	}

	public Employee createEmployee(String name, String surname, int salary) {
		return getEmployeeDAOImpl().createEmployee(name, surname, salary);
	}

	public Employee findEmployee(int id) {
		return getEmployeeDAOImpl().findEmployee(id);
	}

	public List<Employee> findAllEmployees() {
		return getEmployeeDAOImpl().findAllEmployees();

	}

	public void removeEmployee(int id) {
		getEmployeeDAOImpl().removeEmployee(id);
	}
}
