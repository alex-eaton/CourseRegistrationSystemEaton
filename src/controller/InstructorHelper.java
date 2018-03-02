package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Instructor;

public class InstructorHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CourseRegistrationSystem");

	public void insertInstructor(Instructor toAdd) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<Instructor> showAllInstructors() {
		
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Instructor> allResults = em.createQuery("select li from Instructor li", Instructor.class);
		List<Instructor> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}

	public void deleteInstructor(Instructor toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Instructor> typedQuery = em.createQuery("select li from Instructor li where li.id = :selectedId", Instructor.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Instructor result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public Instructor searchForInstructorById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Instructor foundInstructor = em.find(Instructor.class, idToEdit);
		em.close();
		return foundInstructor;
	}

	public void updateInstructor(Instructor toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
/*
	public List<Classroom> searchForItemByStore(String storeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Classroom> typedQuery = em.createQuery("select li from Classroom li where li.store = :selectedStore", Classroom.class);
		typedQuery.setParameter("selectedStore", storeName);
		List<Classroom> result = typedQuery.getResultList();
		em.close();
		return result;
	}

	public List<Classroom> searchForItemByName(String itemName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Classroom> typedQuery = em.createQuery("select li from Classroom li where li.item = :selectedItem", Classroom.class);
		typedQuery.setParameter("selectedItem", itemName);
		List<Classroom> result = typedQuery.getResultList();
		em.close();
		return result;
	}
*/

}
