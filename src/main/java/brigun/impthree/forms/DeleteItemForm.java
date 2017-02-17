package brigun.impthree.forms;

import javax.validation.constraints.NotNull;

public class DeleteItemForm 
{
	@NotNull
	private Long itemId;
	
	public Long getItemId()
	{
		return itemId;
	}
	
	public void setItemId(Long itemId)
	{
		this.itemId = itemId;
	}
}
