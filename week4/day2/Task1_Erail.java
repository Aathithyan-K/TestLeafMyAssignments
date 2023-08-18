package week4.day2;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_Erail {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS",Keys.ENTER);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("CBE",Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		driver.findElement(By.id("buttonFromTo")).click();
		
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'TrainList')]/tbody"));
		
		 List<WebElement> row = table.findElements(By.tagName("tr"));
		 
		 System.out.println(row.size());
		    
		 List<WebElement> col = row.get(1).findElements(By.tagName("td"));
		 System.out.println(col.size());
		 
		 System.out.println("Train Names are: ");
		 List<WebElement> SecondColallData = driver.findElements(
                 By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//td[2]"));
		 Set<String> uniqueTrainList = new LinkedHashSet<String>();
		 
         for (WebElement ColValues : SecondColallData) {
             uniqueTrainList.add(ColValues.getText());
         }
         
         for(String uniqueTrain: uniqueTrainList) {
        	 System.out.println(uniqueTrain);
         }
         
	}

}
