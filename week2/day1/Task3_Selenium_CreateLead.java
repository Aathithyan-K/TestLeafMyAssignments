package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3_Selenium_CreateLead {

	public static void main(String[] args) throws InterruptedException {
		//Create Lead Task
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Aditya Corp");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Aathithyan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Aathithyan");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("K");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA Department");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("I am a Software Development Engineer in Test Engineer");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("aathithyank82@gmail.com");
		driver.findElement(By.name("submitButton")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is : " + pageTitle);
	}

}
