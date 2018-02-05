package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.City;

public class CreateCity {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(City.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			// create an object
			System.out.println("\n\nCreating an object");
			City newCity = new City("Gilbert", "USA", "Arizona", 237133); // String name, String countryCode, String district, int population
			
			// start a transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("\n\nSaving the object");
			session.save(newCity);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("\n\nDone saving the object to the database\n\n");
			
		} finally {
			factory.close();
		}
		
	}

}
