package project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon1 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
	    WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
	    search.sendKeys("oneplus 9pro"+Keys.ENTER);
	    
	    WebElement price=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
	    String rate=price.getText();
	    System.out.println(rate);
	    
	    WebElement rating =driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-micro']//div[@class='a-row a-size-small'])[1]"));
	    String starrate=rating.getText();
	    System.out.println("customer rating is  "+starrate);
		 
	    WebElement image=driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]"));
	    image.click();
	    
	   Set<String>window= driver.getWindowHandles();
	   for (String newwin : window) {
		   driver.switchTo().window(newwin);
		
	}
	   File  screenshot=driver.getScreenshotAs(OutputType.FILE);
	   File destntn=new File("./snapshot/img.png");
	   FileUtils.copyFile(screenshot, destntn);
	   
	   WebElement addtocart=driver.findElement(By.id("add-to-cart-button"));
	   addtocart.click();
	   
	   WebElement rate1=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
	   String rate2=rate1.getText();
	   System.out.println(rate2);
	   
	   if(rate2.equals(rate)) {
		   System.out.println("same price");
	   }
	   
		 
		
	}

}
