package brigun.impthree.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			return "additemform";
		}
		//String name, double price, double quantity, String category, Long vendorId
		Item newItem = new Item(newItemForm.getName(),
								newItemForm.getPrice(),
								newItemForm.getQuantity(),
								newItemForm.getCategory(),
								newItemForm.getVendorId());
		itemService.create(newItem);
		notificationService.addInfoMessage("Item successfully added.");
		return "additemform";
	}
	
	@RequestMapping("/items/update")
	public String updateItem(UpdateItemForm updateItemForm, Model model)
	{
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemlist", itemList);
		
		return "update";
	}

}
