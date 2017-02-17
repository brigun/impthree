package brigun.impthree.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import brigun.impthree.models.Item;

@Service
public class ItemServiceStubImpl implements ItemService 
{
//	private List<Item> items = new ArrayList<Item>()
//	//String name, double price, double quantity, String category, Long vendorId
//	{{
//			add(new Item(1L,"milk, gallon", 3.00, 15.0, "dairy", 1L ));
//			add(new Item(2L,"cheddar cheese, sliced", 2.95, 7.0, "dairy", 1L));
//			add(new Item(3L,"swiss cheese, bulk", 3.11, 13.0, "dairy", 1L));
//			add(new Item(4L,"ham, sliced", 4.57, 12.0, "butcher", 1L));
//			add(new Item(5L,"salami, bulk", 1.95, 8.0, "butcher", 1L));
//			add(new Item(6L,"beef, flank steak", 7.65, 19.0, "butcher", 1L));
//			add(new Item(7L,"pork, boneless butts", 2.97, 35.0, "butcher", 2L));
//			add(new Item(8L,"bacon, sliced",6.54 , 8.0, "butcher", 2L));
//			add(new Item(9L,"whole wheat bread, sliced", 1.58, 3.0, "bakery", 3L));
//			add(new Item(10L,"bagel, asiago", 1.03, 12.0, "bakery", 3L));
//			add(new Item(11L,"bagel, plain",1.00 , 12.0, "bakery", 3L));
//			add(new Item(12L,"cookie, chocolate chip", 0.65, 27.0, "bakery", 3L));
//			add(new Item(13L,"apple pie, frozen", 5.35, 6.0, "bakery", 3L));
//			add(new Item(14L,"plate, compostable, 9inch", 35, 1.0, "dry storage", 1L));
//			add(new Item(15L,"napkins, brown disposable", 42.00, 1.0, "dry storage", 1L));
//			add(new Item(16L,"soy sauce, gallon", 2.78, 6.0, "dry storage", 1L));
//			add(new Item(17L,"salt, kosher", 2.75, 2.0, "dry storage", 1L));
//			add(new Item(18L,"pepper, whole black", 7.86, 2.0, "dry storage", 1L));
//			
//	}};
	
	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return items;
	}

	@Override
	public List<Item> findByCategory(String category) {
		// TODO Auto-generated method stub
		return this.items.stream()
				.filter(c -> Objects.equals(c.getCategory(), category))
				.collect(Collectors.toList());
	}

	@Override
	public Set<Item> findByVendorId(Long vendorId) {
		// TODO Auto-generated method stub
		return this.items.stream()
				.filter(i -> Objects.equals(i.getVendor().getId(), vendorId))
				.collect(Collectors.toSet());
	}

	@Override
	public Item findById(Long itemId) {
		// TODO Auto-generated method stub
		return this.items.stream()
				.filter(i -> Objects.equals(i.getId(), itemId))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub
		this.items.add(item);
		return item;
	}

	@Override
	public Item update(Item item) {
		// TODO Auto-generated method stub
		for(int i = 0; i < items.size(); i++)
		{
			if(Objects.equals(this.items.get(i).getName(), item.getName()))
			{
				this.items.set(i, item);
			}
			return item;
		}
		throw new RuntimeException("Item not found: " + item.getName());
	}

	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		for(int i = 0; i < items.size(); i++)
		{
			if(Objects.equals(items.get(i).getName(), item.getName()))
			{
				this.items.remove(i);
				return;
			}
		}
		throw new RuntimeException("Item not found: " + item.getName());

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

	
	
	

}
