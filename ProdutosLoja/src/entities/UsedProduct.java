package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
	
	private LocalDate manufactureDate;
	
	public UsedProduct (String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	public LocalDate getManufacuteDate() {
		return manufactureDate;
	}
	public void setManufactureDate() {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() { 
		return getName() + "(usado) " 
						 + "R$"
						 + String.format("%.2f", getPrice())
						 + " (Data de fabricação: "
						 + manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
						 + ")";
	}
}