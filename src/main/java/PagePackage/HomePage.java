package PagePackage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.tools.javac.util.Assert;

import utility.Baseclass;

public class HomePage

{
	WebDriver driver;
	
	@FindBy(xpath ="//tbody/tr")
	List<WebElement> rows ;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void generateOutputFile() throws IOException
	{
		   String filePath = System.getProperty("user.dir") + "/output.csv";
		   FileWriter writer = new FileWriter(filePath);
		   
		   writer.append("Hours,Low,High,Last,Weight Avg");
	       writer.append("\n");
	       int dataIndex = 0;

	       for (WebElement row : rows) {
	    	   List<WebElement> cols = row.findElements(By.tagName("td"));
	           if (cols.size() < 4 || cols.get(0).getText().equals("-")) {
	               continue;
	           }

	           if (dataIndex % 2 == 0) {
	               int hour = dataIndex / 2;
	               String hourBlock = String.format("%02d-%02d", hour, hour + 1);
	               writer.append(" " +hourBlock).append(",-,-,-,-");
	               writer.append("\n");
	           }

	           int totalMinutes = dataIndex * 30;
	           int startHour = totalMinutes / 60;
	           int startMin = totalMinutes % 60;

	           int endMinutes = totalMinutes + 30;
	           int endHour = endMinutes / 60;
	           int endMin = endMinutes % 60;

	           String timeSlot = String.format("%02d:%02d-%02d:%02d",startHour, startMin, endHour, endMin);

	           String low = cols.get(0).getText();
	           String high = cols.get(1).getText();
	           String last = cols.get(2).getText();
	           String weightAvg = cols.get(3).getText();

	           writer.append(timeSlot).append(",") .append(low).append(",").append(high).append(",").append(last).append(",").append(weightAvg);
	           writer.append("\n");

	           dataIndex++;
	       }
           writer.flush();
	       writer.close();		
	}
	
}
