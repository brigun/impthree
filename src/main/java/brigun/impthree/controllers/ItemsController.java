package brigun.impthree.controllers;

import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import brigun.impthree.forms.DeleteItemForm;
import brigun.impthree.forms.NewItemForm;
import brigun.impthree.forms.UpdateItemForm;
import brigun.impthree.models.Item;
import brigun.impthree.models.Vendor;
import brigun.impthree.services.ItemService;
import brigun.impthree.services.NotificationService;
import brigun.impthree.services.VendorService;

@Controller
public class ItemsController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/items/{category}")
	public String singleCategory(@PathVariable("category")String category, Model model)
	{
		List<Item> onlyThese = itemService.findByCategory(category);
		model.addAttribute("these", onlyThese);
		model.addAttribute("category", category);
		return "singlecategory";
	}
	
	@RequestMapping("/items/itemindex")
	public String fullInventory(Model model)
	{
		List<Item> fullInv = itemService.findAll();
		fullInv.sort(
				Comparator.comparing(Item :: getCategory)
				.thenComparing(Item :: getName)
				);
		model.addAttribute("itemlist", fullInv);
		return "itemindex";
	}
	
	@RequestMapping("/items/additem")
	public String newItem(NewItemForm newItemForm, Model model)
	{
		List<Item> itemList = itemService.findAll();
		
		List<String> categories = itemService.findCategories(itemList);
		model.addAttribute("categories", categories);
		
		List<Vendor> vendors = vendorService.findAll();
		model.addAttribute("vendors", vendors);
		
		return "additemform";
	}
	
	@RequestMapping(value="/items/additem", method = RequestMethod.POST)
	public String newItemPage(@Valid NewItemForm newItemForm, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			notificationService.addErrorMessage("Item creation failed.  Please check your entries.");
//			System.out.println("Category: " + newItemForm.getCategory() + ", " + 
//								"Name: " + newItemForm.getName() + ", " + 
//								"Price: " + newItemForm.getPrice() + ", " + 
//								"Quantity: " + newItemForm.getQuantity() + ", " + 
//								"VendorId: " + newItemForm.getVendorId());
//			System.out.println(bindingResult.toString());
			return "redirect:/items/additem";
		}
		//String name, double price, double quantity, String category, Long vendorId
		Item newItem = new Item(newItemForm.getName(),
								newItemForm.getPrice(),
								newItemForm.getQuantity(),
								newItemForm.getCategory(),
								vendorService.findById(newItemForm.getVendorId()));
		itemService.create(newItem);
		notificationService.addInfoMessage("Item successfully added.");
		return "redirect:/items/itemindex";
	}
	
	@RequestMapping("/items/updateitem/{itemId}")
	public String updateItem(@PathVariable("itemId")Long itemId, UpdateItemForm updateItemForm, Model model)
	{
		Item targetItem = itemService.findById(itemId);
		model.addAttribute("target", targetItem);
		Vendor itemVendor = targetItem.getVendor();
		model.addAttribute("vendor", itemVendor);
		List<Vendor> vendors = vendorService.findAll();
		model.addAttribute("vendors", vendors);
		
		return "updateitem";
	}
	
	@RequestMapping(value = "/items/updateitem/{itemId}", method = RequestMethod.POST)
	public String editItemPage(@Valid UpdateItemForm updateItemForm, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			notificationService.addErrorMessage("Item edit failed, please double check your entries.");
			String page = String.format("updateitem/{%L}",updateItemForm.getItemId());
			return page;
		}
		Item updated = itemService.findById(updateItemForm.getItemId());
		updated.setPrice(updateItemForm.getUpdatedPrice());
		updated.setQuantity(updateItemForm.getUpdatedQuantity());
		updated.setVendor(vendorService.findById(updateItemForm.getVendorId()));
		itemService.update(updated);
		notificationService.addInfoMessage("Update successful.");
		
		return "redirect:/items/itemindex";
	}
	
	@RequestMapping("/items/delete/{itemId}")
	public String deleteItemPage(@PathVariable("itemId")Long itemId, DeleteItemForm deleteItemForm, Model model)
	{
		Item target = itemService.findById(itemId);
		model.addAttribute("target", target);
		
		
		return "delete";
	}
	
//	@RequestMapping(value = "/items/delete/{itemId}", method = RequestMethod.POST)
//	public String deleteItemPage(@Valid DeleteItemForm deleteItemForm, BindingResult bindingResult)
//	{
//		if (bindingResult.hasErrors())
//	}

}
