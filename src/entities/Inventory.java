package entities;

import java.util.ArrayList;
import java.util.List;

import exceptions.InventoryException;
import typeProducts.TypeProduct;

public class Inventory {
	private List<Product> list = new ArrayList<>();

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

	public void totalValue() {// retorna todo o valor em estoque
		if (list.size() == 0)
			throw new InventoryException("O estoque ainda esta vazio!");

		Double ttl = 0.0;
		for (Product x : list) {
			ttl += x.getPrice() * x.getQuantity();
		}
		System.out.println("A quantia em estoque e de :" + String.format("R$ %.2f", ttl));
		;
	}

	public boolean addProduct(String name, String type, Integer quantity) {// Adiciona uma quantidade a um produto
																			// ja existente
		if (list.size() == 0)
			throw new InventoryException("O estoque ainda esta vazio!");
		for (Product product : list) {
			if (!product.getName().toUpperCase().equals(name.toUpperCase())
					&& product.getType().toString().toUpperCase().charAt(0) == type.toUpperCase().charAt(0)) {
				throw new InventoryException("O produto tnao exise no estoque!");
			}
			product.setQuantity(quantity);
		}

		return true;
	}
}
