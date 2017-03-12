package service;

import java.util.List;

import model.Employee;
import dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAOImpl employeeDAOImpl;

	public EmployeeServiceImpl() {
		employeeDAOImpl = new EmployeeDAOImpl();
	}

	@Override
	public Employee insertEmployee(Employee employee) {
		return employeeDAOImpl.insertEmployee(employee);
	}

	@Override
	public Employee findEmployee(int id) {
		return employeeDAOImpl.findEmployee(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeDAOImpl.findAllEmployees();

	}

	@Override
	public void removeEmployee(int id) {
		employeeDAOImpl.removeEmployee(id);
	}
}
