package hu.daniel.hari.learn.spring.orm.dao;

import hu.daniel.hari.learn.spring.orm.model.Product_ORM;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class ProductDao {

	@PersistenceContext
	private EntityManager em;      // this is created once per application

	public void persist(Product_ORM product) {      // product record will be inserted into DB
		em.persist(product);
	}

	public List<Product_ORM> findAll() {
		return em.createQuery("SELECT p FROM Product_ORM p").getResultList();   // JPQL 
	}

}
