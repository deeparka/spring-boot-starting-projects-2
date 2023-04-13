package hu.daniel.hari.learn.spring.orm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product_ORM {

	@Id
	private Integer id;
	private String name;

	public Product_ORM() {
	}

	public Product_ORM(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

}
