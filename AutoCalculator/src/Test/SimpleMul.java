package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

public class SimpleMul 
{
	WebDriver driver;
  @Test
  public void Add() throws IOException 
  {
		  driver=new ChromeDriver();
		  driver.get("https://www.calculator.net/");
		  driver.findElement(By.xpath("//span[contains(text(),'4')]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'2')]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'3')]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'5')]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'2')]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'5')]")).click();
		  driver.findElement(By.xpath("//span[contains(text(),'=')]")).click();
		  if(driver.findElement(By.xpath("//div[@id='sciOutPut']")).isDisplayed()) {
				
				int year=LocalDateTime.now().getYear();
				int month=LocalDateTime.now().getMonthValue();
				int day=LocalDateTime.now().getDayOfMonth();
				int hour=LocalDateTime.now().getHour();
				int	min=LocalDateTime.now().getMinute();
				
				String filename=year+""+month+""+day+""+hour+""+min;
				
				File from=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File to=new File(".//Files//"+filename+".jpg");
				FileHandler.copy(from, to);
				}
				else {
					System.out.println("Operation failed");
				}
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver",
			  ".//lib//chromedriver.exe");
  }

  @AfterMethod
  public void afterMethod() {
  }

}
