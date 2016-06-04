package utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("EmployeePersistenceUnit");

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
