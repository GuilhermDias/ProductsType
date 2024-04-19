package entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserProduct extends Product{
	
	private LocalDate maufacture;
	
	public UserProduct(String name, Double price, LocalDate maufacture) {
		super(name, price);
		this.maufacture = maufacture;
	}

	public LocalDate getMaufacture() {
		return maufacture;
	}

	public void setMaufacture(LocalDate maufacture) {
		this.maufacture = maufacture;
	}

	@Override
	public String priceTag() {
		return getName()
					+ " (used)"
					+ " $ "
					+ String.format("%.2f", getPrice())
					+ "( Manufacture Date: "
					+ maufacture.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
					+ ")";
	}
	
	
}
