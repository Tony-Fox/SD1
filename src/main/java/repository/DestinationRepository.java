package repository;

import entity.Destination;
import entity.Vacation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DestinationRepository {
	public static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

	public Destination CreateDestination(int destination_id, String destinationName) {
		Destination destination = new Destination(destination_id, destinationName);
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(destination);
		em.getTransaction().commit();
		em.close();
		return destination;
	}

	public List getDestinations() {
		List destinationList = new ArrayList();
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		destinationList = em.createQuery("select destination from Destination destination").getResultList();
		return destinationList;
	}

	public Destination getDestinationById(int destinationId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Destination destination = em.find(Destination.class, destinationId);
		em.getTransaction().commit();
		em.close();
		return destination;
	}

	public void updateDestinationById(int destinationId, int updatedId, String updatedName) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Destination destination = em.find(Destination.class, destinationId);
		destination.setDestination_id(updatedId);
		destination.setDestinationName(updatedName);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteDestinationById(int destinationId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Destination.class, destinationId));
		em.getTransaction().commit();
		em.close();
	}

}
