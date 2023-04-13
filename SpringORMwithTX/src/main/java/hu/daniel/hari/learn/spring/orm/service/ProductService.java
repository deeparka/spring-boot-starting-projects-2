package hu.daniel.hari.learn.spring.orm.service;

import hu.daniel.hari.learn.spring.orm.dao.ProductDao;
import hu.daniel.hari.learn.spring.orm.model.Product_ORM;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	public void add(Product_ORM product) {
		productDao.persist(product);
	}
	
	@Transactional
	public void addAll(Collection<Product_ORM> products) {
		for (Product_ORM product : products) {
			productDao.persist(product);
		}
	}

	@Transactional(readOnly = true)
	public List<Product_ORM> listAll() {
		return productDao.findAll();

	}

}
