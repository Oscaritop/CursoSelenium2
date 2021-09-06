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
	By locatorTxtRut = By.xpath("//body/div[@id='maincontainer']/div[@id='container']/div[@id='contenidos']/div[@id='center']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]");

	By locatorTxtPassword = By.xpath("//div[2]/div[2]/input");

	By locatorBtnIniciarSesion = By.xpath("//p[contains(text(),'Iniciar Sesión')]");

	By locatorLblErrorLogin = By.xpath("//p[@id='id_nota_forgot_password']");

	By locatorBtnInvitado = By.xpath("//p[contains(text(),'Continuar como invitado')]");

	By locatorLinkRecuperarClave = By.xpath("//a[contains(text(),'Recuperar Clave')]");

	By locatorBtnRegistrateAqui = By.xpath("//p[contains(text(),'Registrate Aqui')]");


	public void login(String rut, String pass) {
		esperaExplicita(locatorTxtRut).sendKeys(rut);
		esperaExplicita(locatorTxtPassword).sendKeys(pass);
		esperaExplicita(locatorBtnIniciarSesion).click();
	}


	public String obtenerMensajeErrorLogin() {
		esperarXSegundos(3000);
		return obtenerTexto(esperaExplicita(locatorLblErrorLogin));
	}

	public void accesoInvitado() {
		if (estaHabilitado(locatorBtnInvitado)) {
			click(locatorBtnInvitado);
		}
	}

	public void recuperarclave() {
		if (estaHabilitado(locatorLinkRecuperarClave)) {
			click(locatorLinkRecuperarClave);
		}

	}

	public void botonRegistrateaqui() {
		if (estaHabilitado(locatorBtnRegistrateAqui)) {
			click(locatorBtnRegistrateAqui);
		}

	}
}