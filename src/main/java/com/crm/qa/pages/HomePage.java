package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(), 'Demo User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	//Initializing the Page Objects
		public HomePage(){
			PageFactory.initElements(driver, this);
			
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateUserNameLabel(){
			return userNameLabel.isDisplayed();
		}

		public ContactsPage clickContactsLink(){
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickDealsLink(){
			dealsLink.click();
			return new DealsPage();
		}
}
