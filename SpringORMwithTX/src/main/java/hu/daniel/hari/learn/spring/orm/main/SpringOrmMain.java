package hu.daniel.hari.learn.spring.orm.main;

import hu.daniel.hari.learn.spring.orm.model.Product_ORM;
import hu.daniel.hari.learn.spring.orm.service.ProductService;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class SpringOrmMain {
	
	public static void main(String[] args) {
		
		//Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
		//Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
		ProductService productService = ctx.getBean(ProductService.class);   // autowire 
		
		//Do some data operation
//		productService.add(new Product_ORM(1, "Bulb"));
//		productService.add(new Product_ORM(2, "Pen"));
		
		
//		System.out.println("listAll: " + productService.listAll());
		
		
		//Test transaction rollback (duplicated key)
//		try {
//			productService.addAll(Arrays.asList(new Product_ORM(3, "Book"), new Product_ORM(4, "Soap"), new Product_ORM(5, "Computer")));
//		} catch (DataAccessException dataAccessException) {
//		}
		
		
		//Test element list after rollback
		System.out.println("listAll: " + productService.listAll());
		
		
		ctx.close();
		
	}
}
