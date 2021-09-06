package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class FormularioRetomaContratacionPage extends ClaseBase {

	public FormularioRetomaContratacionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By locatorTxtRut = By.name("txtRut");

	By locatorTxtNroSerie = By.id("txtSerie");

	By locatorChkAutorizacion = By.xpath(
			"/html[1]/body[1]/app-root[1]/app-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-steppers[1]/mat-horizontal-stepper[1]/div[2]/div[1]/app-paso-uno[1]/div[2]/form[1]/div[2]/app-persona-natural[1]/form[1]/div[1]/div[2]/div[1]/mat-checkbox[1]/label[1]/div[1]");

	By locatorBtnContinuar = By.xpath("//div[contains(text(),'Continuar')]");
	
	
	By locatorLabelErrorCtaBloqueada = By.xpath("//mat-dialog-content[contains(text(),'Superaste el número de intentos y por seguridad bl')]");

	public void completarFormularioPersonaNatural(String rut, String serieCarnet) {
		agregarTexto(esperaExplicita(locatorTxtRut), rut);

		agregarTexto(esperaExplicita(locatorTxtNroSerie), serieCarnet);

		click(esperaExplicita(locatorChkAutorizacion));

		click(esperaExplicita(locatorBtnContinuar));
	}
	
	public String obtenerMensajeBloqueoCta() {
		esperarXSegundos(3000);
		return obtenerTexto(esperaExplicita(locatorLabelErrorCtaBloqueada));
	}
	

}
