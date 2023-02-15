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

		return quantity * price;
	}

	public Food(String name,Integer quantity,Double price, Date expirationDate) {
		super(name,quantity, price);
		type = TypeProduct.FOOD;
		this.expirationDate = expirationDate;

	}

	@Override
	public String toString() {
		String strDate = sdf.format(expirationDate);
		return String.format(" Name: %s Quantity: %d Price: %.2f Type: %s", this.getName(), this.getQuantity(),
				this.getPrice(), type, strDate);
	}
//	System.out.print("Data(DD/MM/YYYY): ");
//	Date data = scHora.parse(sc.next());

}
