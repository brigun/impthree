package brigun.impthree.models;

import java.util.HashSet;
import java.util.Set;

public class Vendor 
{
	private Long vendorId;
	private String name;
	private String website;
	private String phoneNumber;
	private Set<Item> catalog = new HashSet<>();
	
	public Long getId() {
		return vendorId;
	}
	public void setId(Long id) {
		this.vendorId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set<Item> getCatalog() {
		return catalog;
	}
	public void setCatalog(Set<Item> catalog) {
		this.catalog = catalog;
	}
	
	public Vendor(){}
	
	public Vendor(String name, String website, String phoneNumber) {
		super();
		this.name = name;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + vendorId + ", name=" + name + ", website=" + website + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
