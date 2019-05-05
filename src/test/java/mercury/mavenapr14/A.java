package mercury.mavenapr14;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class A 
{
	public WebDriver driver;
  @Test(priority=1)
  public void loginwithvalid1() 
  {
	  System.out.println("Login with user1");
	  driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("ankita4");
	  driver.findElement(By.cssSelector("input[name='password']")).sendKeys("ankita4");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  boolean exp_flag1=true;
	  AssertJUnit.assertEquals(act_flag1, exp_flag1);
	  System.out.println("Flight finder image is displayed:"+act_flag1);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("User1 is successfully login into Mercury Tours application");
  }
  
  @Test(priority=2)
  public void loginwithvalid2() 
  {
	  System.out.println("Login with user2");
	  driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("ankita5");
	  driver.findElement(By.cssSelector("input[name='password']")).sendKeys("ankita5");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  boolean exp_flag1=true;
	  AssertJUnit.assertEquals(act_flag1, exp_flag1);
	  System.out.println("Flight finder image is displayed:"+act_flag1);
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  System.out.println("User2 is successfully login into Mercury Tours application");
  }
  
  @Test(priority=3)
  public void loginwithinvalid() 
  {
	  System.out.println("Login with user3");
	  driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("ankitabb");
	  driver.findElement(By.cssSelector("input[name='password']")).sendKeys("ankitabb");
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  boolean act_flag1=driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).isDisplayed();
	  boolean exp_flag1=true;
	  AssertJUnit.assertEquals(act_flag1, exp_flag1);
	  System.out.println("Flight finder image is displayed:"+act_flag1); 

  }
  
  @BeforeMethod
  public void getcookies() 
  {
	System.out.println("In getcookies method under beforemethod");
	Set<Cookie> cookies=driver.manage().getCookies();
	for(Cookie c:cookies)
	{
		System.out.println("Cookie name="+c.getName());
	}
  }

  @AfterMethod
  public void capturescreenshot() throws IOException 
  {
	System.out.println("In capturescreenshot method under aftermethod");
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFileToDirectory(src, new File("F:\\newworkspace\\mavenapr14\\src\\test\\resources\\screenshot\\"));
  }

  @BeforeClass
  public void maximizebrowser() 
  {
	System.out.println("In maximizebrowser method under beforeclass");
	driver.manage().window().maximize();
  }

  @AfterClass
  public void deletcookies() 
  {
	  System.out.println("In deletcookies method under afterclass");
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void OpenApplicationURL() 
  {
	  System.out.println("In OpenApplicationURL method under beforetest");
	  driver.get("http://newtours.demoaut.com/");
  }

  @AfterTest
  public void dbconnection() 
  {
	  System.out.println("In dbconnection method under aftertest");

  }

  @BeforeSuite
  public void openbrowser() 
  {
	  System.out.println("in openbrowsermethod under beforesuite");
	  System.setProperty("webdriver.chrome.driver", "F:\\CJC\\testing software\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  System.out.println("Browser opened succefully");
  }

  @AfterSuite
  public void driverclose() 
  {
	  System.out.println("In driverclose method under aftersuite");
	  driver.close();
  }

}
