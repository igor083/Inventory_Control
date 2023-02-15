package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Inventory;
import entities.Product;
import exceptions.InventoryException;
import typeProducts.Eletronics;
import typeProducts.Food;

public class Program {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Inventory inventory = new Inventory();
		int i=1;
		while (i==1) {

			try {
				UserInterface.menu(inventory);
				 i =UserInterface.menu(inventory);

			} catch (InventoryException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
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

		System.out.println("Quantidade do produto a ser adicionado: ");
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
