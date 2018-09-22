package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
import service.EmployeeServiceImpl;
import model.Employee;

@WebServlet("/employeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final EmployeeService employeeService = new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String employeeName = req.getParameter("name");
		String employeeSurname = req.getParameter("surname");
		int employeeSalary = Integer.parseInt(req.getParameter("salary"));

		Employee employee = new Employee(employeeName, employeeSurname, employeeSalary);
		employeeService.insertEmployee(employee);

		List<Employee> allEmployees = employeeService.findAllEmployees();
		req.setAttribute("allEmployees", allEmployees);
		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		employeeService.removeEmployee(employeeId);

		List<Employee> allEmployees = employeeService.findAllEmployees();
		req.setAttribute("allEmployees", allEmployees);
		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);
	}

}
