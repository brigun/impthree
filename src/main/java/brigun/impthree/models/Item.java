package brigun.impthree.models;

public class Item 
{
	private Long itemId;
	private String name;
	private double price;
	private double quantity;
	private String category;
	private Long vendorId;
	
	public Long getId() {
		return itemId;
	}
	public void setId(Long id) {
		this.itemId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getVendorId() {
		return vendorId;
	}
	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	
	public Item(){}
	
	public Item(String name, double price, double quantity, String category, Long vendorId) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.vendorId = vendorId;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + itemId + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + ", vendor=" + vendorId + "]";
	}
	
	
	
	
	
}
