package brigun.impthree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import brigun.impthree.models.Item;
import brigun.impthree.models.Vendor;
import brigun.impthree.services.ItemService;
import brigun.impthree.services.VendorService;

@Controller
public class HomeController
{
	@Autowired
	ItemService itemService;
	
	@Autowired
	VendorService vendorService;
	
	@RequestMapping("/")
	public String index(Model model)
	{
		List<Item> itemList = itemService.findAll();
		
		List<String> categories = itemService.findCategories(itemList);
		model.addAttribute("categories", categories);
		
		List<Vendor> topVendors = vendorService.findBig3();
		model.addAttribute("topthree", topVendors);
		
		
		return "index";
	}
}
