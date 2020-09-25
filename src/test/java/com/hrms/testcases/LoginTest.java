package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods{
	
	@Test(groups="smoke")
	public void validLogin() throws InterruptedException {
		
		LoginPageElements login=new LoginPageElements();
		
		sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.btnLogin);
		
		Thread.sleep(2000);

		
		Assert.assertTrue(dash.welcome.isDisplayed());
	}
	
	@Test(groups="regression", dataProvider="invalidCredentials")
	public void invalidLogin(String username, String password, String erroMessage) {
		
		
		sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.btnLogin);

		DashboardPageElements dashboard = new DashboardPageElements();
		Assert.assertTrue(dashboard.welcome.isDisplayed());
	}
		@DataProvider
		public String [][] invalidCredentials(){
				String [][] data={
				{"", "Hum@nhrm123", "Username cannot be empty"},
				{"Admin", "", "Password cannot be empty"},
				{"Admin", "Hum@nhrm12", "Invalid credentials"},
				
		};
		return data;
		
	}

}
