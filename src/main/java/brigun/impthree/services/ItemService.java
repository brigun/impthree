package brigun.impthree.services;

import java.util.List;

import brigun.impthree.models.Item;

public interface ItemService
{
	List<Item> findAll();
	List<Item> findByCategory(String category);
	List<Item> findByVendor(Long vendorId);
	Item findById(Long itemId);
	List<String> findCategories(List<Item> items);
	Item create(Item item);
	Item update(Item item);
	void delete(Item item);
	
}
