package com.hrm.base;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generics.Utility;

public abstract class BasePage {
  public Logger log=Logger.getLogger(this.getClass());
  public long timeout=Long.parseLong(Utility.getPropertyValue(AutomationConstants.CONFIG_PATH, "EXPLICIT"));
  public WebDriver driver;
  public WebDriverWait wait;
 
  public BasePage(WebDriver driver){
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
	  wait= new WebDriverWait(driver,timeout);
  }
  
  public void clickUsingJS(WebElement element){				//Javascript code
	  JavascriptExecutor j=(JavascriptExecutor)driver;
	  j.executeScript("arguments[0].click()",element);
  }
  
  public void verifyListBoxIsSorted(WebElement listBox){
	  ArrayList<String> allText = Utility.getAllTextFromListBox(listBox);
	  boolean sorted = Utility.isListSorted(allText);
	  Assert.assertTrue(sorted,"List box is Not sorted");
  }
  
  public void verifyURLhas(String expectedUrl){
	  wait.until(ExpectedConditions.urlContains(expectedUrl));  
  }
  
  public boolean verifyElementIsPresentOrNot(String xp){
	  try{
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
		  return true;
	  }
	  catch(Exception e){
		  return false;
	  }
  }
  
  public void verifyListBoxHasNoDuplicate(WebElement listBox){
	  ArrayList<String> allText=Utility.getAllTextFromListBox(listBox);
	  boolean hasDuplicate=Utility.checkListHasDuplicate(allText);
	  Assert.assertFalse(hasDuplicate,"Listbox is has Duplicate optins");
	  //true-> has Duplicate-FAIL; false->has no duplicate-PASS
	  
  }
  
}
