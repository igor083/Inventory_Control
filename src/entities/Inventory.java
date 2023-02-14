package entities;

import java.util.List;

public class Inventory {
	public List<Product> list;
	
	public Double totalValue() {
		Double ttl=0.0;
		for(Product x : list) {
			ttl+=x.getPrice();
		}
		return ttl;//retorna todo o valor em estoque
	}

	public List<Product> getList() {
		return list;
	}
}
