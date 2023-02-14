package typeProducts;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Product;

public class Food extends Product {
	private Date expirationDate;

	public Date getExpirationDate() {
		return expirationDate;
	}

	public TypeProduct getType() {
		return type;
	}

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");;

	private TypeProduct type = TypeProduct.FOOD;

	@Override
	public Double totalTypeValue(Integer quantity, Double price) {

		return null;
	}

	public Food(String name, Double price, Date expirationDate) {
		super(name, price);
		type = TypeProduct.FOOD;
		this.expirationDate = expirationDate;

	}
	public Food(String name, Date expirationDate) {
		super(name);
		type = TypeProduct.FOOD;
		this.expirationDate = expirationDate;
		
	}

	public Food(Date expirationDate) {
		super();
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		String strDate = sdf.format(expirationDate);
		return String.format("Name: %s \n Quantity: %d \n Price: %.2f \n Type: %s", this.getName(), this.getQuantity(),
				this.getPrice(), type, strDate);
	}
//	System.out.print("Data(DD/MM/YYYY): ");
//	Date data = scHora.parse(sc.next());

}
