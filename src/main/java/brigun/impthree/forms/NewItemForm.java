package brigun.impthree.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class NewItemForm 
{
	@NotEmpty
	@Size(min = 3, max = 50)
	private String name;
	
	@NotEmpty
	@Size(min = 2, max = 25)
	private String category;
	
	@NotNull
	private Double price;
	
	private Double quantity = 0.0;
	
	@NotNull
	private Long vendorId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	
	
}
