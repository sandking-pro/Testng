package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//select[@class='search_combobox'])[1]")
	private WebElement location;
	
	
	@FindBy(xpath="(//select[@class='search_combobox'])[2]")
	private WebElement hotels;
	
	@FindBy(xpath="(//select[@class='search_combobox'])[3]")
	private WebElement rt;
	
	@FindBy(xpath="(//select[@class='search_combobox'])[4]")
	private WebElement nor;
	
	@FindBy(xpath="(//select[@class='search_combobox'])[5]")
	private WebElement apr;
	
	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRt() {
		return rt;
	}

	public WebElement getNor() {
		return nor;
	}

	public WebElement getApr() {
		return apr;
	}

	public WebElement getCpr() {
		return cpr;
	}

	@FindBy(xpath="(//select[@class='search_combobox'])[6]")
	private WebElement cpr;
	
	@FindBy(id="datepick_in")
	private WebElement checkin;
	
	@FindBy(id="datepick_out")
	private WebElement checkout;

	public WebElement getCheckin() {
		return checkin;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	@FindBy(id="Submit")
	private WebElement submitSearch;

	public WebElement getSubmitSearch() {
		return submitSearch;
	}

}
