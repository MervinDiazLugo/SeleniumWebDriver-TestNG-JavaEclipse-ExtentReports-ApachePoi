import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_BPM {
	public class BPMTestNG {
		  private WebDriver driver;
		  private String baseUrl;
		  private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();

		  @BeforeClass(alwaysRun = true)
		  public void setUp() throws Exception {
		    System.setProperty ("webdriver.chrome.driver", "C:\\Users\\Yayo\\Desktop\\workspace\\Selenium3\\chromedriver_win32\\chromedriver.exe");
	 		ChromeOptions options = new ChromeOptions(); options.addArguments("C:\\Users\\Yayo\\AppData\\Local\\Google\\Chrome\\User Data"); 
	 		DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
	 		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	 		driver = new ChromeDriver(); 

		 	
		  }

		  @Test
		  public void testBPMTestNG() throws NoSuchElementException {
			  baseUrl = "https://bpm8502fix:9443";
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(baseUrl + "/ProcessPortal/");
				driver.manage().window().maximize();
				
				driver.findElement(By.id("username")).clear();
				driver.findElement(By.id("username")).sendKeys("mervind");
				driver.findElement(By.id("password")).clear();
				driver.findElement(By.id("password")).sendKeys("123456");
				driver.findElement(By.id("log_in")).click();
				driver.findElement(By.xpath("//*[@id='com_ibm_bpm_social_widgets_LaunchableProcessList_0']/ul/li[7]/a")).click();
			    System.out.println("Page title is: " + driver.getTitle()); 
			    
			   driver.findElement(By.xpath(".//*[@id='dijit_form_ComboBox_0']")).sendKeys("putas");
		    
		    
		  }

		  @AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }

		  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
		}

}





