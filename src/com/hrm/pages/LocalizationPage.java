package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class LocalizationPage extends HomePage{
	
	@FindBy(xpath="//a[text()='Language and font help']")
	private WebElement languageAndFontHelp;
	
	public LocalizationPage(WebDriver driver){
		super(driver);
	}

	public void clickLanguageAndFontHelp(){
		languageAndFontHelp.click();
	}
}
