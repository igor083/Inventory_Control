package entities;

import typeProducts.TypeProduct;

public abstract class Product {
	public String name;
	public Integer quantity;
	public Double price;
	public TypeProduct type;

	
	
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



	public abstract Double totalTypeValue(Integer quantity,Double price);
}
