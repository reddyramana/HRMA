package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class TestJobListBoxIsSorted extends BaseTest{

	@Test
	public void testJobListBoxIsSorted(){
		//click on PIM	
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickPIM_Menu();
		//verify JobListBox content is sorted
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.verifyJobTitleIsSorted();
		
	}
	
}
