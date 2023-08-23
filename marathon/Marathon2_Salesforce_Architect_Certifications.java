package testleaf.marathon;

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
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class Marathon2_Salesforce_Architect_Certifications {

	public static void main(String[] args) throws IOException {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(op);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowHandles);
		
		driver.switchTo().window(windowList.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		Shadow shadowhandle = new Shadow(driver);
		shadowhandle.setImplicitWait(10);
		shadowhandle.findElementByXPath("//span[text()='Learning']").click();
		
		Actions act=new Actions(driver);
		act.moveToElement(shadowhandle.findElementByXPath("//span[text()='Learning on Trailhead']")).perform();
		
		shadowhandle.findElementByXPath("//a[text()='Salesforce Certification']").click();
		
		driver.findElement(By.xpath("(//div[contains(@class,'roleMenu-item')]//div[@class='roleMenu-item_text'])[2]")).click();
		
		String roleName = driver.findElement(By.xpath("(//div[contains(@class,'roleMenu-item')]//div[@class='roleMenu-item_text'])[2]")).getText();
		System.out.println("Role Name is :" + roleName);
		
		String paragraph = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following-sibling::div[1]")).getText();
		System.out.println("Application paragraph is: " + paragraph);
		
		List<WebElement> courseList = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
		for(WebElement course: courseList) {
			System.out.println(course.getText());
		}
		
		WebElement screenshotElement = driver.findElement(By.xpath("//div[contains(@class,'cert-site_title')]/following-sibling::div[1]"));
		
		File screenshotAs = screenshotElement.getScreenshotAs(OutputType.FILE);
		File destn=new File("./snap/pic5.jpg");
		FileUtils.copyFile(screenshotAs, destn);
		
	}

}
