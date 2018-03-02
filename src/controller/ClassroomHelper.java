package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Classroom;

public class ClassroomHelper {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CourseRegistrationSystem");

	public void insertClassroom(Classroom toAdd) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<Classroom> showAllClassrooms() {
		
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Classroom> allResults = em.createQuery("select li from Classroom li", Classroom.class);
		List<Classroom> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}

	public void deleteClassroom(Classroom toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Classroom> typedQuery = em.createQuery("select li from Classroom li where li.id = :selectedId", Classroom.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		//typedQuery.setParameter("selectedItem", toDelete.getRoomNumber());
		typedQuery.setMaxResults(1);
		Classroom result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public Classroom searchForClassroomById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Classroom foundClassroom = em.find(Classroom.class, idToEdit);
		em.close();
		return foundClassroom;
	}

	public void updateClassroom(Classroom toEdit) {
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
