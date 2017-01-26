package brigun.impthree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import brigun.impthree.forms.MakeVendorForm;
import brigun.impthree.models.Vendor;
import brigun.impthree.services.NotificationService;
import brigun.impthree.services.VendorService;

@Controller
public class VendorsController
{
	@Autowired
	VendorService vendorService;
	
	@Autowired
	NotificationService notifyService;
	
	@RequestMapping("/vendors/{id}")
	public String vendors(@PathVariable("id") Long id, Model model)
	{
		Vendor vendor = vendorService.findById(id);
		if(vendor == null)
		{
			notifyService.addErrorMessage("Cannot find vendor #" + id);
			return "redirect:/";
		}
		model.addAttribute("vendor", vendor);
		return "vendors";
	}
	
	@RequestMapping("/vendors/vendorlist")
	public String makeVendor(MakeVendorForm makeVendorForm, Model model)
	{
		List<Vendor> vendors = vendorService.findAll();
		model.addAttribute("vendors", vendors);
		return "vendors/vendorlist";
	}
}
