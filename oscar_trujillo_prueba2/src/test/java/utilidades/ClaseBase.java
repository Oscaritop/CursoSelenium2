package utilidades;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClaseBase {
	//atributos
	protected WebDriver driver;
	protected WebDriverWait espera;
	
	//Métodos
	public ClaseBase(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	//Encapsular las acciones que realizamos con selenium
	
	
	public WebDriver getDriver() {
		return driver;
	}



	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}



	public WebElement buscarElementoWeb(By localizador) {
		return this.driver.findElement(localizador);
	}
	
	public List<WebElement> buscarElementosWeb(By localizador){
		return this.driver.findElements(localizador);
	}
	
	public String obtenerTexto(By localizador) {
		return this.driver.findElement(localizador).getText();
	}
	
	public String obtenerTexto(WebElement elemento) {
		return elemento.getText();
	}
	
	public void agregarTexto(By localizador, String mensaje) {
		this.driver.findElement(localizador).sendKeys(mensaje);
	}
	
	
	public void agregarTexto(WebElement elemento,String mensaje) {
		elemento.sendKeys(mensaje);
	}
	
	
	public void click(By localizador) {
		this.driver.findElement(localizador).click();
	}
	
	public void click(WebElement elemento) {
		elemento.click();
	}
	
	
	public void cargarSitio(String url) {
		this.driver.get(url);
	}
	
	public void maximizarBrowser() {
		this.driver.manage().window().maximize();
	}
	
	public void cerrarBrowser() {
		this.driver.close();
	}
	
	public WebDriver conexionDriver(String browser, String ruta, String propertyDriver) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty(propertyDriver,ruta);	
			this.driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(propertyDriver,ruta);	
			this.driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty(propertyDriver,ruta);	
			this.driver = new InternetExplorerDriver();
		}
		return driver;
				
	}
	
	
	public boolean estaDesplegado(By localizador) {
		try {
			return this.driver.findElement(localizador).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean estaSeleccionado(By localizador) {
		try {
			return this.driver.findElement(localizador).isSelected();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean estaHabilitado(By localizador) {
		try {
			return this.driver.findElement(localizador).isEnabled();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	//espera fija
	public void esperarXSegundos(int milisegundos) {
		
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//espera explicita
	public WebElement esperaExplicita(By localizador) {
		espera = new WebDriverWait(this.driver,30);
		
		return espera.until(ExpectedConditions.
				presenceOfElementLocated(localizador));
	}
	
	
}
