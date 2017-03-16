import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lib.CaptureScreenshot;

import static org.testng.Assert.*;

import org.apache.bcel.classfile.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Metricas {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  int CaptureN, Reporte;
  ExtentReports report;
  ExtentTest TestBPM; 
  String NombreReporte;
  String ScreenShot_Path;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty ("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver(); 
    baseUrl = "https://bpm8502fix:9443";
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
    //Se inicializa el Reporte conjuntamente con la apertura de la aplicacion
	NombreReporte= "Reportes de Metricas";
	report= new ExtentReports(".\\Reportes\\"+NombreReporte+ "-" +Reporte++ +".html");
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Se inicializo el Navegador");
	driver.get(baseUrl + "/ProcessPortal/login.jsp");
	
	//Se Inicia Sesion en BPM
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("mervind");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.id("log_in")).click();
    
  }

  @Test
  public void testMetricas_SA() throws Exception {

    driver.findElement(By.linkText("Métricas")).click();
    
    TestBPM.log(LogStatus.INFO, "Se inicializo la aplicacion");
    TestBPM.log(LogStatus.INFO, "Prueba de Funcionalidad Solicitudes Atendidas");
    
    driver.switchTo().frame(1);
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_CheckBox_1')]")).click();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_0')]")).sendKeys("Mervin");
    driver.findElement(By.xpath("//input[contains(@aria-labelledby,'widget_InputContainer_uniqName_1_0_label div_2_1_2_1_2_1_1_label')]")).clear();
    driver.findElement(By.xpath("//input[contains(@aria-labelledby,'widget_InputContainer_uniqName_1_0_label div_2_1_2_1_2_1_1_label')]")).sendKeys("01/01/2017");
    driver.findElement(By.xpath("//button[contains(.,'Buscar')]")).click();
    
    Thread.sleep(5000);
    WebElement tabla = driver.findElement(By.xpath("//h2[contains(.,'Solicitudes Atendidas')]"));
    Assert.assertEquals(true, tabla.isDisplayed());
    
  }
  
  @Test
  public void testMetricas_SAI() throws Exception {

	    
		driver.get(baseUrl + "/ProcessPortal");
		driver.findElement(By.linkText("Métricas")).click();
	    TestBPM.log(LogStatus.INFO, "Se inicializo la aplicacion");
	    TestBPM.log(LogStatus.INFO, "<b>Prueba de Funcionalidad Solicitudes Atendidas</b> - Rango de fechas");
	    
	    driver.switchTo().frame(1);
	    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_CheckBox_1')]")).click();
	    driver.findElement(By.xpath("//input[contains(@aria-labelledby,'widget_InputContainer_uniqName_1_0_label div_2_1_2_1_2_1_1_label')]")).clear();
	    driver.findElement(By.xpath("//input[contains(@aria-labelledby,'widget_InputContainer_uniqName_1_0_label div_2_1_2_1_2_1_1_label')]")).sendKeys("01/01/2017");
	    driver.findElement(By.xpath("//button[contains(.,'Buscar')]")).click();
	    
	    Thread.sleep(5000);
	    WebElement tabla = driver.findElement(By.xpath("//h2[contains(.,'Solicitudes Atendidas')]"));
	    Assert.assertEquals(true, tabla.isDisplayed());
	    

	  }
  
  
@AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result)
  {
	   ScreenShot_Path= "<img src="+CaptureScreenshot.ScreenShot(driver, result.getName())+">";
	  
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  
		  TestBPM.log(LogStatus.FAIL, "Ha fallado la Prueba", ScreenShot_Path);
		  
	  }else {
		 
		  TestBPM.log(LogStatus.PASS, "Se culmino la prueba Exitosamente", ScreenShot_Path);
		  
	  }
	  
	  report.endTest(TestBPM);
	  report.flush();
	  
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
