package brigun.impthree.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import brigun.impthree.forms.LoginForm;
import brigun.impthree.services.NotificationService;
import brigun.impthree.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/users/login")
	public String login(LoginForm loginForm)
	{
		return "login";
	}
	
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			notificationService.addErrorMessage("Please fill out the form correctly!");
			return "login";
		}
		
		if (!userService.authenticate(loginForm.getUsername(), loginForm.getPassword()))
		{
			notificationService.addErrorMessage("Invalid Login!");
			return "login";
		}
		
		notificationService.addInfoMessage("Login Successful");
		return "redirect:/";
	}

}
