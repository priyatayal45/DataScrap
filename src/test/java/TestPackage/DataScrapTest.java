package TestPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PagePackage.HomePage;
import utility.Baseclass;

public class DataScrapTest extends Baseclass

{
	@Test
	public void extractDataFromtable() throws IOException
	{
		HomePage page = new HomePage(driver);
		page.generateOutputFile();
	}
}
