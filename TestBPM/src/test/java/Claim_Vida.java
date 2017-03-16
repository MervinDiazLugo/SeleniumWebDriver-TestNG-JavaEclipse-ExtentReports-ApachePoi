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

public class Claim_Vida {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  int CaptureN, Reporte;
  ExtentReports report;
  ExtentTest TestBPM; 
  String NombreReporte;
  String ScreenShot_Path;

 //Variables de Proceso 1 CARGAR LISTAS
  	String IdTarea= "1718";
	String URLInicial= "http://bpm8502fix:9080/teamworks/redirect-login.jsp?credentials=bWVydmluZA%3D%3D%3AMTIzNDU2&j_forward=process.lsw?zWorkflowState=1%26zTaskId=" + IdTarea + "%26applicationId=2%26applicationInstanceId=guid:850bbec95ddcfaaf:7300daf5:15aa3b068d2:-7ffe";


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
	NombreReporte= "Proceso Admitir Expediente";  
	report= new ExtentReports(".\\Reportes\\"+NombreReporte+ "-" +Reporte++ +".html");
	TestBPM=report.startTest(NombreReporte);
	  
	System.setProperty ("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver(); 
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(URLInicial);
	

	
  }

@Test
  public void AgregarDatosConctacto() throws Exception {
	
	TestBPM.log(LogStatus.INFO, "Se completo el paso Cargar Listas del proceso");
	
	NombreReporte= "Agregar Datos de Conctacto";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Agregar Datos de Conctacto");
	
	
    
    //driver.switchTo().frame(2);
	
	//Lugar Notificación Real
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_0')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_0')]")).sendKeys("Canal");
    
	//Tipo Trámite 
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_1']")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_1']")).sendKeys("Canal Tradicional");
	
	//Prioridad
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_2')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_2')]")).sendKeys("Bajo");
    
	// Tipo de Documento
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_9')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_9')]")).sendKeys("DNI");
    
	// Numero de Documento
	driver.findElement(By.xpath("//input[@id='dijit_form_ComboBox_3']")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_ComboBox_3']")).sendKeys("95625072");
    
	// Apellidos
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_4')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_4')]")).sendKeys("Diaz");
    
	// Nombres
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_5')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_5')]")).sendKeys("Mervin");
	
	//Direccion
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_6')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_6')]")).sendKeys("Santiago del Esteros 2060");
    
	//Pais Perú
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_RadioButton_0')]")).click();
    
    //Extranjero
    //driver.findElement(By.xpath("//input[contains(@id,'dijit_form_RadioButton_1')]")).click();
    
    //Departamento
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_10')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_10')]")).sendKeys("LIMA");
    Thread.sleep(3000);
    
    //Provincia
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_11')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_11')]")).sendKeys("YAUYOS");
    Thread.sleep(3000);
    
    //Distrito
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_12')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_12')]")).sendKeys("COLONIA");
    
    //Telefono1
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_7')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_7')]")).sendKeys("1168677091");
    
    //Telefono2
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_8')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_8')]")).sendKeys("1168677092");
    
    //Email1
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_9')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_9')]")).sendKeys("mervindiazlugo@gmail.com");
    
    //Email2
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_10')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_10')]")).sendKeys("diazmervin@hotmail.com");
    
    //Notificaciones NO
    //driver.findElement(By.xpath("//input[contains(@id,'dijit_form_RadioButton_2')]")).click();
    
    //Notificaciones SI
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_RadioButton_3')]")).click();
    
    Thread.sleep(10000);
    driver.findElement(By.xpath("//button[contains(.,'Agregar')]")).click();
    
    Thread.sleep(20000);
    
    ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, "EditarDatosContacto"+Integer.toString(CaptureN++)) + ">";  
	TestBPM.log(LogStatus.INFO, "Agregar Datos de Contacto", ScreenShot_Path);
	
  //Recargar la pagina
    driver.get(URLInicial);
    WebElement boton = driver.findElement(By.xpath("//button[contains(.,'Editar')]"));
    Assert.assertEquals(true, boton.isDisplayed());
    


  }
  
  @Test
  public void EditarDatosContacto() throws Exception {
	 NombreReporte= "Editar Datos de Conctacto";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Editar Datos de Conctacto");

   
	//Borrar todo el Formulario
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_0')]")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_1']")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_2')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_9')]")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_ComboBox_3']")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_4')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_5')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_6')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_10')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_11')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_12')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_7')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_8')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_9')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_10')]")).clear();
 
	 Thread.sleep(3000);
	 
	 //Seleccionar un elemento de la Grid
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div")).click();
	Thread.sleep(3000);
	//Eliminar el elemento
	driver.findElement(By.xpath("//button[contains(.,'Eliminar')]"));
	Thread.sleep(30000);
	
	//driver.findElement(By.xpath("//button[contains(.,'Editar')]")).click();
    
	//Thread.sleep(20000);
	
    //WebElement boton = driver.findElement(By.xpath("//button[contains(.,'Editar')]"));
   // Assert.assertEquals(true, boton.isDisplayed());
    
	  
	

  }
 
 
@AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result)
  {
	ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, "Claim_Vida"+Integer.toString(CaptureN++)) + ">";
	  
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  
		  TestBPM.log(LogStatus.FAIL, "Editar Datos de Contacto", ScreenShot_Path);
	  }else {
		 
		  TestBPM.log(LogStatus.PASS, "Editar Datos de Contacto", ScreenShot_Path);
		  
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
