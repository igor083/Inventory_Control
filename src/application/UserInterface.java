package application;

import entities.Inventory;
import entities.Product;
import exceptions.InventoryException;

public class UserInterface {
	public static void printInventory(Inventory inventory) {
		try {
			for (Product i : inventory.getList()) {
				System.out.println(i);
			}
		} catch (InventoryException e) {
			throw new InventoryException("O inventario ainda esta vazio!");
		}
	}
	
	public static void menu() {
		System.out.println("----------MENU----------");
		System.out.println("1 - Ver todo o estoque.");
		System.out.println("2 - Ver quantia em estoque.");
		System.out.println("3 - Adicionar quantidade em produtos.");
		System.out.println("4 - Adicionar produto novo.");
		System.out.println("5 - Fechar programa.");
	}
}
