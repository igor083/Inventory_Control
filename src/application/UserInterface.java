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
		} catch (NullPointerException e) {
			throw new InventoryException("O inventario ainda esta vazio!");
		}
	}


}
