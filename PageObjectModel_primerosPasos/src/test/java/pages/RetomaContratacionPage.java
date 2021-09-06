package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class RetomaContratacionPage extends ClaseBase{

	public RetomaContratacionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By locatorBtnRetomarContratacion = By.xpath("//button[contains(text(),'contratación')]");
	
	
	public void irARetormarContratacion() {
		if(estaHabilitado(locatorBtnRetomarContratacion)) {
			click(locatorBtnRetomarContratacion);
		}
	}
	
	
}
