package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
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

	public void save(Model model) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(model);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			System.out.println(" Ocorreu um erro ao tentar salvar " + e.getMessage());
		}
	}
	
	public void update(Model model) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(model);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			System.out.println(" Ocorreu um erro ao tentar salvar " + e.getMessage());
		}
	}
	
	public void remove(Long id) {
		try {
			Model model = findOne(id);
			
			entityManager.getTransaction().begin();
			entityManager.remove(model);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			System.out.println(" Ocorreu um erro ao tentar remover " + e.getMessage());
		}
	}

}
