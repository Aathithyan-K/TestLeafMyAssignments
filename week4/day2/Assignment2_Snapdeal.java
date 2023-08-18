package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment2_Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		
		WebElement menFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		
		Actions mouseHover = new Actions(driver);
		mouseHover.moveToElement(menFashion).perform();
		
		driver.findElement(By.xpath("//span[text()=\"Sports Shoes\"][1]")).click();
		
		String text = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		int count = Integer.parseInt(text.replaceAll("[^0-9]", ""));
		System.out.println("Sports Shoes Counts are: " + count);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		
		String selectSort = driver.findElement(By.xpath("//li[@data-sorttype='plth']")).getAttribute("innerHTML");
		selectSort = selectSort.replaceAll("(<.+>)", "");
		selectSort = selectSort.trim();
		
		String selectedSortValue = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		System.out.println("Select Sort Value is: " + selectSort);
		System.out.println("Selected Sort Value is: " + selectedSortValue);
		
		if(selectSort.equalsIgnoreCase(selectedSortValue)) {
			System.out.println("Selected sort is equal");
		}
		else {
			System.out.println("Selected sort is not equal");
		}
		int lowValue = 900;
		int highValue = 1200;
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys(String.valueOf(lowValue));
		
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys(String.valueOf(highValue));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		WebElement checkDisabledAttribute = driver.findElement(By.xpath("//span[contains(@class,'White')]/parent::label/parent::div[contains(@class,'sdCheckbox')]"));	
		String attribute = checkDisabledAttribute.getAttribute("class");
		boolean checkDisableStatus = attribute.contains("inactive-filter");
		System.out.println("Disabled: " + checkDisableStatus);
		
		String color = "White";
		
		if(!checkDisableStatus) {
			WebElement colorElement = driver.findElement(By.xpath("//label/span[contains(@class, '"+color+"')]"));
			driver.executeScript("arguments[0].click()", colorElement);
		}
		else {
			System.out.println("This color is not available for the product");
		}

		String getPrice = driver.findElement(By.xpath("//div[@class='filters-top-selected']//div[contains(text(),'Price')]/a")).getText();
		System.out.println("Price filter price value: " + getPrice);
		
		String numbersWithSpace = getPrice.replaceAll("[^0-9]", " ");
		
		String[] splitNumArray = numbersWithSpace.split(" ");
		
		List<String> list = new ArrayList<String>();
		
		for(String num: splitNumArray) {
			if(num != null && num.length()>0) {
				list.add(num);
			}
		}
		int splitNumIntArray[] = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			splitNumIntArray[i] = Integer.parseInt(list.get(i));
		}
		
		if(splitNumIntArray[0] >= lowValue && splitNumIntArray[1] <= highValue) {
			System.out.println("Price Filter is applied!");
		}
		else {
			System.out.println("Price Filter is not applied!");
		}
		
		String getColor = driver.findElement(By.xpath("//div[@class='filters-top-selected']//div[contains(text(),'Color')]/a")).getText();
		System.out.println("Color filter color value: " + getColor);
		
		boolean isSameColor = getColor.contains(color);
		
		if(isSameColor) {
			System.out.println("Color Filter is applied");
		}
		else {
			System.out.println("Color Filter is not applied");
		}
		
		Actions actionHover=new Actions(driver); 
		actionHover.moveToElement(driver.findElement(By.xpath("//div[@data-js-pos='0']"))).perform();
		driver.findElement(By.xpath("//div[@data-js-pos='0']//div[contains(text(),'Quick View')]")).click();
		
		String prodPrice = driver.findElement(By.xpath("//div[contains(@class,'product-price')]/span[1]")).getText();
		System.out.println("Product Price is : " + prodPrice);
		
		String prodDiscount = driver.findElement(By.xpath("//div[contains(@class,'product-price')]/span[2]")).getText();
		System.out.println("Product Discount is : " + prodDiscount);
		
		WebElement snapOfWebElement = driver.findElement(By.xpath("//div[contains(@class,'mainWidgetquickView')]"));
		File snap = snapOfWebElement.getScreenshotAs(OutputType.FILE);
		File shot=new File("./snap/product.jpg");
		FileUtils.copyFile(snap, shot);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'close')]/i[1]")).click();
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
