package brigun.impthree.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import brigun.impthree.models.Item;

@Service
public class ItemServiceStubImpl implements ItemService 
{
	private List<Item> items = new ArrayList<Item>()
	//String name, double price, double quantity, String category, Long vendorId
	{{
			add(new Item("milk, gallon", 3.00, 15, "dairy", 1L ));
			add(new Item("cheddar cheese, sliced", 2.95, 7, "dairy", 1L));
			add(new Item("swiss cheese, bulk", 3.11, 13, "dairy", 1L));
			add(new Item("ham, sliced", 4.57, 12, "butcher", 1L));
			add(new Item("salami, bulk", 1.95, 8, "butcher", 1L));
			add(new Item("beef, flank steak", 7.65, 19, "butcher", 1L));
			add(new Item("pork, boneless butts", 2.97, 35, "butcher", 2L));
			add(new Item("bacon, sliced",6.54 , 8, "butcher", 2L));
			add(new Item("whole wheat bread, sliced", 1.58, 3, "bakery", 3L));
			add(new Item("bagel, asiago", 1.03, 12, "bakery", 3L));
			add(new Item("bagel, plain",1.00 , 12, "bakery", 3L));
			add(new Item("cookie, chocolate chip", 0.65, 27, "bakery", 3L));
			add(new Item("apple pie, frozen", 5.35, 6, "bakery", 3L));
			add(new Item("plate, compostable, 9inch", 35, 1, "dry goods", 1L));
			add(new Item("napkins, brown disposable", 42.00, 1, "dry goods", 1L));
			add(new Item("soy sauce, gallon", 2.78, 6, "dry storage", 1L));
			add(new Item("salt, kosher", 2.75, 2, "dry storage", 1L));
			add(new Item("pepper, whole black", 7.86, 2, "dry storage", 1L));
			
	}};
	
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
	public List<Item> findByVendor(Long vendorId) {
		// TODO Auto-generated method stub
		return this.items.stream()
				.filter(v -> Objects.equals(v.getVendorId(), vendorId))
				.collect(Collectors.toList());
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

}
