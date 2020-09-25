package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods{
	
	@Test(groups="smoke", dataProvider="getData")
	public void addEmployee(String firstName, String lastName, String userName, String password) {
		LoginPageElements login=new LoginPageElements();
		sendText(login.userNametextBox, ConfigsReader.getPropValue("username"));
		sendText(login.passwordTextBox, ConfigsReader.getPropValue("password"));
		click(login.btnLogin);

		jsClick(dash.pimLinkBtn);
		jsClick(dash.addEmpBtn);

		sendText(addEmp.firstNameField, firstName);
		sendText(addEmp.lastName, lastName);
		click(addEmp.createLoginDetailsCheckbox);
		sendText(addEmp.userName, userName);
		sendText(addEmp.userPassword, password);
		sendText(addEmp.confirmPassword, password);
		click(addEmp.saveButton);

		Assert.assertEquals(persDetails.profileName.getText(), firstName + " " + lastName);
	}

	@DataProvider
	public static String[][] getData() {
		String[][] data = { 
				{ "Alice", "Silve", "Alstydfisil4x4", "!K!ters1Duzf" },
				{ "Asal", "Siasaf", "Alisiasal4x5", "!K!ters1Duz" },
				{ "Alan", "Sil", "Alishtyifl4x6", "!K!ters1Duz" },
				{ "Ali", "Si3", "Atyufrulisil4x7", "!K!ters1Duz" },
				{ "Alfi", "Sil", "Alisil4fx8", "!K!tefrs1Duz" }, };
		return data;
	}

}