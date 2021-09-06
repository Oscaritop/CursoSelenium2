package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class AccesoClientesLoginPage extends ClaseBase {

	public AccesoClientesLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//locator imput rut
	By locatorTxtRut = By.id("UsuarioRut");
	
	By locatorTxtPassword = By.name("PasswordClient");
	
	By locatorBtnIniciarSesion = By.xpath("//button[contains(text(),'Iniciar sesión')]");
	
	By locatorLblErrorLogin = By.xpath("//p[contains(text(),'Algunos de los datos')]");
	
	
	public void login(String rut,String pass) {
		esperaExplicita(locatorTxtRut).sendKeys(rut);
		esperaExplicita(locatorTxtPassword).sendKeys(pass);
		esperaExplicita(locatorBtnIniciarSesion).click();
	}

	public String obtenerMensajeErrorLogin() {
		esperarXSegundos(3000);
		return obtenerTexto(esperaExplicita(locatorLblErrorLogin));
	}
}
