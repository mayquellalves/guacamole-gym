package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

import model.Equipment;

public class Dao {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("gym").createEntityManager();

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void save(Equipment equipment) {

		try {
			entityManager.getTransaction().begin();
			if (equipment.getId() == null) {
				entityManager.persist(equipment);
			} else {
				entityManager.merge(equipment);
			}

			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			System.out.println(" Ocorreu um erro ao tentar salvar " + e.getMessage());
		}
	}

	public List<Equipment> findAllEquipment() {
		Query query = entityManager.createQuery("SELECT e FROM Equipment e");
		return (List<Equipment>) query.getResultList();
	}

	public String delete(Equipment equipment) {
		try {
			equipment = entityManager.find(Equipment.class, equipment.getId());
			entityManager.getTransaction().begin();
			entityManager.remove(equipment);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			System.out.println(" Ocorreu um erro ao tentar Remover: " + e.getMessage());
		}
		return Response.status(200).toString();
	}
}
