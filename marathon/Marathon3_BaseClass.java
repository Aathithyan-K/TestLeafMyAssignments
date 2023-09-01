package testleaf.marathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Marathon3_BaseClass {
	public RemoteWebDriver driver;

	public String fileName;
	
	@Parameters({"url","username","password","browser"})
	@BeforeMethod
	public void preCondition(String url, String username, String password, String browser) {
		ChromeOptions chromeOp=new ChromeOptions();
		EdgeOptions edgeOp = new EdgeOptions();
		chromeOp.addArguments("--disable-notifications");
		edgeOp.addArguments("--disable-notifications");
		if(browser.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver(chromeOp);
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver(edgeOp);
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();

		driver.findElement(By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();

	}
	  @AfterMethod
	  public void postcondition() { 
		  driver.close(); 
	  }
	  
	  @DataProvider(name="fetchData")
		public String[][] sendData() throws IOException{
			String[][] readExcel = Marathon3_ReadExcel.readExcel(fileName);
			return readExcel;
		}
}
