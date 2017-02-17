package brigun.impthree.services;

import java.util.List;
import java.util.Set;

import brigun.impthree.models.Item;

public interface ItemService
{
	List<Item> findAll();
	List<Item> findByCategory(String category);
	Item findById(Long itemId);
	List<String> findCategories(List<Item> items);
	Item create(Item item);
	Item update(Item item);
	void delete(Item item);
	Set<Item> findByVendorId(Long vendorId);
	
	
}
