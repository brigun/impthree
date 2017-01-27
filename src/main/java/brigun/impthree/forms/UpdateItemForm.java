package brigun.impthree.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateItemForm
{
	@NotNull
	private Long itemId;
	
	@Min(0)
	private double quantity;
	
	@Min(0)
	private double updatedQuantity;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getUpdatedQuantity() {
		return updatedQuantity;
	}

	public void setUpdatedQuantity(double updatedQuantity) {
		this.updatedQuantity = updatedQuantity;
	}
	
	
}
