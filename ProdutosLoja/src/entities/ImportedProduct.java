package entities;

public class ImportedProduct extends Product{
	
	private double customsFee;
	
	public ImportedProduct (String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public Double getCustomsFee() {
		return customsFee;
	}
	
	public void setCustomsFee() {
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return getPrice() + customsFee;
	}
	
	@Override 
	public String priceTag() {
		return getName() + " R$"
						 + String.format("%.2f", totalPrice())
						 + " (Preço de importação: R$"
   						 + String.format("%.2f", customsFee)
						 + ")";
	}
	
	

}
