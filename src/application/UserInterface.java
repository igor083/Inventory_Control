package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

import entities.Inventory;
import entities.Product;
import exceptions.InventoryException;
import typeProducts.Eletronics;
import typeProducts.Food;
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
					System.out.print("Quantos produtos deseja adicionar: ");
					Integer quant = sc.nextInt();
					inventory.addProduct(namep, typeStr, quant);
					System.out.println(typeStr);
				}
				throw new InventoryException("Estoque vazio!");

			case 4:
				Product prod = newObj();
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
	
	public static Product newObj() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o tipo do produto: (FOOD , ELETRONIC)");
		String type = sc.nextLine();

		System.out.print("Nome do produto: ");
		String name = sc.nextLine();

		System.out.print("Preco do produto: ");
		Double price = sc.nextDouble();

		System.out.print("Quantidade do produto a ser adicionado: ");
		Integer quantity = sc.nextInt();

		if (type.toUpperCase().charAt(0) == 'F') {
			sc.nextLine();
			System.out.print("Data de validade: ");
			String strDate = sc.nextLine();
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
			Product food = new Food(name, quantity, price, date);
			return food;
		} else if (type.toUpperCase().charAt(0) == 'E') {
			Product eletronic = new Eletronics(name, quantity, price);
			return eletronic;
		}

		return null;
	}


}
