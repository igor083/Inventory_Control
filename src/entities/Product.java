package entities;

public abstract class Product {
	public String Name;
	public Integer Quantity;
	public Double Price;

	
	
	public String getName() {
		return Name;
	}



	public Integer getQuantity() {
		return Quantity;
	}



	public Double getPrice() {
		return Price;
	}
//contructors
	public Product() {}

	public Product(String name, Integer quantity, Double price) {
		Name = name;
		Quantity = quantity;
		Price = price;
	}



	public abstract Double totalValue(Integer quantity,Double price);
}
