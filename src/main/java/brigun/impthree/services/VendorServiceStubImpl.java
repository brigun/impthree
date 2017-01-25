package brigun.impthree.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Service;

import brigun.impthree.models.Item;
import brigun.impthree.models.Vendor;

@Service
public class VendorServiceStubImpl implements VendorService {
	
	private List<Vendor> vendors = new ArrayList<Vendor>()
	//Vendor(String name, String website, String phoneNumber)
			{/**
				 * 
				 */
				private static final long serialVersionUID = 5792059797947097519L;

			{ add(new Vendor(1L, "Sysco", "www.sysco.com", "555-1212"));
				add(new Vendor(2L, "Kaldis", "www.kaldiscoffee.com", "555-1212"));
				add(new Vendor(3L, "US Foods", "www.usfoods.com", "555-1212"));
				add(new Vendor(4L, "Industrial Soap", "www.industrialsoap.com", "555-1212"));
			}};
			
			

	@Override
	public List<Vendor> findAll() {
		// TODO Auto-generated method stub
		return vendors;
	}

	@Override
	public List<Vendor> findBig3() {
		// TODO Auto-generated method stub
		List<Vendor> topThree = new ArrayList<Vendor>();
		for (int i = 0; i<3; i++)
		{
			topThree.add(vendors.get(i));
		}
		
		return topThree;
	}

	@Override
	public Vendor findById(Long vendorId) {
		// TODO Auto-generated method stub
		for(int i = 0; i < vendors.size(); i++)
		{
			if (Objects.equals(vendors.get(i).getId(), vendorId))
			{
				return vendors.get(i);
			}
		}
		//throw new RuntimeException("Vendor id#" + vendorId + " not found.");
		return null;
	}

	@Override
	public Set<Item> findCatalog(Long vendorId) {
		// TODO Auto-generated method stub
		Vendor target = this.findById(vendorId);
		Set<Item> catalog = target.getCatalog();
		return catalog;
	}

}
