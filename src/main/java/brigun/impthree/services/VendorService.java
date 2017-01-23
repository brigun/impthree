package brigun.impthree.services;

import java.util.List;

import brigun.impthree.models.Vendor;

public interface VendorService 
{
	List<Vendor> findAll();
	List<Vendor> findBig3();
	Vendor findById(Long vendorId);
}
