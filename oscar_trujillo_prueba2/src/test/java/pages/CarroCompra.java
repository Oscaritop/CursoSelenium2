package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class CarroCompra extends ClaseBase {

    public CarroCompra(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    //locators

    By loctatorBtnDespachoADomicilio = By.xpath("//p[contains(text(),'DESPACHO A DOMICILIO')]");

    By locatorBtnRetiroGratis = By.xpath("//span[contains(text(),'GRATIS')]");

    public void botonesCarro() {

        esperaExplicita(loctatorBtnDespachoADomicilio).click();
        esperaExplicita(locatorBtnRetiroGratis).click();

    }

    public void botonDespacho() {
        if (estaHabilitado(loctatorBtnDespachoADomicilio)) {
            click(loctatorBtnDespachoADomicilio);
        }
    }
}

