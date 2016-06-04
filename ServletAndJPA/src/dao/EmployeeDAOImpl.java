package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import utility.EntityManagerUtility;
import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl() {
		EntityManagerFactory entityManagerFactory = EntityManagerUtility.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Employee createEmployee(String name, String surname, int salary) {
		Employee employee = new Employee(name, surname, salary);
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		return employee;
	}

	@Override
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("Select e from Employee e", Employee.class);
		return query.getResultList();

	}

	@Override
	public void removeEmployee(int id) {
		Employee employee = findEmployee(id);
		if (employee != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(employee);
			entityManager.getTransaction().commit();
		}
	}
}
