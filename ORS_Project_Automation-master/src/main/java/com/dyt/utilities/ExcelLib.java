package com.dyt.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;

import com.dyt.ors.config.Config;

//============================================================
/*
Method Name	  :  ExcelLibrary
Description     :  It has all the reusable methods to work with Excel file
Author          :  Madhavi
Date            :  10th June 2020
Modified Date   :
Modified By     :
*/
   public class ExcelLib extends Config{		
	//============================================================
	/*
	 FileInputStream – A FileInputStream is an inputstream for reading data from a File.
	 XSSFWorkbook: Is a class representation of XLSX file.
	 */
	//====================Class properties=======================
	static FileInputStream inpstr = null;
	static XSSFWorkbook workbook = null;
	
	//==================================================
	/*
    Method Name     :  getCellValue
    Description     :  This method is used to get the cell representing a given column 
    Author          :  Madhavi
    Date            :  11th June 2020
    Parameters      : String filepath -> ,String sheetname -> , int rowIndex -> , int colIndex ->
    Modified Date   :  
    Modified By     :
*/
	public static String getCellValue(String filepath, String sheetname, int rowIndex, int colIndex)
	{
		String strCellValue = null;
		try{	
			
			File file = new File(filepath);
			inpstr = new FileInputStream(file);
			workbook = new XSSFWorkbook(inpstr);					
			
			XSSFSheet worksheet = workbook.getSheet(sheetname);	
			Row row = worksheet.getRow(rowIndex);
			strCellValue = row.getCell(colIndex).getStringCellValue();										
		}				
		
		catch(IOException e)	{
			System.out.println("File not found or unable to read/write data..");
		}
		
		catch(Exception e)	{
			System.out.println(e.getMessage());
			System.out.println("unknown exception");
		}		
		
		return strCellValue;
	}
	
	//==========================================================================================
			/* public static String[] getRowData(String filepath,String sheetname,int colIndex,String colValues)
				{	
					String[] strRowData = null;
					try {
					File file = new File(filepath);
				inpstr = new FileInputStream(file);
			 

				workbook = new XSSFWorkbook(inpstr);
				XSSFSheet worksheet = workbook.getSheet(sheetname);
				Row row = worksheet.getRow(0);
				Cell cell = row.getCell(colIndex);
				String cellValue = String.valueOf(cell.getStringCellValue());
				System.out.println("column Data :" +cellValue);
					}
				catch(IOException e) {
				System.out.println("File not found or unable to read/write data.."); 	}
				catch(Exception e)	{
				System.out.println(e.getMessage());
				System.out.println("unknown exception"); 
				}
				return strRowData;
				}  */
	//=========================================================================================
			 public static String[] getRowData(String TCName, String sheetname)
				{
					boolean bTag = false;
					String[] arr = new String[20];
					try{					
						File file = new File(TestDataPath);
						inpstr = new FileInputStream(file);
						workbook = new XSSFWorkbook(inpstr);
											
						XSSFSheet sheet = workbook.getSheet(sheetname);	
						
						int rowcount = sheet.getLastRowNum()+1;
						// Search for input test case name in each row at column 2
						for(int i=1; i<rowcount; i++) 
						{
							Row row = sheet.getRow(i);
							String exlTCName = row.getCell(1).getStringCellValue();					
							if(TCName.equals(exlTCName.trim()))						
							{
								int colLastIndexCount = row.getLastCellNum();
								for(int j=2; j<=colLastIndexCount; j++)
								{
									arr[j-2]  = row.getCell(j).getStringCellValue();
								}		
															
								bTag = true;
								break;
							}						
						}
						
						if(bTag==false)
						{
							System.out.println(TCName +" - Test case not found in test data sheet - "+ sheetname);
						}						
					}				
					
					catch(IOException e)	{
						System.out.println(TestDataPath +" - File not found or unable to read/write data");
					}
					
					catch(Exception e)	{
						System.out.println(e.getMessage());
					}
					
					return arr;		
				}
				
			 
			 //================================================================================
			 /*
		      Method Name     :  getRowData
		      Description     :  This method is used to return the row data 
		      Author          :  Madhavi
		      Date            :  11th June 2020
		      Parameters      : String filepath -> ,String sheetname -> , int rowIndex -> 
		      Modified Date   :  
		      Modified By     :
		    */
			 public static String getRowData(String filepath,String sheetname,int rowIndex)
			 {
				String[] strRowData = null;
					try {
						File file = new File(filepath);
						inpstr = new FileInputStream(file);
						workbook = new XSSFWorkbook(inpstr);
						XSSFSheet worksheet = workbook.getSheet(sheetname);
							
						Row row = worksheet.getRow(rowIndex);
						int colCount = row.getLastCellNum();
						System.out.println("columns: " + colCount);
							
							strRowData = new String[colCount];
							for(int j=0; j<colCount; j++)
							{
								strRowData[j]  = row.getCell(j).getStringCellValue();
							}	
						}				
						catch(IOException e)	{
							System.out.println("File not found or unable to read/write data..");
						}
						
						catch(Exception e)	{
							System.out.println(e.getMessage());
							System.out.println("unknown exception");
						}		
						return Arrays.toString(strRowData);
						
						}
			 //=================================================
			 /*
		      Method Name	  :  setCellValue
		      Description     :  This method is used to write the data to the excel file. 
		      Author          :  Madhavi
		      Date            :  11th June 2020
		      Parameters      : String filepath -> ,String sheetname -> , int rowIndex -> , int colIndex -> , String name->
		      Modified Date   :  
		      Modified By     :
		*/
			   public static String[] setCellValue(String filepath, String sheetname, int rowIndex, int colIndex, String name)
				{
				 String[] strRowData = null;
				 	try {
				 	File file = new File(filepath);
				 	inpstr = new FileInputStream(file);
				 	workbook = new XSSFWorkbook(inpstr);
				 	XSSFSheet worksheet = workbook.getSheet(sheetname);
				 	
				 	 worksheet.getRow(rowIndex).createCell(colIndex).setCellValue(name);
				 	 //FileOutputStream – A FileOutputStream is an outputstream for writing data to a File.
				 	 FileOutputStream outstr = new FileOutputStream(filepath);
				 	 workbook.write(outstr);
				 	}
				 	
				 	catch(IOException e)	{
						System.out.println("File not found or unable to read/write data..");
					}
				catch(Exception e)	{
				System.out.println(e.getMessage());
				System.out.println("unknown exception"); 
				}
				return strRowData;
				}
			   
			   //==================================================================
			   /*
			      Method Name	  :  compareTwoSheets
			      Description     :  This method is used to write the data to the excel file. 
			      Author          :  Madhavi
			      Date            :  11th June 2020
			      Parameters      :  String filepath -> ,String sheet1 -> , String sheet2 -> 
			      Modified Date   :  
			      Modified By     :
			*/
			   public static boolean compareTwoSheets(String filepath,String sheet1, String sheet2) throws IOException {
					File file = new File(filepath);
					inpstr = new FileInputStream(file);
					workbook = new XSSFWorkbook(inpstr);
					
					XSSFSheet worksheet = workbook.getSheet(sheet1);
					XSSFSheet worksheet1 = workbook.getSheet(sheet2);
					
				    int firstRow1 = worksheet.getFirstRowNum();
				    int lastRow1 = worksheet.getLastRowNum();
				    
				    boolean equalSheets = true;
				    for(int i=firstRow1; i <= lastRow1; i++) {
				        
				        System.out.println("\n\nComparing Row "+i);
				        
				        XSSFRow row1 = worksheet.getRow(i);
				        XSSFRow row2 = worksheet1.getRow(i);
				        //if(!compareTwoRows(row1, row2)) {
				        if(row1.equals(row2)) {
				            equalSheets = false;
				            System.out.println("Row "+i+" - Not Equal");
				            break;
				        } else {
				            System.out.println("Row "+i+" - Equal");
				        }
				    }
				    return equalSheets;
				}
	//============================================================
	public static boolean compareFiles(String file1, String file2)
	{
		boolean bResult = false;
		
		
		
		return bResult;
	}
	
	//============================================================

}

