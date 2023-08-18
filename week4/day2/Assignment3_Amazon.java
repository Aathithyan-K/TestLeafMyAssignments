package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3_Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		Thread.sleep(5000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);	
		
		String price = driver.findElement(By.xpath("//div[@data-index='5']//span[@class='a-price']")).getText();
		price = price.substring(1);
		price = price.replaceAll("[^0-9]", "");
		int priceAmount = Integer.parseInt(price);
		System.out.println("Price Amount: " + priceAmount);
		
		String ratings = driver.findElement(By.xpath("(//span[contains(@aria-label,'out of 5 stars')])[3]")).getAttribute("aria-label");
		System.out.println("Rating is : " + ratings);
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//div[@data-index='5']//span[contains(text(),'OnePlus')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWH = new ArrayList<>(windowHandles);
		
		driver.switchTo().window(listWH.get(1));
		
		WebElement snapOfWebElement = driver.findElement(By.xpath("//div[@class='a-container']"));
		File snap = snapOfWebElement.getScreenshotAs(OutputType.FILE);
		File shot=new File("./snap/product.jpg");
		FileUtils.copyFile(snap, shot);
		
		Thread.sleep(10000);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(10000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		String attribute = element.getText();

		attribute = attribute.substring(1);
		attribute = attribute.replaceAll("\\.\\d+$", "");
		attribute = attribute.replaceAll("[^0-9]", "");
		int subTotal = Integer.parseInt(attribute);
		System.out.println("SubTotal is: " + subTotal);
		if(priceAmount==subTotal) {
			System.out.println("Both price are same");
		}
		else {
			System.out.println("Both price are not same");
		}
		
		driver.quit();
	}

}
