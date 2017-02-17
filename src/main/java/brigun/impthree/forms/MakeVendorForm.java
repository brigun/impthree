package brigun.impthree.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MakeVendorForm
{
	//name, website, phone number
	@NotNull
	@Size(min = 3, max = 60)
	private String name;
	
	@NotNull
	@Pattern(regexp = "^((http|https):[/][/]|www.)([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?",
			message = "Please enter a valid URL.")
	//Modeled after a regular expression posted by Bhanu Prakash on regexlib.com
	private String website;
	
	@NotNull
	@Pattern(regexp="^(\\([2-9]|[2-9])(\\d{2}|\\d{2}\\))(-|.|\\s)?\\d{3}(-|.|\\s)?\\d{4}$",
			message = "Please make certain there are ten digits in the phone number.")
	//Modeled after a regular expression posted by Mark J. Krisburg on regexlib.com
	private String phoneNumber;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getWebsite()
	{
		return website;
	}
	
	public void setWebsite(String website)
	{
		this.website = website;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
