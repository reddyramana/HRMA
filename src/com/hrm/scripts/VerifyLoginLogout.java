package com.hrm.scripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LoginPage;

import generics.Excel;

public class VerifyLoginLogout extends BaseTest{
	@BeforeClass
	public void disableAutoLoginLogout(){
		loginRequired=false;
		logoutRequired=false;
	}
	@Test
	public void testLoginLogout(){
		String un=Excel.getCellValue(INPUT_PATH, "VerifyLoginLogout",1,0);
		String pw=Excel.getCellValue(INPUT_PATH, "VerifyLoginLogout",1,1);
		String homeURL=Excel.getCellValue(INPUT_PATH, "VerifyLoginLogout",1,2);
		String loginURL=Excel.getCellValue(INPUT_PATH, "VerifyLoginLogout",1,3);
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(un,pw);
		DashboardPage dashboardPage=new DashboardPage(driver);
		dashboardPage.verifyURLhas(homeURL);
		dashboardPage.logout();
		loginPage.verifyURLhas(loginURL);
		
	}
}
