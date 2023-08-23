package testleaf.marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.sukgu.Shadow;

public class Marathon2_ServiceNow_Order_Mobile {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://dev146490.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Uouh$-9J2cIU");
		driver.findElement(By.id("sysverb_login")).click();
		
		Shadow shadowhandle = new Shadow(driver);
		shadowhandle.setImplicitWait(15);
		shadowhandle.findElementByXPath("//div[text()='All']").click();
		
		shadowhandle.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog",Keys.ENTER);
		shadowhandle.findElementByXPath("//mark[text()='Service Catalog']").click();
		
//		driver.switchTo().frame("gsft_main");
//		WebElement shadowDomHost = driver.findElement(By.xpath("//macroponent-f51912f4c700201072b211d4d8c26010"));
//		SearchContext shadowDomRoot = shadowDomHost.getShadowRoot();
//		shadowDomRoot.findElement(By.cssSelector("td[class*='homepage_category_only_image_cell']"));
		
		Thread.sleep(5000);
		WebElement shadowDomHost = driver.findElement(By.cssSelector("macroponent-f51912f4c700201072b211d4d8c26010"));
//		Object executeScript = ((RemoteWebDriver) driver).executeScript("return arguments[0].shadowRoot", shadowDomHost);
//		WebElement shadowDomRoot = (WebElement) executeScript;
		SearchContext shadowDomRoot = shadowDomHost.getShadowRoot();
		Thread.sleep(1000);
		WebElement iframe = shadowDomRoot.findElement(By.cssSelector("#gsft_main"));
		
		driver.switchTo().frame(iframe);
		
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("//h2/strong[text()='Apple iPhone 13 pro']")).click();
		
		String yesOrNo = driver.findElement(By.xpath("//span[@class='input-group-radio']//label")).getText();
		System.out.println("Yes or No:" + yesOrNo);
		if(yesOrNo.equalsIgnoreCase("Yes")) {
			driver.findElement(By.xpath("//span[@class='input-group-radio']/label")).click();
		}
		
		driver.findElement(By.xpath("(//input[contains(@class,'cat_item_option')])[4]")).sendKeys("99");
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select sel = new Select(dropDown);
		sel.selectByIndex(2);
		
		driver.findElement(By.xpath("//span[@class='input-group-radio']//label[contains(text(),'Sierra Blue')]")).click();
		
		driver.findElement(By.xpath("//span[@class='input-group-radio']//label[contains(text(),'512 GB')]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Order Now')]")).click();
		
		Boolean Display = driver.findElement(By.xpath("//dt[contains(text(),'Order Placed:')]/following-sibling::dd/b")).isDisplayed();
		String orderPlace = driver.findElement(By.xpath("//dt[contains(text(),'Order Placed:')]/following-sibling::dd/b")).getText();
		
		if(Display) {
			System.out.println("Order is placed and details are: " + orderPlace);
		}
		else{
			System.out.println("Order element is not present or not placed");
		}
		
		String requestId = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
		System.out.println("Request Id is: " + requestId);
		
		WebElement orderDetailElement = driver.findElement(By.xpath("//body[@data-formname='ui_page_render']"));
		
		File screenshotAs = orderDetailElement.getScreenshotAs(OutputType.FILE);
		File destn=new File("./snap/orderDetails.jpg");
		FileUtils.copyFile(screenshotAs, destn);
	}

}
