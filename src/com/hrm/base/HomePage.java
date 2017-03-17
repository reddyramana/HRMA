package com.hrm.base;

import generics.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class HomePage extends BasePage{

	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcome;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void logout(){
		/*welcome.click();
		logout.click();*/
		
		clickUsingJS(welcome);
		clickUsingJS(logout);
	}
	
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement pim_Menu;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmp_Menu;
	
	public void clickPIM_Menu(){
		pim_Menu.click();
	}
	
	public void clickAddEmp_Menu(){
		addEmp_Menu.click();
	}
		
	
	@FindBy(id="menu_admin_viewAdminModule")
	private WebElement admin_Menu;
	
	@FindBy(id="menu_admin_Configuration")
	private WebElement configuration_Menu;
	
	@FindBy(id="menu_admin_localization")
	private WebElement localization_Menu;
	
	public void clickAdmin_Menu(){
		admin_Menu.click();
	}
	
	public void moveToCongif(){
		Utility.moveToElement(driver,configuration_Menu);
	}
	
	public void clickLocalization_Menu(){
		localization_Menu.click();
	}
}
