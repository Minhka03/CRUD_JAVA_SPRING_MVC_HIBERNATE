package com.spring_mvc.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carts")

public class Cart {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="image")
	private String image;
	@Column(name="price")
	private Double price;
	@Column(name="quantity")
	private int quantity;
	@Column(name="totalPrice")
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "id_pro",referencedColumnName = "productId")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "id_cus",referencedColumnName = "id")
	private User user;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, String name, String image, Double price, int quantity, Double totalPrice, Product product,
			User user) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
