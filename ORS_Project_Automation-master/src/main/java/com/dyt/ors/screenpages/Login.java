package com.dyt.ors.screenpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class Login extends WebLibrary{	
	
	//=========WebElements for Login page==================
	@FindBy(xpath="//input[@name='loginId']")
	public static WebElement edit_UserName;	
	
	@FindBy(xpath="//input[@name='loginPwd']")
	public static WebElement edit_Password;
	
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement btn_Login;	
	
	@FindBy(xpath="//span[text()='Invalid Creditionals.Please Try Again']")
	public static WebElement error_Message;	
	
	@FindBy(xpath = "//*[@id='userDropdown']/img")
	public static WebElement img_AdminImg;

	@FindBy(xpath = "//*[@id=\"content\"]/nav/ul/li[2]/div/a[2]")
	public static WebElement link_LogOut;

	
	
	//=================Login methods=========================
	
	// =============================================================================
		/*
		Name            :   loginApp
		Description		: 	This method is used to log into the apps by enter user name and password to respective text fields and click on submit button
		Parameters		: 	user -> entered username, password -> entered password
		Author			: 	Anwesha
		Date			: 	10th July 2020	
		Modified Date	:	
		Modified By		:
		*/
	
	public  void loginApp(String user, String password) {			
		
		boolean bStatus;		
		bStatus = setEditValue(edit_UserName, user);
		Reporter.log(bStatus, "Username entered", "Username not entered");
				
		bStatus = setEditValue(edit_Password, password);
		Reporter.log(bStatus, "Password entered", "Password not entered");		
		
		bStatus = clickElement(btn_Login);
		Reporter.log(bStatus, "Login button clicked", "Login button not clicked");
	}
	
	// =============================================================================
		/*
		Name            :   verify_LoginPage_DisplayedElements
		Description		: 	This method is used to verify user name, password text fields and submit button are displayed on Login page
		Parameters		: 	none
		Author			: 	Anwesha
		Date			: 	10th July 2020	
		Modified Date	:	
		Modified By		:
		*/
	
	public  void verify_LoginPage_DisplayedElements() {
		boolean bstatus;
		bstatus = isElementDisplayed(edit_UserName,true);
		Reporter.log(bstatus, "User Name  text field  displayed ", "User Name  text field not displayed");
		
		bstatus = isElementDisplayed(edit_Password,true);
		Reporter.log(bstatus, "Password  text field  displayed ", "Password  text field not displayed");
		
		bstatus = isElementDisplayed(btn_Login,true);
		Reporter.log(bstatus, "Login button displayed", "Login button not displayed");
		
	}
	
	// =============================================================================
		/*
		Name            :   verifyAlertMessage
		Description		: 	This method is used to verify error message while invalid user name or invalid password entered on log in page
		Parameters		: 	errorMsg - Expected error message
		Author			: 	Anwesha
		Date			: 	10th July 2020	
		Modified Date	:	
		Modified By		:
		*/
	
	public  void verifyAlertMessage(String errorMsg) {
		
		boolean bStatus;		
		bStatus = verifyText(error_Message,errorMsg );    //Invalid Creditionals.Please Try Again
		Reporter.log(bStatus, "Error message displayed", "Error message not displayed");
		
	}
	
	// =============================================================================
		/*
		Name            :   logOut
		Description		: 	This method is used to log out from the application
		Parameters		: 	none
		Author			: 	Anwesha
		Date			: 	10th July 2020	
		Modified Date	:	
		Modified By		:
		*/
	
	public static void logOut() {
		boolean bStatus;

		bStatus = clickElement(img_AdminImg);
		Reporter.log(bStatus, "Admin image clicked", "Admin image not clicked");

		bStatus = clickElement(link_LogOut);
		Reporter.log(bStatus, "Log Out link clicked", "Log Out link not clicked");

	}
}
