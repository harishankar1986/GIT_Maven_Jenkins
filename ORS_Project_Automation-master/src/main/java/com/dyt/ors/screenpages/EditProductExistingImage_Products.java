package com.dyt.ors.screenpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dyt.generic.WebLibrary;
import com.dyt.reports.Reporter;

public class EditProductExistingImage_Products extends WebLibrary{
	
	@FindBy(xpath="//input[@id='prdImage']")
	public static WebElement edit_prdImage;
	
	@FindBy(xpath="//input[@class='btn btn-success']")
	public static WebElement btn_submit;
	
	//============================================================================
	public  boolean selectEditicon(String expValue) {
		boolean bStatus = false;
		try {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr"));
		int trcount=rows.size();
		//System.out.println(trcount);
		
		for(int i=1; i<=trcount; i++) {
		String actValue=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[6]")).getText();
		System.out.println(actValue);
		if ((actValue.equals(expValue)))  {
			driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr["+i+"]/td[15]/a[1]/i")).click();
			break;
			}
		}
		}
		
		catch(Exception e) {
			bStatus = false;
		}
		return bStatus;
		
		
	}
	
	//=======================================================================
	
	public  void editProductImage() 
		{
			boolean bStatus;

			bStatus = uploadFile(edit_prdImage,  "C:\\Users\\lenavo\\Desktop\\image1.jpg");
			Reporter.log(bStatus, "file is selected", "file is not selected");
			
			bStatus =clickElement(btn_submit);
			Reporter.log(bStatus, "submit button is clicked", "submit button is clicked");
		}
	//========================================================
	// verify edited product added based on unique Cat No
			public  void verifyNewAddedProduct(String catNo) {
				boolean bStatus = false;
				int rowCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr")).size();
				String nextButtonClassName;
				if (rowCount != 0) {
					do {
						nextButtonClassName = driver.findElement(By.id("dataTable_next")).getAttribute("class");
						for (int i = 1; i <= rowCount; i++) {
							String catText = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[" + i + "]/td[6]"))
									.getText();

							if (catText.trim().equalsIgnoreCase(catNo)) {
								bStatus = true;
								break;
							}

						} 

						if (bStatus == false) {
							
							driver.findElement(By.xpath("//li[@id='dataTable_next']")).click();
							
							rowCount = driver.findElements(By.xpath("//table[@id='dataTable']/tbody/tr")).size();

						}

					} while (!nextButtonClassName.contains("disabled"));
					Reporter.log(bStatus, "Product in result table displayed as expected",
							"Product in result table not displayed as expected");

				} 
				else
					Reporter.logEvent("warning", "No result displayed in result table");

			}



}
