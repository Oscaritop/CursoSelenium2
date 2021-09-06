package clase5;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EjemploSelenium_clase5 {
	// Atributos o variables de clase
	private WebDriver driver;
	private String url;
	private WebDriverWait wait;

	@AfterTest
	public void finPrueba() {
		driver.close();
	}

	@BeforeTest
	public void preparacionPruebas() throws InterruptedException {
		// enrutar el chromedriver.exe a una propiedad de windows llamada
		// webdriver.chrome.driver
		String rutaChromeDriver = Paths
				.get(System.getProperty("user.dir"), "\\src\\test\\resources\\webdriver\\chromedriver.exe").toString();
		// setear la property para usar el webdriver
		System.setProperty("webdriver.chrome.driver", rutaChromeDriver);

		// instancia del webdriver
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver,10);

		url = "https://publico.transbank.cl/";
	}

	// Métodos

	@Test
	public void CP001_ProcesoRetomaContratacion_usuarioBloqueado(){
		driver.get(url);
		
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		
		By locatorHazteCliente = By.linkText("Hazte cliente");

		driver.findElement(locatorHazteCliente).click();

		//Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'contratación')]")).click();

		//Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//body/app-root[1]/app-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-steppers[1]/mat-horizontal-stepper[1]/div[2]/div[1]/app-paso-uno[1]/div[2]/form[1]/div[2]/app-persona-natural[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("17603169-7");

		//Thread.sleep(3000);

		driver.findElement(By.id("txtSerie")).sendKeys("111222333");

		//Thread.sleep(3000);

		if (driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-steppers[1]/mat-horizontal-stepper[1]/div[2]/div[1]/app-paso-uno[1]/div[2]/form[1]/div[2]/app-persona-natural[1]/form[1]/div[1]/div[2]/div[1]/mat-checkbox[1]/label[1]/div[1]"))
				.isDisplayed()) {

			driver.findElement(By.xpath(
					"/html[1]/body[1]/app-root[1]/app-layout[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-steppers[1]/mat-horizontal-stepper[1]/div[2]/div[1]/app-paso-uno[1]/div[2]/form[1]/div[2]/app-persona-natural[1]/form[1]/div[1]/div[2]/div[1]/mat-checkbox[1]/label[1]/div[1]"))
					.click();
		}

		//Thread.sleep(3000);

		if (driver.findElement(By.xpath("//div[contains(text(),'Continuar')]")).isDisplayed()) {

			driver.findElement(By.xpath("//div[contains(text(),'Continuar')]")).click();
		}

		/*
		Thread.sleep(3000);

		String descripcionMensajeError = driver
				.findElement(By.xpath(
						"//mat-dialog-content[contains(text(),'Superaste el número de intentos y por seguridad bl')]"))
				.getText();
				*/
		
		
		WebElement descripcionError = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(
						"//mat-dialog-content[contains(text(),'Superaste el número de intentos y por seguridad bl')]")));
		

		Assert.assertEquals(descripcionError.getText(),
				"Superaste el número de intentos y por seguridad bloqueamos tu cuenta. Espera 24 hrs e inténtalo nuevamente.");

	}

	@Test
	public void CP002_Algo() throws InterruptedException {
		driver.get(url);
		// maximizar la pagina
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// localizador link hazte cliente
		By locatorHazteCliente = By.linkText("Hazte cliente");
		// acción sobre el elemento web
		driver.findElement(locatorHazteCliente).click();
	}

	@Test
	public void CP003_Algo() throws InterruptedException {
		driver.get(url);
		// maximizar la pagina
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// localizador link hazte cliente
		By locatorHazteCliente = By.linkText("Hazte cliente");
		// acción sobre el elemento web
		driver.findElement(locatorHazteCliente).click();
	}

	@Test
	public void CP004_Algo() throws InterruptedException {
		driver.get(url);
		// maximizar la pagina
		driver.manage().window().maximize();
		Thread.sleep(3000);
		// localizador link hazte cliente
		By locatorHazteCliente = By.linkText("Hazte cliente");
		// acción sobre el elemento web
		driver.findElement(locatorHazteCliente).click();

	}

	@Test
	public void CP005_Algo() {

	}

}
