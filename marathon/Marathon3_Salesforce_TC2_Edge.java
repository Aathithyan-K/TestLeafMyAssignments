package testleaf.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class Marathon3_Salesforce_TC2_Edge extends Marathon3_BaseClass{

	@BeforeTest
	public void setData() {
		fileName = "salesforce_opportunity_data";
	}
	
	@Test(dataProvider = "fetchData")
	public void runTC2(String Opportunity,String Amount) {
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement  chatter= driver.findElement(By.xpath("//a/span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", chatter);
		
		driver.findElement(By.xpath("//a/div[text()='New']")).click();
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(Opportunity);
		
		driver.findElement(By.xpath("//label[text()='Type']")).click();		
		driver.findElement(By.xpath("//span[@title='New Customer']")).click();
		
		driver.findElement(By.xpath("//label[text()='Lead Source']")).click();
		driver.findElement(By.xpath("//span[@title='Partner Referral']")).click();
		String amountStr = String.valueOf(Amount);
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amountStr);
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		driver.findElement(By.xpath("//td[contains(@class,'today')]/following-sibling::td")).click();
		
		driver.findElement(By.xpath("//label[contains(text(),'Stage')]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
		driver.findElement(By.xpath("//label[text()='Primary Campaign Source']")).click();
		driver.findElement(By.xpath("//span[@title='Sample']")).click();
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		WebElement opportunityName = driver.findElement(By.xpath("//div[text()='Opportunity']/following-sibling::slot/lightning-formatted-text"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Opportunity']/following-sibling::slot/lightning-formatted-text")));
		String nameValue = opportunityName.getText();
		
		if(Opportunity.equals(nameValue)) {
			System.out.println("Opportunity is created!");
		}
		else {
			System.out.println("Opportunity is not created!");
		}
	}
}
