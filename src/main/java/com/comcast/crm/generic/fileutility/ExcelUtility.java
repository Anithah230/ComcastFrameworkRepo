package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ForkJoinWorkerThread;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getdatafromexcel(String sheetname,int rowno,int colno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/contactlastname.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		String data=w.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
		return data;
	}
	public int getrowcount(String sheetname,int rowno,int colno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/contactlastname.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		int rowcount=w.getSheet(sheetname).getLastRowNum();
		return rowcount;
	}
	public void setdataintoexcel(String sheetname,int rowno,int colno,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/contactlastname.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		w.getSheet(sheetname).getRow(rowno).createCell(colno);
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/contactlastname.xlsx");
		w.write(fos);
		w.close();
		
	}
}

		


		


