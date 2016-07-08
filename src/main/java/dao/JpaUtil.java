package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaUtil {

	private EntityManagerFactory factory;
	private static JpaUtil instance;

	private JpaUtil() {
		this.factory = Persistence.createEntityManagerFactory("gym");
	}

	public EntityManager getEntityManager() {
		return this.factory.createEntityManager();
	}
	
	public static JpaUtil getInstance(){
		if(instance == null){
			instance = new JpaUtil();
		}
		return instance;
	}
	
}
