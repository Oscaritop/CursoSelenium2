package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class HomePage extends ClaseBase {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Centralizar los localizadores de la pagina
	By locatorBtnMiCuenta = By.linkText("Mi Cuenta");
	By locatorBtnCerrarsesion = By.linkText("Cerrar sesión");


	public void irAlogin() {
		if (estaHabilitado(locatorBtnMiCuenta)) {
			click(locatorBtnMiCuenta);
		}
	}

	public String mensajeMiCuenta() {
		esperarXSegundos(3000);
		return obtenerTexto(esperaExplicita(locatorBtnMiCuenta));

	}

	public void cerrarSesion () {
		if (estaHabilitado(locatorBtnCerrarsesion)) {
			click(locatorBtnCerrarsesion);
		}


	}

}

