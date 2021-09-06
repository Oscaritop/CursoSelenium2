package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class FormularioRegistro extends ClaseBase {

    public FormularioRegistro(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    //locator

    By locatorLblIngresadatos = By.xpath("//h2[contains(text(),'Ingresa tus Datos')]");



    public String labelFormularioIngresaDatos() {
        esperarXSegundos(3000);
        return obtenerTexto(esperaExplicita(locatorLblIngresadatos));

    }



}