package mercurymulti;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class mercurytourstest {
	private WebDriver driver;
	@BeforeClass
	public void run_the_browser(){
		System.setProperty("webdriver.chrome.driver","D:\\dokjunk\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("beforeclass");
		//driver.manage().window().maximize();
	
	}
	@Test(priority=1)
	  public void user_should_navigate_to_google_page(){
			//String url="https://www.google.co.in";
		String url="http://newtours.demoaut.com/";
			driver.get(url);
			String PageTitle=driver.getTitle();
			System.out.println(PageTitle);
			//System.out.println("test1");
		}
		
	 @Test(priority=2)
	  public void user_should_logintotours(){
		 
			driver.findElement(By.name("userName")).sendKeys("drai");
			driver.findElement(By.name("password")).sendKeys("infosys16");
			System.out.println("entered in search box");
			driver.findElement(By.name("login")).click();
			} 
	@Test(priority=3)
    public void user_click_on_newstab(){
		String singnoff =driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]")).getText();
		System.out.println(singnoff+" "+"on flight booking page");
		
	}
	@Test(priority=4)
    public void flight_booking(){
		driver.findElement(By.name("tripType")).sendKeys("roundtrip");
		driver.findElement(By.name("passCount")).sendKeys("1");
		driver.findElement(By.name("fromPort")).sendKeys("Frankfurt");
		driver.findElement(By.name("fromMonth")).sendKeys("2");
		driver.findElement(By.name("fromDay")).sendKeys("2");
		driver.findElement(By.name("toPort")).sendKeys("London");
		driver.findElement(By.name("toMonth")).sendKeys("3");
		driver.findElement(By.name("toDay")).sendKeys("4");
		driver.findElement(By.name("servClass")).sendKeys("Business");
		driver.findElement(By.name("airline")).sendKeys("No Preference");
		driver.findElement(By.name("findFlights")).click();
		driver.findElement(By.name("outFlight")).sendKeys("Blue Skies Airlines$361$271$7:10");
		driver.findElement(By.name("inFlight")).sendKeys("Blue Skies Airlines$631$273$14:30");
		driver.findElement(By.name("reserveFlights")).click();
		
		
	}
	@Test(priority=5)
    public void flight_bookingconfirm(){
		driver.findElement(By.name("passFirst0")).sendKeys("deepshikha");
		driver.findElement(By.name("passLast0")).sendKeys("rai");
		driver.findElement(By.name("buyFlights")).click();
		String Successmessage=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")).getText();
		System.out.println(Successmessage);
	}
		
	
	@AfterClass
	public void close_chrome(){
		driver.quit();
		
	}
}
	

