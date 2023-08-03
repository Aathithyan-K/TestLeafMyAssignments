package testleaf.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Marathon1_PVR {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//div[contains(@class,'navbar-menu')]//div[@class='nav-icon']")).click();

		driver.findElement(By.xpath("//a[text()='Movie Library']")).click();
		
		WebElement city = driver.findElement(By.name("city"));
		Select citySelect = new Select(city);
		citySelect.selectByValue("Chennai");
		
		WebElement genre = driver.findElement(By.name("genre"));
		Select genreSelect = new Select(genre);
		genreSelect.selectByVisibleText("ANIMATION");
		
		WebElement language = driver.findElement(By.name("lang"));
		Select langSelect = new Select(language);
		langSelect.selectByVisibleText("ENGLISH");
		
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		Thread.sleep(5000);
		
		WebElement movieSelect = driver.findElement(By.xpath("(//div[contains(@class,'movie-wrapper')]//div[@class='info'])[1]"));
		driver.executeScript("arguments[0].click();", movieSelect);
		
		driver.findElement(By.xpath("//button[text()='Proceed To Book']")).click();
		
		WebElement cinema = driver.findElement(By.name("cinemaName"));
		Select cinemaSelect = new Select(cinema);
		cinemaSelect.selectByValue("PVR Heritage RSL ECR Chennai");
		
		driver.findElement(By.xpath("//div[@class='pvr-datepicker']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'9')]")).click();
		
		
		WebElement showTiming = driver.findElement(By.xpath("//select[@name='timings']"));
		Select showTimingSelect = new Select(showTiming);
		showTimingSelect.selectByValue("09:00 AM - 12:00 PM");
		
		driver.findElement(By.xpath("//input[@name='noOfTickets']")).sendKeys("5");
		driver.findElement(By.name("name")).sendKeys("Aathithyan");
		driver.findElement(By.name("email")).sendKeys("aathithyan@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("9876543218");
		
		WebElement food = driver.findElement(By.name("food"));
		Select foodSelect = new Select(food);
		foodSelect.selectByValue("Yes");
		
		driver.findElement(By.name("comment")).sendKeys("Nil");
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='custom-control-indicator']")));
		driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();
		
		WebElement cancelButton = driver.findElement(By.xpath("(//li[contains(@class,'cancel-btn')]/button[text()='CANCEL'])[2]"));
		cancelButton.click();
		
		driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
		
		System.out.println("The page title is: " + driver.getTitle());
	}

}
