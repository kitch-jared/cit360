package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.City;

public class ReadCity {

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
			List<City> cities = session.createQuery("from City C WHERE C.district = 'Arizona'").getResultList();
			
			City gilbert = (City)session.createQuery("from City C WHERE C.name = 'Gilbert'").getSingleResult();
			
			// display the cities
			System.out.println("\n\nThis is a list of Arizona cities."
					           + "\n---------------------------------");
			for (City thisCity : cities) {
				System.out.println(thisCity);
			}
			
			System.out.println("\n\nThis is the population of Gilbert."
	                           + "\n----------------------------------");
			System.out.println(gilbert.getPopulation());
			
			int gilbertId = gilbert.getId();
			
			// get a single city
			City tempCity = session.get(City.class, gilbertId);
			
			System.out.println("\n\nThis is the single retrieved record."
                               + "\n------------------------------------");
			System.out.println(tempCity);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("\n\nDone\n\n");
			
		} finally {
			factory.close();
		}
		
	}

}
