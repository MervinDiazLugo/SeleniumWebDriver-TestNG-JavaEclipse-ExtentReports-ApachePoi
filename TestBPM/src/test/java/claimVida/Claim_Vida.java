package claimVida;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lib.CaptureScreenshot;
import lib.NavConfig;

import static org.testng.Assert.*;

import org.apache.bcel.classfile.Utility;
import org.openqa.grid.web.servlet.handler.SeleniumBasedRequest;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Claim_Vida {
  WebDriver driver;
  String baseUrl;
  boolean acceptNextAlert = true;
  StringBuffer verificationErrors = new StringBuffer();
  int CaptureN, Reporte=1;
  ExtentReports report;
  ExtentTest TestBPM; 
  String NombreReporte, TestCaptura;
  String ScreenShot_Path, tag1;
  Boolean isPresente;
  
  Boolean chBox, chBox1;
  
 //Inicializa tarea segun ID de Tarea
  	String IdTarea= "1813";
	String URLInicial= "http://bpm8502fix:9080/teamworks/redirect-login.jsp?credentials=bWVydmluZA%3D%3D%3AMTIzNDU2&j_forward=process.lsw?zWorkflowState=1%26zTaskId=" + IdTarea + "%26applicationId=2%26applicationInstanceId=guid:850bbec95ddcfaaf:7300daf5:15aa3b068d2:-7ffe";
	String URLSecundaria="http://bpm8502fix:9080/teamworks/redirect-login.jsp?credentials=bWVydmluZA%3D%3D%3AMTIzNDU2&j_forward=process.lsw?zWorkflowState=1%26zTaskId="+ String.valueOf(Integer.valueOf(IdTarea) + 1) +"%26applicationId=2%26applicationInstanceId=guid:141dc95be660a7ec:-357179ce:15aae32651f:-7ffe";
	
	
	//http://bpm8502fix:9080/teamworks/redirect-login.jsp?credentials=bWVydmluZA%3D%3D%3AMTIzNDU2&j_forward=process.lsw?zWorkflowState=1%26zTaskId=1756%26applicationId=2%26applicationInstanceId=guid:850bbec95ddcfaaf:7300daf5:15aa3b068d2:-7ffe

	public void IExplorer()
	{
		
		System.setProperty("webdriver.ie.driver", ".\\IEDriverServer_win32\\IEDriverServer.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URLInicial);

	}

	public void GChrome()
	{
		
		System.setProperty ("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URLSecundaria);

	} 
	
@BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
	NombreReporte= "Proceso Admitir Expediente";  
	report= new ExtentReports(".\\Reportes\\"+NombreReporte+ "-" +Reporte++ +".html");
	TestBPM=report.startTest(NombreReporte);
	
	IExplorer();
	
	System.out.println(URLSecundaria);
  }
	



  @Test
  public void T01_AgregarDatosConctacto() throws Exception {
	NombreReporte= "T01 Agregar Datos de Conctacto";
	TestCaptura="T01_AgregarDatosContacto";
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
    
    //Notificaciones SI
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_RadioButton_2')]")).click();
    
    //Notificaciones NO
    //driver.findElement(By.xpath("//input[contains(@id,'dijit_form_RadioButton_3')]")).click();
    
    Thread.sleep(10000);
    driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div/div/div/div/div[1]/div/div/div/div[3]/div/div/div[4]/button")).click();
    
    Thread.sleep(20000);
    
	
  //Recargar la pagina
    
    WebElement boton = driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div/div/div/div/div[1]/div/div/div/div[3]/div/div/div[4]/button"));
    Assert.assertEquals(true, boton.isDisplayed());
    
    ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura.concat(Integer.toString(CaptureN++))) + ">"; 
    TestBPM.log(LogStatus.INFO, "Agregar Datos de Contacto Finalizo Correctamente", ScreenShot_Path);
  
    
	
  }
 
  
  @Test
  public void T02_AgregarOtroDatoConctacto() throws Exception {
	
	TestBPM.log(LogStatus.INFO, "Se completo el paso Cargar Listas del proceso");
	
	NombreReporte= "T02 Agregar Otro Dato de Conctacto";
	TestCaptura="T02_AgregarOtroDatoConctacto";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Agregar Otro Dato de Conctacto");
	
	
    
    //driver.switchTo().frame(2);
	
	// Tipo de Documento
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_9')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_9')]")).sendKeys("DNI");
    
	// Numero de Documento
	driver.findElement(By.xpath("//input[@id='dijit_form_ComboBox_3']")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_ComboBox_3']")).sendKeys("95625073");
    
	// Apellidos
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_4')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_4')]")).sendKeys("Diaz Lugo");
    
	// Nombres
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_5')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_5')]")).sendKeys("Miguel Angel");
	
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
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_7')]")).sendKeys("1168677093");
    
    //Telefono2
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_8')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_8')]")).sendKeys("1168677094");
    
    //Email1
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_9')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_9')]")).sendKeys("ingdiaz4@gmail.com");
    
    //Email2
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_10')]")).clear();
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_10')]")).sendKeys("ingdiaz4@hotmail.com");
    
    //Notificaciones NO
    //driver.findElement(By.xpath("//input[contains(@id,'dijit_form_RadioButton_2')]")).click();
    
    //Notificaciones SI
    driver.findElement(By.xpath("//input[contains(@id,'dijit_form_RadioButton_3')]")).click();
    
    Thread.sleep(10000);
    driver.findElement(By.xpath("//button[contains(.,'Agregar')]")).click();
    
    Thread.sleep(20000);
    
	
  //Assersion para verificar el boton editar
    WebElement boton = driver.findElement(By.xpath("//button[contains(.,'Editar')]"));
    Assert.assertEquals(true, boton.isDisplayed());
    
    ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura.concat(Integer.toString(CaptureN++))) + ">"; 
    TestBPM.log(LogStatus.INFO, "Agregar Datos de Contacto Finalizo Correctamente", ScreenShot_Path);
	
  }
  
  @Test
  public void T03_EditarDatosContacto() throws Exception {
	 NombreReporte= "T03 Editar Datos de Conctacto";
	 TestCaptura="T03_EditarDatosContacto";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Editar Datos de Conctacto");

	//Borrar Datos de Contacto
		BorrarDatosdeContacto();
        driver.findElement(By.xpath("//div[contains(@id,'dojox_grid_EnhancedGrid_0_rowSelector_0')]")).click();
        //driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div")).click();
    	Thread.sleep(5000);
	
    	//Seleccionar un elemento de la Grid
	
    chBox = driver.findElement(By.xpath("//div[contains(@id,'dojox_grid_EnhancedGrid_0_rowSelector_0')]")).getAttribute("aria-checked").equals("true");
	System.out.println(chBox);
	
		 if (chBox==true)
		 {
			 System.out.println("chBox: El elemento ya se encuentra seleccionado");
			 datosEditar();
	         
	     } else if (chBox==false)
	     
	     {
	    	 driver.findElement(By.xpath("//div[contains(@id,'dojox_grid_EnhancedGrid_0_rowSelector_0')]")).click();
	    	 Thread.sleep(20000);
	    	 datosEditar();
	     }
		
	    //WebElement boton = driver.findElement(By.xpath("//button[contains(.,'Editar')]"));
	   // Assert.assertEquals(true, boton.isDisplayed());

		ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura.concat(Integer.toString(CaptureN++))) + ">"; 
	    TestBPM.log(LogStatus.INFO, "Editar Datos de Contacto Finalizo Correctamente", ScreenShot_Path);
    }

  @Test
  public void T04_EliminarDatosContacto() throws Exception {
	NombreReporte= "T04 Eliminar Datos de Conctacto";
	TestCaptura="T04_EliminarDatosContacto";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Eliminar Datos de Conctacto");
	
	ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura.concat(Integer.toString(CaptureN++))) + ">"; 
    TestBPM.log(LogStatus.INFO, "Inicio de la Funcion Eliminar datos del Contacto", ScreenShot_Path);
	
	//Borrar los campos del formulario
    BorrarDatosdeContacto();
    driver.findElement(By.xpath("//div[contains(@id,'dojox_grid_EnhancedGrid_0_rowSelector_0')]")).click();
    //driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/div")).click();
	Thread.sleep(5000);
	
	 //Seleccionar un elemento de la Grid
	chBox1 = driver.findElement(By.xpath("//div[contains(@id,'dojox_grid_EnhancedGrid_0_rowSelector_0')]")).getAttribute("aria-checked").equals("true");
	System.out.println(chBox1);
	
		 if (chBox1==true)
		 {
			 System.out.println("chBox1: El elemento ya se encuentra seleccionado");
			//Eliminar el elemento
			 
			driver.findElement(By.xpath("//button[contains(.,'Eliminar')]")).click();
			Thread.sleep(20000);
	         
	     } else if (chBox1==false)
	     
	     {
	    	 driver.findElement(By.xpath("//div[contains(@id,'dojox_grid_EnhancedGrid_0_rowSelector_0')]")).click();
	    	 Thread.sleep(15000);
	    	 
	    	//Eliminar el elemento
			driver.findElement(By.xpath("//button[contains(.,'Eliminar')]")).click();
			Thread.sleep(20000);
	     }
		
		
		
	    //WebElement boton = driver.findElement(By.xpath("//button[contains(.,'Editar')]"));
	   // Assert.assertEquals(true, boton.isDisplayed());

    }

  @Test
  public void T05_ZAvanzarAdmitirExpediente() throws Exception {
	NombreReporte= "T05 Avanzar Admitir Expediente";
	TestCaptura="T05_AvanzarAdmitirExpediente";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Enviar Formulario de Admitir Expediente");
		
		driver.findElement(By.xpath("//button[contains(.,'Avanzar')]")).click();
		Thread.sleep(15000);
		
	    ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura.concat(Integer.toString(CaptureN++))) + ">"; 
	    TestBPM.log(LogStatus.INFO, "Avanzar Admitir Expediente, Finalizo Correctamente", ScreenShot_Path);
		


    }
 
 @Test
  public void T06_DatosCobertura() throws Exception {
	 GChrome();
	NombreReporte= "T06 Datos Cobertura";
	TestCaptura="T06_DatosCobertura";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Componente de Pantalla Datos Cobertura");
	
	//Acciones
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[6]/div/div[2]/div[2]/div[3]/input[1]")));
	
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[6]/div/div[2]/div[2]/div[3]/input[1]")).click();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[6]/div/div[2]/div[2]/div[3]/input[1]")).sendKeys("Aprobar");
	
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr/td[6]/div/div[2]/div[2]/div[3]/input[1]")).click();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr/td[6]/div/div[2]/div[2]/div[3]/input[1]")).sendKeys("Aprobar");
	
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[3]/table/tbody/tr/td[6]/div/div[2]/div[2]/div[3]/input[1]")).click();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[3]/table/tbody/tr/td[6]/div/div[2]/div[2]/div[3]/input[1]")).sendKeys("Aprobar");
	
	
	//Establecer Moneda
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[7]/div/div[2]/div[2]/div[3]/input[1]")).click();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[7]/div/div[2]/div[2]/div[3]/input[1]")).sendKeys("Dólares");
	
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr/td[7]/div/div[2]/div[2]/div[3]/input[1]")).click();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr/td[7]/div/div[2]/div[2]/div[3]/input[1]")).sendKeys("Soles");
	
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[3]/table/tbody/tr/td[7]/div/div[2]/div[2]/div[3]/input[1]")).click();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[3]/table/tbody/tr/td[7]/div/div[2]/div[2]/div[3]/input[1]")).sendKeys("Dólares");
	
	//Monto a Pagar
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[8]/div/div[2]/div[2]/div[3]/input")).clear();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[8]/div/div[2]/div[2]/div[3]/input")).sendKeys("1000");
	
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr/td[8]/div/div[2]/div[2]/div[3]/input")).clear();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr/td[8]/div/div[2]/div[2]/div[3]/input")).sendKeys("500");
	
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[3]/table/tbody/tr/td[8]/div/div[2]/div[2]/div[3]/input")).clear();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[1]/div/div[2]/div/div/div/div/div[3]/table/tbody/tr/td[8]/div/div[2]/div[2]/div[3]/input")).sendKeys("500");
	
	
	
	
	//valor del Cambio
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[4]/div/div/div/div[2]/div[2]/div[2]/input[1]")).clear();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[5]/div/div/div/div[4]/div/div/div/div[2]/div[2]/div[2]/input[1]")).sendKeys("10");
	
	
	
	
	tag1 = driver.findElement(By.xpath("//span[contains(@id,'div_3_1_1_1_5_1_1_3_1_2_span')]")).getText();
	System.out.println(tag1);
	Assert.assertEquals("1.500,00", tag1);
	
	
    }  

 @Test
 public void T07_DatosSiniestro() throws Exception {
	NombreReporte= "T07 Datos Del Siniestro";
	TestCaptura="T07_DatosSiniestro";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Componente de Pantalla Datos Del Siniestro");
	
	
	
	//Tipo Siniestro
	
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_10']")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_10']")).sendKeys("Fallecimiento Natural");
	
	//driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[8]/div/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div[3]/input[1]")).click();
	//driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[8]/div/div/div/div[1]/div/div/div[1]/div[2]/div[2]/div[3]/input[1]")).sendKeys("Fallecimiento Natural");
	
	//Tipo Pago de Siniestro
	
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_11']")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_11']")).sendKeys("Pago Ordinario");
	Thread.sleep(3000);
		
	//driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[8]/div/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div[3]/input[1]")).click();
	//driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[8]/div/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div[3]/input[1]")).sendKeys("Pago Ordinario");
	
	//Fecha Ocurrencia
	driver.findElement(By.xpath("//input[contains(@id,'uniqName_1_4')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'uniqName_1_4')]")).sendKeys("10/01/2017");
	Thread.sleep(3000);
		
	//driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[8]/div/div/div/div[2]/div/div/div/div[3]/span[1]/div/div[3]/input[1]")).click();
	//driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[8]/div/div/div/div[2]/div/div/div/div[3]/span[1]/div/div[3]/input[1]")).sendKeys("10/01/2017");
	
	//Lugar Descripción Genérica del Lugar
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[8]/div/div/div/div[3]/div/div/div/textarea")).clear();
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[8]/div/div/div/div[3]/div/div/div/textarea")).sendKeys("Plaza San Martin");
	Thread.sleep(3000);

   }  
   
 @Test
 public void T08_DatosBeneficiarios() throws Exception {
	NombreReporte= "T08 Datos Beneficiarios del Siniestro";
	TestCaptura="T08_BeneficiariosSiniestro";
	TestBPM=report.startTest(NombreReporte);
	TestBPM.log(LogStatus.INFO, "Componente de Pantalla Datos Beneficiarios del Siniestro");
	
	//Cód. Persona
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_13')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_13')]")).sendKeys("4424");
	
	//Nombre
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_14')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_14')]")).sendKeys("Maria José");
	
	//Apellido Paterno
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_15')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_15')]")).sendKeys("Ortíz");
	
	//Apellido Materno 
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_16')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_16')]")).sendKeys("Rodríguez");
	
	//Tipo Documento
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_12']")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_12']")).sendKeys("DNI");
	Thread.sleep(3000);
	
	//Numero de documento
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_17')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_17')]")).sendKeys("95624541");
	
	//Fecha de Nacimiento
	driver.findElement(By.xpath("//input[contains(@id,'uniqName_1_6')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'uniqName_1_6')]")).sendKeys("13/11/1994");
	Thread.sleep(3000);
	
	//Sexo
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_13']")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_13']")).sendKeys("Femenino");
	Thread.sleep(3000);
	
	//Parentesco
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_14')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_14')]")).sendKeys("Cónyuge");
	Thread.sleep(3000);
	
	//Monto a Pagar
	driver.findElement(By.xpath("//input[contains(@id,'uniqName_2_2')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'uniqName_2_2')]")).sendKeys("2400,00");
	
	//Nombre de Cobertura
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_15']")).clear();
	driver.findElement(By.xpath("//input[@id='dijit_form_FilteringSelect_15']")).sendKeys("Nombre de prueba 1");
	Thread.sleep(15000);
	
	//Boton Agregar
	driver.findElement(By.xpath("//div[1]/div[3]/div[1]/div/div[3]/div[1]/div/div/div/div[9]/div/div/div/div[3]/div/div/div[4]/button")).click();
	Thread.sleep(10000);
	
	//Tomar Screen
	ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura.concat(Integer.toString(CaptureN++))) + ">"; 
    TestBPM.log(LogStatus.INFO, "T08 Datos Beneficiarios del Siniestro", ScreenShot_Path);
    

   }  
   

public void datosEditar() throws Exception  

{
	//Clic en Boton Editar
	driver.findElement(By.xpath("//button[contains(.,'Editar')]")).click();
	Thread.sleep(15000);
	
	// Apellidos
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_4')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_4')]")).sendKeys("Diaz Lugo");
    
	// Nombres
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_5')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_5')]")).sendKeys("Mervin Alberto");
	
	//Direccion
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_6')]")).clear();
	driver.findElement(By.xpath("//input[contains(@id,'dijit_form_ComboBox_6')]")).sendKeys("Reconquista 617");

	//Guardar
	driver.findElement(By.xpath("//button[contains(.,'Guardar')]")).click();
	
	
	ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura.concat(Integer.toString(CaptureN++))) + ">"; 
    TestBPM.log(LogStatus.INFO, "Editar Datos de Contacto Finalizo Correctamente", ScreenShot_Path);
	Thread.sleep(20000);
	
}

public void BorrarDatosdeContacto(){
	
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
}
  

@AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result)
  {
	ScreenShot_Path= "<img src="+ CaptureScreenshot.ScreenShot(driver, TestCaptura.concat(Integer.toString(CaptureN++))) + ">"; 
	  
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  
		  TestBPM.log(LogStatus.FAIL, "Ha fallado la Prueba");
	  }else {
		 
		  TestBPM.log(LogStatus.PASS, "Se culmino la prueba Exitosamente");
		  
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

/*
Esperar que aparezca el elemento
WebDriverWait wait = new WebDriverWait(driver, 15);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(.,'El servicio ha finalizado.')]")));

WebElement msj = driver.findElement(By.xpath("//b[contains(.,'El servicio ha finalizado.')]"));
System.out.println(msj);
Assert.assertEquals("El servicio ha finalizado.", msj);

driver.findElement(By.xpath("//input[contains(@id,'dijit_form_FilteringSelect_29')]"));//Aprobar
    
div[@id='div_4_1_2_1_2']//button[.='Avanzar']


*/
