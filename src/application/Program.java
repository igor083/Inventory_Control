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

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Inventory inventory = new Inventory();
		while (true) {

			try {
				menu(inventory);

			} catch (InventoryException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

	public static void menu(Inventory inventory) throws ParseException {
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
				break;
			case 2:
				inventory.totalValue();
				break;

			case 3:
				if (inventory.getList() != null) {
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
				throw new InventoryException("Impossivel adicionar quantidade a algum item do estoque!");
				

			case 4:
				inventory.addNewProduct(newObj());
				break;

			case 5:
				System.exit(0);
				;
				break;

			default:
				System.out.println("Opcao invalida.");
				menu(inventory);
			}
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Estoque vazio!");
		}catch(InventoryException e) {
			e.getMessage();
			menu(inventory);
		}
		
	}

	public static Product newObj() throws ParseException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o tipo do produto: (FOOD , ELETRONIC)");
		String type = sc.nextLine();

		System.out.print("Nome do produto: ");
		String name = sc.nextLine();

		System.out.print("Preco do produto: ");
		Double price = sc.nextDouble();
	

		if (type.toUpperCase().charAt(0)=='F') {
			sc.nextLine();
			System.out.print("Data de validade: ");
			String strDate = sc.nextLine();
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

			return new Food(name, price, date);
		} else if (type.toUpperCase().charAt(0)=='E') {
			
			return new Eletronics(name, price);
		}
		
		return null;
	}

}
