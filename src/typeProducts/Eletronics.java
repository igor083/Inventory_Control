package typeProducts;

import entities.Product;

public class Eletronics extends Product {

	public TypeProduct getType() {
		return type;
	}

	private TypeProduct type = TypeProduct.ELETRONICS;

	@Override
	public Double totalTypeValue(Integer quantity, Double price) {

		return null;
	}

	public Eletronics(String name, Double price) {
		super(name, price);
		type = TypeProduct.ELETRONICS;

	}

	

	public Eletronics(String name, Integer quantity, Double price) {
		super(name, quantity, price);
	}

	@Override
	public String toString() {
		return String.format("Name: %s \n Quantity: %d \n Price: %.2f \n Type: %s", this.getName(), this.getQuantity(),
				this.getPrice(), type);
	}
//	System.out.print("Data(DD/MM/YYYY): ");
//	Date data = scHora.parse(sc.next());

}