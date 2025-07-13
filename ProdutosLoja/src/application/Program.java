package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	
	public static void main (String [] args) {
	
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		
		System.out.println("Entre com o número de produtos: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Produto #" + i + ":");
			System.out.println("Comum, usado ou importado: (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.println("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Preço: ");
			double price = sc.nextDouble();
			if (type == 'c') {
				list.add(new Product(name, price));			
			}
			else if (type == 'u') {
				System.out.println("Data de fabricação: ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct (name, price, date));
				
			}
			else {
				System.out.println("Taxa de importação: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct (name, price, customsFee));
			}			
		}
	
		System.out.println("ETIQUETAS DE PREÇO: ");
		for (Product prod:list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
		
	}

}
