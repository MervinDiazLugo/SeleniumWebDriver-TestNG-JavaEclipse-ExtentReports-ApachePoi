package lib;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	
	public static String ScreenShot(WebDriver driver, String captureN)
	{
		try {
			TakesScreenshot ts= (TakesScreenshot)driver;
			
			File source= ts.getScreenshotAs(OutputType.FILE);
			
			String ruta= "/ScreenShots/"+captureN+".png";
			
			File destino= new File (ruta);
			
			FileUtils.copyFile(source, destino);
			
			System.out.println("Se tomo la Captura de pantalla");
			
			return ruta;
			
		} catch (Exception e) {
			System.out.println("Error Mientras se Tomaba la Captura de Pantalla"+e.getMessage());
		}
		return captureN;
		
	}

}
