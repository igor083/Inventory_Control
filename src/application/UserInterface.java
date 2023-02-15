package application;

import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import entities.Inventory;
import entities.Product;
import exceptions.InventoryException;
import typeProducts.TypeProduct;

public class UserInterface {
	public static void printInventory(Inventory inventory) {
		if(inventory.getList().size()==0) {
			throw new InventoryException("Estoque vazio");
		}
			for (Product i : inventory.getList()) {
				System.out.println(i);
			}
		
		
	}
	public static int menu(Inventory inventory) throws Exception {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("\n\n");
			System.out.println("----------MENU----------");
			System.out.println("1 - Ver todo o estoque.");
			System.out.println("2 - Ver quantia em estoque.");
			System.out.println("3 - Adicionar quantidade em produtos.");
			System.out.println("4 - Adicionar produto novo.");
			System.out.println("5 - Fechar programa.");
			System.out.print("O que deseja fazer? ");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				UserInterface.printInventory(inventory);
				return 1;
			case 2:
				inventory.totalValue();
				return 1;

			case 3:
				if (inventory.getList().size() != 0) {
					System.out.print("Nome do produto: ");
					String namep = sc.nextLine();
					sc.nextLine();
					System.out.print("Tipo do produto: ");
					String typeStr = sc.nextLine();
					TypeProduct typep = TypeProduct.valueOf(typeStr);
					System.out.print("Quantos produtos deseja adicionar: ");
					Integer quant = sc.nextInt();
					inventory.addProduct(namep, typep, quant);
				}
				throw new InventoryException("Estoque vazio!");

			case 4:
				Product prod = Program.newObj();
				inventory.addNewProduct(prod);
				return 1;

			case 5:
				System.out.print("\n\nPrograma finalizado!");
				;
				return 0;

			default:
				System.out.println("Opcao invalida.");
				return 1;
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			;
		} catch (InventoryException e) {
			System.out.println(e.getMessage());
			;
			menu(inventory);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			;
		}
		return 1;
	}


}
