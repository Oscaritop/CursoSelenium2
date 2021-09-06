package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class RecuperarClave extends ClaseBase {

    public RecuperarClave(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    //Locators

    By locatorTxtRut = By.xpath("//input[@id='id_rut_olvido']");

    By locatorBtnContiunar = By.id("id_btn_continuar");

    By LocatorLblMensajeMail = By.xpath("//p[@id='id_correo_respuesta']");

    By LocatorLblErrorRutNoRegisrado = By.xpath("//span[@id='id_msg_error']");

    By LocatorlblErrorRutInvalido = By.xpath("//span[@id='id_msg_error']");


    public void recuperarClave (String rut) throws InterruptedException {

        esperaExplicita(locatorTxtRut).sendKeys(rut);
        Thread.sleep(3000);
        esperaExplicita(locatorBtnContiunar).click();

    }

   public String mensajeMail() {
       esperarXSegundos(5000);
       return obtenerTexto(esperaExplicita(LocatorLblMensajeMail));

    }

    public String mensajeRutinvalido() {
        esperarXSegundos(3000);
        return obtenerTexto(esperaExplicita(LocatorlblErrorRutInvalido));
    }

    public String mensajeRutnoRegistrado() {
        esperarXSegundos(3000);
        return obtenerTexto(esperaExplicita(LocatorLblErrorRutNoRegisrado));
    }


}