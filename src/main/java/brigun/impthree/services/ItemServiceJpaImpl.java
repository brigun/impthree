package brigun.impthree.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import brigun.impthree.models.Item;
import brigun.impthree.repositories.ItemRepository;

@Service
@Primary
public class ItemServiceJpaImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepo;

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return this.itemRepo.findAll();
	}

	@Override
	public List<Item> findByCategory(String category) {
		// TODO Auto-generated method stub
		return this.itemRepo.findByCategory(category);
	}

	@Override
	public Set<Item> findByVendorId(Long vendorId) {
		// TODO Auto-generated method stub
		return this.itemRepo.findAllByVendor(vendorId);
	}

	@Override
	public Item findById(Long itemId) {
		// TODO Auto-generated method stub
		return this.itemRepo.findOne(itemId);
	}

	@Override
	public List<String> findCategories(List<Item> items) {
		// TODO Auto-generated method stub
		List<String> allCategories = new ArrayList<>();
		for(Item i : items)
		{
			if(!allCategories.contains(i.getCategory()))
			{
				allCategories.add(i.getCategory());
			}
		}

		return allCategories;
	}

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub
		itemRepo.save(item);
		return item;
		
	}

	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		itemRepo.save(item);
		return item;
	}

	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		itemRepo.delete(item.getId());
		

	}

}
