package testleaf.marathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Marathon3_Salesforce_TC1_Chrome extends Marathon3_BaseClass {

	@BeforeTest
	public void setData() {
		fileName = "Salesforce_Question";
	}
	
	@Test(dataProvider = "fetchData")
	public void runTC1(String question, String detail) {
		
		driver.findElement(By.xpath("//span/p[text()='Content']")).click();
		
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatter);
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(question);
		driver.findElement(By.xpath("//div[contains(@class, 'content slds-text-color_weak slds-grow')]")).sendKeys(detail);
		driver.findElement(By.xpath("//button[contains(@class, 'qe-questionPostDesktop MEDIUM')]")).click();
		String ques = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		System.out.println("Question is: " + ques);
		if (ques.contains(question)) {
			System.out.println("Question is Appeared successfully");
			
		}
		
	}

}
