package testleaf.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Marathon1_Amazon {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		driver.findElement(By.xpath("//div[@class='s-suggestion-container']/div[text()='bags']/span[text()=' for boys']")).click();
		
		String stringValue = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[text()='1-48 of over 50,000 results for']")).getText();
		String strArray[] = stringValue.split(" ");
		System.out.println("Total Results count is: " + strArray[3]);
		
		driver.findElement(By.xpath("(//ul[@aria-labelledby='p_89-title']//div[contains(@class,'a-checkbox')])[1]")).click();
		driver.findElement(By.xpath("(//ul[@aria-labelledby='p_89-title']//div[contains(@class,'a-checkbox')])[2]")).click();
		
		driver.findElement(By.xpath("//span[@class='a-button-inner']//span[text()='Sort by:']")).click();
		driver.findElement(By.id("s-result-sort-select_4")).click();
		
		System.out.println("Bag Name is: " + driver.findElement(By.xpath("(//div[@data-index='2']//span)[3]")).getText());
		System.out.println("Bag Cost is: " + driver.findElement(By.xpath("(//div[@data-index='2']//span[@class='a-price-whole'])")).getText());
		
		System.out.println("Page Title is : " + driver.getTitle());
	}
}
