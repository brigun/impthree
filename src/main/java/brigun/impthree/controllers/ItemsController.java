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
import brigun.impthree.models.Item;
import brigun.impthree.models.Vendor;
import brigun.impthree.services.ItemService;
import brigun.impthree.services.VendorService;

@Controller
public class ItemsController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private VendorService vendorService;
	
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
	
	@RequestMapping("/items/new")
	public String newItem(NewItemForm newItemForm, Model model)
	{
		List<Item> itemList = itemService.findAll();
		
		List<String> categories = itemService.findCategories(itemList);
		model.addAttribute("categories", categories);
		
		List<Vendor> vendors = vendorService.findAll();
		model.addAttribute("vendors", vendors);
		
		return "additemform";
	}
	
	@RequestMapping(value="/items/new", method = RequestMethod.POST)
	public String newItemPage(@Valid NewItemForm newItemForm, BindingResult bindingResult)
	{
		return "additemform";
	}

}
