package repository;

import entity.Destination;
import entity.Vacation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class VacationRepository {
	public static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

	public Vacation createVacation(int vacation_id, String name, int price, int period, String extra_details, int max_people, Destination vacation_destination_id) {
		Vacation vacation = new Vacation(vacation_id, name, price, period, extra_details, max_people, vacation_destination_id);

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(vacation);
		em.getTransaction().commit();
		em.close();
		return vacation;
	}

	public List getVacations() {
		List vacationList = new ArrayList();
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		vacationList = em.createQuery("select vacation from Vacation vacation").getResultList();
		return vacationList;
	}

	public Vacation getVacationById(int vacationId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Vacation vacation = em.find(Vacation.class, vacationId);
		em.getTransaction().commit();
		em.close();
		return vacation;
	}

	public void deleteVacationById(int vacationId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Vacation.class, vacationId));
		em.getTransaction().commit();
		em.close();
	}

	public void updateVacationById(int vacationId, String name, int price, int period, String extra_details, int max_people) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Vacation vacation = em.find(Vacation.class, vacationId);

		vacation.setName(name);
		vacation.setPrice(price);
		vacation.setPeriod(period);
		vacation.setExtra_details(extra_details);
		vacation.setMax_people(max_people);

		em.getTransaction().commit();
		em.close();
	}

	public void deleteVacationsByDestinationId(int destinationId) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		em.createQuery("delete from Vacation vacation where vacation.destination.destination_id=:destId")
				.setParameter("destId", destinationId)
						.executeUpdate();

		em.getTransaction().commit();
		em.close();
	}

}
