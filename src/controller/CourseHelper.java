package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Course;

public class CourseHelper {
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CourseRegistrationSystem");

	public void insertClassroom(Course toAdd) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<Course> showAllCourses() {
		
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Course> allResults = em.createQuery("select li from Course li", Course.class);
		List<Course> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}

	public void deleteCourse(Course toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Course> typedQuery = em.createQuery("select li from Course li where li.crn = :selectedCRN and li.courseName = :selectedCourseName", Course.class);
		typedQuery.setParameter("selectedCRN", toDelete.getCRN());
		typedQuery.setParameter("selectedCourseNAme", toDelete.getCourseName());
		typedQuery.setMaxResults(1);
		Course result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public Course searchForCourseById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Course foundCourse = em.find(Course.class, idToEdit);
		em.close();
		return foundCourse;
	}

	public void updateCourse(Course toEdit) {
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
