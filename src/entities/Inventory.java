package entities;

import java.util.ArrayList;
import java.util.List;

import exceptions.InventoryException;
import typeProducts.TypeProduct;

public class Inventory {
	private List<Product> list=new ArrayList<>();

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
		if (list.size()==0)	throw new InventoryException("O estoque ainda esta vazio!");

		Double ttl = 0.0;
		for (Product x : list) {
			ttl += x.getPrice();
		}
		return ttl;
	}

	public boolean addProduct( String name,TypeProduct type, Integer quantity) {// Adiciona uma quantidade a um produto
																				// ja existente
		if (list==null)	throw new InventoryException("O estoque ainda esta vazio!");
		for (Product product : list) {
			if (!product.getName().equals(name) && product.getType().equals(type)) {
				throw new InventoryException("O produto nao existe no estoque!");
			}
			if(product.getName().equals(name) && product.getType().equals(type)) {
				product;
			}
		}
		
		return true;
	}
}
