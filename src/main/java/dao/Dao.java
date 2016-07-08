package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import model.AbstractModel;

public class Dao<Model extends AbstractModel> {

	private final EntityManager entityManager;
	private final JpaUtil jpaUtil;
	private final Class<Model> modelClass;

	@SuppressWarnings("unchecked")
	public Dao() {
		this.jpaUtil = JpaUtil.getInstance();
		this.entityManager = jpaUtil.getEntityManager();
		for (int i = 0; i < 5; i++) {
			System.out.println(JpaUtil.getInstance());
		}
		modelClass = (Class<Model>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}

	@SuppressWarnings("unchecked")
	public List<Model> findAll() {
		
		 CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		 CriteriaQuery<Model> criteriaQuery = criteriaBuilder.createQuery(modelClass);
		 criteriaQuery.from(modelClass);
		 entityManager.createQuery(criteriaQuery);
		 
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public Model findOne(Long id) {

		return (Model) entityManager.find(modelClass, id);
	}

	/*public void save(Model model) {

		try {
			entityManager.getTransaction().begin();
			if (model.getId() == null) {
				entityManager.persist(model);
			} else {
				entityManager.merge(model);
			}

			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			System.out.println(" Ocorreu um erro ao tentar salvar " + e.getMessage());
		}
	}

		try {
			entityManager.getTransaction().begin();
			entityManager.remove(id);
			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {
			System.out.println(" Ocorreu um erro ao tentar Remover: " + e.getMessage());
		}
		return Response.status(200).toString();
	}*/
}
