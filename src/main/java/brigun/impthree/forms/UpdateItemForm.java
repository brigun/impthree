package brigun.impthree.forms;

import javax.validation.constraints.NotNull;
import javax.xml.crypto.KeySelector.Purpose;

public class UpdateItemForm
{
	@NotNull
	private Long itemId;
	
	@NotNull
	private double price;
	
	private double quantity;
	
	private double updatedQuantity;
	
	private double updatedPrice;
	
	@NotNull
	private Long vendorId;
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getUpdatedPrice() {
		if (updatedPrice < 0.01)
		{
			return price;
		}
		return updatedPrice;
	}
	
	public void setUpdatedPrice(double updatedPrice) {
		if (updatedPrice < 0.01)
		{
			updatedPrice = price;
		}
		this.updatedPrice = updatedPrice;
	}
	
	public double getQuantity()
	{
		return quantity;
	}
	
	public double getUpdatedQuantity()
	{
		return updatedQuantity;
	}

	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setUpdatedQuantity(double updatedQuantity) {
		
		this.updatedQuantity = updatedQuantity;
	}

	public Long getVendorId()
	{
		return vendorId;
	}
	
	public void setVendorId(Long vendorId)
	{
		this.vendorId = vendorId;
	}
}
