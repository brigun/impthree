package brigun.impthree.services;

import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import brigun.impthree.models.Item;
import brigun.impthree.models.Vendor;
import brigun.impthree.repositories.ItemRepository;
import brigun.impthree.repositories.VendorRepository;

@Service
@Primary
public class VendorServiceJpaImpl implements VendorService {
	
	@Autowired
	VendorRepository vendorRepo;
	
	@Autowired
	ItemRepository itemRepo;

	@Override
	public List<Vendor> findAll() {
		// TODO Auto-generated method stub
		return vendorRepo.findAll();
	}

	@Override
	public List<Vendor> findBig3() {
		// TODO Auto-generated method stub
//		List<Vendor> bigThree = new ArrayList<>();
//		List<Vendor> vendList = this.findAll();
//		Map<Vendor, Integer> vendMap = new HashMap<Vendor, Integer>();
//		for (Vendor v : vendList) {
//			
//			Integer count = vendMap.get(v);
//			vendMap.put(v, (count == null) ? 1 : count + 1);
//		}
//		List<Map.Entry<Vendor, Integer>> entries =new ArrayList<>(vendMap.entrySet());
//		Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
//		List<Entry<Vendor,Integer>> bigThreeCount = entries.subList(0, Math.min(entries.size(), 3));
//		for (Entry<Vendor, Integer> v : bigThreeCount)
//		{
//			bigThree.add(v.getKey());
//		}
		List<Vendor> all = vendorRepo.findAll();
		all.sort(
				(va, vb) -> 
				{
					if (va.getCatalog().size() == vb.getCatalog().size())
						{
							return va.getName().compareTo(vb.getName());
						} else
						{
							return Math.max(va.getCatalog().size(),vb.getCatalog().size());
						}
				});
		List<Vendor> bigThree = all.subList(0, 3);
		return bigThree;
	}

	@Override
	public Vendor findById(Long vendorId) {
		// TODO Auto-generated method stub
		return vendorRepo.findOne(vendorId);
	}

	@Override
	public Set<Item> findCatalog(Long vendorId) {
		// TODO Auto-generated method stub
		Set<Item> catalog = itemRepo.findAllByVendor(vendorId);
		
		return catalog;
	}

	@Override
	public Vendor create(Vendor vendor) {
		// TODO Auto-generated method stub
		
		vendorRepo.save(vendor);
		return vendor;
	}
}
