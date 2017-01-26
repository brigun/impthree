package brigun.impthree.services;

import java.util.List;
import java.util.Set;

import brigun.impthree.models.Item;
import brigun.impthree.models.Vendor;

public interface VendorService 
{
	List<Vendor> findAll();
	List<Vendor> findBig3();
	Vendor findById(Long vendorId);
	Set<Item> findCatalog(Long vendorId);
	boolean create(Vendor vendor);
}
