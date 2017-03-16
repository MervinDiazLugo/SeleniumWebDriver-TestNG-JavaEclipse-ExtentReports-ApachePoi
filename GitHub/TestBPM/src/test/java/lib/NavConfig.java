package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NavConfig {

	 WebDriver driver;
	
public static void InternerExplorer()throws Exception
	{
		System.setProperty("webdriver.ie.driver", ".\\IEDriverServer_win32\\IEDriverServer.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

		
	}
	
public static void GoogleChrome()throws Exception
	{
		System.setProperty ("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
		
	}
	
	
}
