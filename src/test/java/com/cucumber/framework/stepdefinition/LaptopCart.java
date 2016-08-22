package com.cucumber.framework.stepdefinition;

import java.util.Map;

import com.cucumber.framework.helper.PageObject.itemsbag.ItemsBag;
import com.cucumber.framework.helper.PageObject.laptoppage.LaptopPage;
import com.cucumber.framework.helper.PageObject.tabletpage.TabletPage;
import com.cucumber.framework.helper.PageObject.userdetails.Userdetails;
import com.cucumber.framework.settings.ObjectRepo;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class LaptopCart {

	private LaptopPage lPage;
	private TabletPage tPage;
	private ItemsBag bag;
	private Userdetails details;
	
	@Then("^: I select the \"([^\"]*)\" with description as \"([^\"]*)\"$")
	public void _i_select_the_something_with_description_as_something(
			String itemName, String shortDesp) throws Throwable {
		lPage = (LaptopPage)ObjectRepo.data.get("LaptopPage");
		lPage.selectItem(itemName, shortDesp);
	}
	
	@Then("^: I select the tablet \"([^\"]*)\" with description as \"([^\"]*)\"$")
    public void _i_select_the_tablet_something_with_description_as_something(String itemName, String shortDesp) throws Throwable {
		tPage = (TabletPage)ObjectRepo.data.get("TabletPage");
		tPage.selectItem(itemName, shortDesp);
	}

	@And("^: Add it to the cart$")
	public void _add_it_to_the_cart() throws Throwable {
		bag = lPage.navigateToCart();
		ObjectRepo.data.put("ItemsBag", bag);
	}
	
	 @And("^: Add tablet to the cart$")
	 public void _add_tablet_to_the_cart() throws Throwable {
		 bag = tPage.navigateToCart();
		 ObjectRepo.data.put("ItemsBag", bag);
	 }
	
	@Then("^: Navigate to user details page and provide the following details$")
    public void _navigate_to_user_details_page_and_provide_the_following_details(Map<String, String> table) throws Throwable {
		details = bag.reserveYourItem();
		ObjectRepo.data.put("Userdetails", details);
		details.journeyDetails(table.get("Destination"), table.get("Airline"), table.get("FlightNo"), table.get("FlightTime"), 
				table.get("FlightDate"), table.get("Terminal"));
		details.personalDetails(table.get("FirstName"), table.get("LastName"), table.get("Email"), table.get("Phone"));
		Thread.sleep(2000);
	}

}
