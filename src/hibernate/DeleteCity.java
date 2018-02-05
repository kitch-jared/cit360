package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.City;

public class DeleteCity {

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
			
			// Create some dummy cities
			City newCity1 = new City("City1", "USA", "Nowhere", 111111);
			City newCity2 = new City("City2", "USA", "Nowhere", 222222);
			City newCity3 = new City("City3", "USA", "Nowhere", 333333);
			session.save(newCity1);
			session.save(newCity2);
			session.save(newCity3);
			
			// query cities			
			City gilbert = (City)session.createQuery("from City C WHERE C.name = 'Gilbert'").getSingleResult();
			
			// delete the record
			System.out.println("Deleting: " + gilbert);
			session.delete(gilbert);
			
			// commit transaction
			session.getTransaction().commit();
			
			// start a new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// show cities without Gilbert
			List<City> cities = session.createQuery("from City C WHERE C.district = 'Arizona'").getResultList();			
			// display the cities
			System.out.println("\n\nThis is a list of Arizona cities."
					           + "\n---------------------------------");
			for (City thisCity : cities) {
				System.out.println(thisCity);
			}
		
			// show cities in Nowhere
			List<City> noCities = session.createQuery("from City C WHERE C.district = 'Nowhere'").getResultList();			
			// display the cities
			System.out.println("\n\nThis is a list of Nowhere cities."
					           + "\n---------------------------------");
			for (City thisCity : noCities) {
				System.out.println(thisCity);
			}
			
			session.createQuery("delete from City C where C.district = 'Nowhere'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			// start a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// show cities in Nowhere
			List<City> nowhereCities = session.createQuery("from City C WHERE C.district = 'Nowhere'").getResultList();			
			// display the cities
			System.out.println("\n\nThis is a list of Nowhere cities."
					           + "\n---------------------------------");
			for (City thisCity : nowhereCities) {
				System.out.println(thisCity);
			}
			
			// recreate Gilbert for re-run
			City newGilbert = new City("Gilbert", "USA", "Arizona", 237133);
			session.save(newGilbert);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("\n\nDone\n\n");
			
		} finally {
			factory.close();
		}
		
	}

}
