package week4.day2;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Assignment1_Nykaa {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions act = new Actions(driver);
		
		act.moveToElement(brands).perform();
		
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"][1]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//li//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		driver.findElement(By.xpath("//span[text()='Filters Applied']//following::span[text()='Shampoo']")).isDisplayed();
		
		WebElement productLink = driver.findElement(By.xpath("//div[@class='product-listing']//a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", productLink);
		
		Set<String> pagesSet = driver.getWindowHandles();
		
		List<String> pageList=new ArrayList<String>(pagesSet);
		
		driver.switchTo().window(pageList.get(1));
		
		WebElement sizeDD = driver.findElement(By.xpath("//select[@title='SIZE']"));   
		sizeDD.click();

		Select selSize = new Select(sizeDD);
		selSize.selectByIndex(1);
		
		String productPrice = driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span[1]")).getText();
		System.out.println("Product Price: " + productPrice.substring(1));
		
		driver.findElement(By.xpath("//span[text()='Add to Bag'][1]")).click();

		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		
		driver.switchTo().frame(0);
		
		WebElement findElement = driver.findElement(By.xpath("(//div/span[@color='#001325'])[2]"));
		String grandTotal = findElement.getText();
		int grandTotalAmount = Integer.parseInt(grandTotal.substring(1));
		System.out.println("Grand Total Amount: " + (grandTotal.substring(1)));
		
		WebElement proceed = driver.findElement(By.xpath("//span[text()='Proceed']"));
		
		System.out.println(proceed.isDisplayed());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(proceed));
		proceed.click();
				
		pagesSet = driver.getWindowHandles();
		pageList=new ArrayList<String>(pagesSet);
		
		for(String element: pageList) {
			System.out.println(driver.switchTo().window(element).getTitle());
		}
		System.out.println(pageList.size());
		driver.switchTo().window(pageList.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		driver.findElement(By.xpath("(//div/span/img)[7]")).click();
		
		String cost = driver.findElement(By.xpath("//div/p[text()='Price Details']/parent::div/following-sibling::p")).getText();
		int costAmount = Integer.parseInt(cost.substring(1));
		System.out.println("Total Price: " + costAmount);
		
		if(costAmount==grandTotalAmount) {
			System.out.println("Total Cost is equal");
		}
		else {
			System.out.println("Total Cost is not equal");
		}
		
		driver.quit();
	}

}
