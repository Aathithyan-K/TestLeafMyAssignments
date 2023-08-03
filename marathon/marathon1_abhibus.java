package testleaf.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class marathon1_abhibus {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("(//a[text()='Bus'])[1]")).click();
		driver.findElement(By.id("source")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@class='ui-menu-item ui-state-focus']")).click();
		
		driver.findElement(By.id("destination")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@class='ui-menu-item ui-state-focus']")).click();
		
		driver.findElement(By.id("datepicker1")).click();
		driver.findElement(By.xpath("(//td/a[text()='4'])[1]")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		driver.findElement(By.id("Bustypes4")).click();
		
		System.out.println("Bus Name: " + driver.findElement(By.xpath("(//h2[@class='TravelAgntNm ng-binding'])[1]")).getText());
		System.out.println("Bus Type: " + driver.findElement(By.xpath("(//p[@class='BsTyp ng-binding'])[1]")).getText());
		System.out.println("Available seat counts: " + driver.findElement(By.xpath("(//p[@class='noseats AvailSts ng-binding'])[1]")).getText());
		
		driver.findElement(By.xpath("(//span[text()='Select Seat'])[1]")).click();
		
		driver.findElement(By.xpath("//li[contains(@class,'sleeper available')]/a")).click();
		System.out.println("Seat Number: " + driver.findElement(By.xpath("//span[@id='seatnos']")).getText());
		System.out.println("Seat Cost: " + driver.findElement(By.xpath("//span[@id='ticketfare']")).getText());
		
		WebElement boardingPoint = driver.findElement(By.id("boardingpoint_id"));
		Select boardingPointSelect = new Select(boardingPoint);
		boardingPointSelect.selectByIndex(5); 
		
		WebElement droppingPoint = driver.findElement(By.id("droppingpoint_id"));
		Select droppingPointSelect = new Select(droppingPoint);
		droppingPointSelect.selectByIndex(5);
		
		System.out.println("Page Title is: " + driver.getTitle());
		
		driver.close();
	}

}
