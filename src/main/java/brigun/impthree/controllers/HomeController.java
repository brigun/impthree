package brigun.impthree.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import brigun.impthree.models.Item;
import brigun.impthree.services.ItemService;

@Controller
public class HomeController
{
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/")
	public String index(Model model)
	{
		List<Item> itemList = itemService.findAll();
		
		
		List<String> categories = itemService.findCategories(itemList);
		model.addAttribute("categories", categories);
		
		
		return "index";
	}
}
