package com.iSEM_Project;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC_Purchase_02 {
	WebElement element;

	WebDriver driver;
	  @BeforeClass
	  public void setup() {
		  System.out.println("Launch Uel Successfully");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\system1\\eclipse-workspace\\selenium-java-3.141.59\\chromedriver_win\\chromedriver.exe");
		    driver= new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.get("http://www.isem.somee.com/#/login");
	  }
	  
	  @Test
	  public void login() throws InterruptedException {
		  driver.findElement(By.id("nf-email")).sendKeys("jaymaheta");
		  driver.findElement(By.id("nf-password")).sendKeys("admin");
		  driver.findElement(By.xpath("(//button[@type=\"button\"])[1]")).click();
	      System.out.println("Login Successfullly");
	      Thread.sleep(2000);
	}
	  
	  @Test 
	  public void purchase() throws InterruptedException {
		  System.out.println("Create bill");
		  WebElement PurcDrop =driver.findElement(By.xpath("(//a[@class=\"c-sidebar-nav-dropdown-toggle\"])[1]"));
		  JavascriptExecutor executor1=(JavascriptExecutor)driver;
		  executor1.executeScript("arguments[0].click()",PurcDrop);
		  driver.findElement(By.xpath("(//a[@href=\"#/purchases/bills\"])[1]")).click(); //Bill
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@class=\"btn btn-pill\"]")).click();  //Create Bill
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//button[@class=\"btn\"])[1]")).click(); //Vendor
		  driver.findElement(By.xpath("(//a[@href=\"#\"])[10]")).click(); //Select vendor 
		  WebElement currency = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[7]"));  //Currency
		  Select select = new Select (currency);
		  select.selectByIndex(1);
		  driver.findElement(By.xpath("(//input[@type='date'])[1]")).sendKeys("26/06/2021"); //Date
		  driver.findElement(By.xpath("(//input[@type='date'])[2]")).sendKeys("26/07/2021"); //Due Date
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[27]")).sendKeys("PO.NO.2021.01.12"); //PO Number
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[28]")).sendKeys("SO.NO.2021.01.12"); //SO Number
		  driver.findElement(By.xpath("(//input[@class=\"form-control\"])[29]")).sendKeys("B2021"); //Bill Number
		  driver.findElement(By.xpath("(//textarea[@class=\"form-control\"])[7]")).sendKeys("Notes"); //Notes
		  driver.findElement(By.xpath("(//button[@class=\"btn\"])[2]")).click();
		  driver.findElement(By.xpath("(//a[@href=\"#\"])[12]")).click();  // Select Item
		  driver.findElement(By.xpath("(//button[@class=\"btn btn-pill\"])[2]")).click();  //Save and Continue
		  Thread.sleep(5000);
		  System.out.println("Bill Create Successfully");
	  }
	  
	  
	  
	  
	  @AfterClass
	  public void close () {
		  driver.close();
		  System.out.println("Close window");
	  }
	
	
}
