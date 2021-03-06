package brigun.impthree.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vendor_id")
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = true, length = 30)
	private String website;
	
	@Column(nullable = false, length = 20)
	private String phoneNumber;
	
	@OneToMany (mappedBy = "vendor")
	private Set<Item> catalog = new HashSet<Item>();;
	
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
	
	
	public Vendor(Long vendorId, String name, String website, String phoneNumber) {
		super();
		this.id = vendorId;
		this.name = name;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", website=" + website + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
