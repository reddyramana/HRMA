package com.hrm.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hrm.base.BasePage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class NoDuplicateOptionInIncludeListbox extends BasePage{

	public NoDuplicateOptionInIncludeListbox(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testIncludeListBox(){
		
		//click on PIM
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickPIM_Menu();
		//verify that there is no duplicate option is in include listbox
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.verifyDuplicateOptionIncludeListBox();
	}
}
