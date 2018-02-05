package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.City;

public class UpdateCity {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(City.class)
									.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// query cities			
			City gilbert = (City)session.createQuery("from City C WHERE C.name = 'Gilbert'").getSingleResult();
			
			// display the population before update
			System.out.println("\n\nThis is the population of Gilbert prior to update."
	                           + "\n--------------------------------------------------");
			System.out.println(gilbert.getPopulation());
			
			// update population
			gilbert.setPopulation(gilbert.getPopulation() + 1);
			
			// commit transaction
			session.getTransaction().commit();
			
			// display the population after update
			System.out.println("\n\nThis is the population of Gilbert after a baby is born."
	                           + "\n-------------------------------------------------------");
			System.out.println(gilbert.getPopulation());

			// start a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// show cities before update
			List<City> cities = session.createQuery("from City C WHERE C.district = 'Arizona'").getResultList();			
			// display the cities
			System.out.println("\n\nThis is a list of Arizona cities."
					           + "\n---------------------------------");
			for (City thisCity : cities) {
				System.out.println(thisCity);
			}
			
			// do a bulk update
			session.createQuery("update City C set C.district = 'AZ' "
					          + "WHERE C.district = 'Arizona'")
			                  .executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			// start a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// show cities after update
			List<City> newCities = session.createQuery("from City C WHERE C.district = 'AZ'").getResultList();			
			// display the cities
			System.out.println("\n\nThis is a list of Arizona cities."
					           + "\n---------------------------------");
			for (City thisCity : newCities) {
				System.out.println(thisCity);
			}
			
			// set AZ cities back to Arizona
			session.createQuery("update City C set C.district = 'Arizona' "
			          + "WHERE C.district = 'AZ'")
	                  .executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("\n\nDone\n\n");
			
		} finally {
			factory.close();
		}
		
	}

}
