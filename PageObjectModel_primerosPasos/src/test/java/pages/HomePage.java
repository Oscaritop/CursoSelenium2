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
	By locatorBtnHazteCliente = By.linkText("Hazte cliente");
	
	//locator btnAccesoCLientes
	By locatorBtnAccesoClientes = By.linkText("Acceso clientes");
	
	public void irAHazteCliente() {
		if(estaHabilitado(locatorBtnHazteCliente)) {
			click(locatorBtnHazteCliente);
		}
	}
	
	public void irAAccesoClientes() {
		if(estaHabilitado(locatorBtnAccesoClientes)) {
			click(locatorBtnAccesoClientes);
		}
	}

}
