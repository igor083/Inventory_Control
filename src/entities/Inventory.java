package entities;

import java.util.List;

public class Inventory {
	private List<Product> list;

	public Double totalValue() {
		Double ttl = 0.0;
		for (Product x : list) {
			ttl += x.getPrice();
		}
		return ttl;// retorna todo o valor em estoque
	}

	public List<Product> getList() {
		return list;
	}

	public Inventory() {
	}

	public Inventory(List<Product> list) {
		this.list = list;
	}

	public boolean addNewProduct(List<Product> list, Product p) {//Adiciona um novo produto
		for (Product product : list) {
			if (product.getName().equals(p.getName()) && product.getType().equals(p.getType())) {
				return false;
			}
		}
		list.add(p);
		return true;
	}

	public boolean addProduct(List<Product> list, Product p, Integer quantity) {//Adiciona uma quantidade a um produto ja existente
		for (Product product : list) {
			if (product.getName().equals(p.getName()) && product.getType().equals(p.getType())) {
				return false;
			}
		}
		list.add(p);
		return true;
	}
}
