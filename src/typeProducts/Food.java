package typeProducts;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Product;

public class Food extends Product {
	public Date expirationDate;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");;

	TypeProduct type = TypeProduct.FOOD;

	@Override
	public Double totalTypeValue(Integer quantity, Double price) {

		return null;
	}

	public Food(String name, Integer quantity, Double price, TypeProduct type, Date expirationDate) {
		super(name, quantity, price);
		type = TypeProduct.FOOD;
		this.expirationDate = expirationDate;

	}

	@Override
	public String toString() {
		String strDate = sdf.format(expirationDate);
		return String.format("Name: %s \n Quantity: %d \n Price: %.2f \n Type: %s", name, quantity, price, type,
				strDate);
	}
//	System.out.print("Data(DD/MM/YYYY): ");
//	Date data = scHora.parse(sc.next());

}
