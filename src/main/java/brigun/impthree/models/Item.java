package brigun.impthree.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 60, unique = true )
	private String name;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = true)
	private double quantity;
	
	@Column(name = "category", nullable = false)
	private String category;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="vendor_id")
	private Vendor vendor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor){
		this.vendor = vendor;
	}
	
	public Item(){}
	
	public Item(String name, double price, double quantity, String category, Vendor vendor) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.vendor = vendor;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + ", vendor=" + vendor.getName() + "]";
	}
	
	
	
	
	
}
