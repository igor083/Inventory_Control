package entities;

import java.util.List;

import exceptions.InventoryException;

public class Inventory {
	private List<Product> list;

	public List<Product> getList() {
		return list;
	}

	public Inventory() {
	}

	public Inventory(List<Product> list) {
		this.list = list;
	}

	public boolean addNewProduct(Product p) {// Adiciona um novo produto
		for (Product product : list) {
			if (product.getName().equals(p.getName()) && product.getType().equals(p.getType())) {
				throw new InventoryException("O produto ja existe no estoque!");
			}
		}
		list.add(p);
		return true;
	}

	public Double totalValue() {// retorna todo o valor em estoque
		if (list==null)	throw new InventoryException("O inventario ainda esta vazio!");

		Double ttl = 0.0;
		for (Product x : list) {
			ttl += x.getPrice();
		}
		return ttl;
	}

	public boolean addProduct( Product p, Integer quantity) {// Adiciona uma quantidade a um produto
																				// ja existente
		if (list==null)	throw new InventoryException("O inventario ainda esta vazio!");
		for (Product product : list) {
			if (!product.getName().equals(p.getName()) && product.getType().equals(p.getType())) {
				throw new InventoryException("O produto nao existe no estoque!");
			}
		}
		list.add(p);
		return true;
	}
}
