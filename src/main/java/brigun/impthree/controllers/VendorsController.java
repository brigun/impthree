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
	
	@RequestMapping("/vendors/addvendor")
	public String makeVendor(MakeVendorForm makeVendorForm, Model model)
	{
		List<Vendor> vendors = vendorService.findAll();
		model.addAttribute("vendors", vendors);
		return "addvendor";
	}
	
	@RequestMapping(value = "/vendors/addvendor", method = RequestMethod.POST)
	public String makeVendorPage(@Valid MakeVendorForm makeVendorForm, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			notifyService.addErrorMessage("Please check the entries are correct.\nNew Vendor creation failed.");
			return "addvendor";
		}
		Vendor created = new Vendor(makeVendorForm.getName(),
									makeVendorForm.getWebsite(),
									makeVendorForm.getPhoneNumber());
		if (vendorService.create(created))
		{
			notifyService.addInfoMessage("Vendor creation successful");
			return "addvendor";
		} else
		{
			notifyService.addErrorMessage("Vendor creation failed.\nRe-enter the data carefully please.");
			return "addvendor";
		}
	}
}
