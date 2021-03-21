package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List <Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products:");
		int n = sc.nextInt();
				
		for (int i = 1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported? (c/u/i)");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product prd = new ImportedProduct(name, price, customsFee);
				list.add(prd);
			} else if (ch == 'u') {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product prd = new UsedProduct(name, price, manufactureDate);
				list.add(prd);							
			} else {
				Product prd = new Product(name, price);
				list.add(prd);
				}		
		
			}
			
			System.out.println();
			System.out.println("PRICE TAGS: ");
			for (Product prd : list) {
				System.out.println(prd.priceTag());
			
		}
		
		sc.close();

	}

}
