package com.hrm.pages;

import generics.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hrm.base.BasePage;

public class Orange_LocalizitPage extends BasePage {

	
	@FindBy(id="languageList")
	private WebElement targetLanguageListBox;
	
	public Orange_LocalizitPage(WebDriver driver) {
		super(driver);
	}

	public void verifytargetLanguageListBoxIsSorted(){
		verifyListBoxIsSorted(targetLanguageListBox);
	}
	
	public void switchToLacalizitPage(){
		//switch based on title
		boolean switched=Utility.switchBrowser(driver,"localizit");
		Assert.assertTrue(switched);
	}
	
	public void closeLocalizitPage(){
		String currentTitle=driver.getTitle();
		if(currentTitle.contains("localizit")){
			log.info("currently in localizit page and closing it");
			driver.close();
			//after closing it has to switch to orangehrm page
			Utility.switchBrowser("orangehrm",driver);
		}
		else{
			log.error("currently not in localizit page");
			Assert.fail();
		}
		
		driver.close();
		
		
	}
	
}
