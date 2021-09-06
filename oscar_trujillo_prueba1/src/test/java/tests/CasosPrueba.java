package tests;

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

public class CasosPrueba {
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

		wait = new WebDriverWait(driver, 10);

		url = "https://www.pcfactory.cl/";

	}

	// Métodos

	@Test

	public void CP001_Login_Contrasena_Incorrecta() throws InterruptedException {
		driver.get(url);

		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='rightcolumn-header']/div/div[2]/a/p")).click();
		Thread.sleep(3000);


		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).clear();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).sendKeys("15634964-k");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).clear();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).sendKeys("123");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='btn_login']/p")).click();
		Thread.sleep(3000);

		WebElement descripcionError = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//p[@id='id_nota_forgot_password'][contains(text(),'Contraseña incorrecta')]")));


		Assert.assertEquals(descripcionError.getText(),
				"Contraseña incorrecta");
	}

	@Test

	public void CP002_login_Rut_Incorrecto() throws InterruptedException {
		driver.get(url);

		driver.findElement(By.xpath("//div[@id='rightcolumn-header']/div/div[2]/a/p")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).clear();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).sendKeys("12334445");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).clear();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).sendKeys("1234");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='btn_login']/p")).click();
		Thread.sleep(3000);

		WebElement descripcionError = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//p[@id='id_nota_forgot_password'][contains(text(),'Rut Inválido')]")));


		Assert.assertEquals(descripcionError.getText(),
				"Rut Inválido");

	}

	@Test

	public void CP003_Ingreso_Invitado() throws InterruptedException {
		driver.get(url);

		driver.findElement(By.xpath("//div[@id='rightcolumn-header']/div/div[2]/a/p")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='btn_invitado']/p")).click();
		Thread.sleep(3000);

		driver.findElement(By.name("rb_tipo_despacho")).click();
		Thread.sleep(3000);

		WebElement opcionDespacho = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//p[contains(text(),'DESPACHO A DOMICILIO')]")));

		Assert.assertEquals(opcionDespacho.getText(),
				"DESPACHO A DOMICILIO");

	}

	@Test

	public void CP004_Recuperar_Clave() throws InterruptedException {
		driver.get(url);

		driver.findElement(By.xpath("//div[@id='rightcolumn-header']/div/div[2]/a/p")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Recuperar Clave")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("id_rut_olvido")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("id_rut_olvido")).clear();
		Thread.sleep(3000);

		driver.findElement(By.id("id_rut_olvido")).sendKeys("15634964-k");
		Thread.sleep(3000);

		driver.findElement(By.id("id_btn_continuar")).click();
		Thread.sleep(3000);

		WebElement mensajeCorreo = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//p[contains(text(),'En unos minutos llegará al e-mail registrado:')]")));

		Assert.assertEquals(mensajeCorreo.getText(),
				"En unos minutos llegará al e-mail registrado:");

	}

	@Test

	public void CP005_Login_Correcto() throws InterruptedException {
		driver.get(url);

		driver.findElement(By.xpath("//div[@id='rightcolumn-header']/div/div[2]/a/p")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).clear();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='columna2FORMNO']/input")).sendKeys("15.634.964-k");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).clear();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[2]/div[2]/input")).sendKeys("hellyeah");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='btn_login']/p")).click();
		Thread.sleep(3000);

		WebElement textoMiCuenta = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//p[contains(text(),'Mi Cuenta')]")));

		Assert.assertEquals(textoMiCuenta .getText(),
				"Mi Cuenta");

		}
	}





	
	
	


