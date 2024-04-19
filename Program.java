package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.ImportedProduct;
import entites.Product;
import entites.UserProduct;

public class Program {

	public static void main(String[] args) throws ParseException{

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used, imported(c/u/i)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (resp == 'c') {
				list.add(new Product(name, price));
			}
			else if (resp == 'u') {
				System.out.println("ManuFacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UserProduct(name, price, date));
			}
			else {
				System.out.print("Customs Fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}
		
		System.out.println("\nPrice Tags: ");
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
		
	}

}

/*Basic Java program, where, exist 3 types, Comuns, Imported and Used (c/i/u), and the imported products have rate of import and Used products have the date when they were imported. This program using the Java language and the Ecplise IDEA for developed.*/
