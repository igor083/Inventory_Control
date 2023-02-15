package application;

import java.util.Scanner;

import entities.Inventory;
import exceptions.InventoryException;

public class Program {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Inventory inventory = new Inventory();
		int i=1;
		while (i>=1) {

			try {
				 i =UserInterface.menu(inventory);
			} catch (InventoryException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}

	}

}
