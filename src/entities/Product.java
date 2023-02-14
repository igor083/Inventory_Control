package entities;

import typeProducts.TypeProduct;

public abstract class Product {
	private String name;
	private Integer quantity;
	private Double price;
	private TypeProduct type;

	
	
	public String getName() {
		return name;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public Double getPrice() {
		return price;
	}
//contructors
	public Product() {}

	public Product(String name, Integer quantity, Double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	
	}



	public Product(String name, Double price) {
		this.name=name;
		this.price=price;
	}



	public Product(String name) {
		this.name=name;
}



	public abstract Double totalTypeValue(Integer quantity,Double price);



	public TypeProduct getType() {
		return type;
	}
}
