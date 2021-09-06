package tests;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploSelenium_clase4 {

	public static void main(String[] args) throws InterruptedException {
		// enrutar el chromedriver.exe a una propiedad de windows llamada
		// webdriver.chrome.driver
		String rutaChromeDriver = Paths
				.get(System.getProperty("user.dir"), "\\src\\test\\resources\\webdriver\\chromedriver.exe").toString();

		// System.out.println(rutaChromeDriver);

		// setear la property para usar el webdriver
		System.setProperty("webdriver.chrome.driver", rutaChromeDriver);

		// instancia del webdriver
		WebDriver driver = new ChromeDriver();

		String url = "https://publico.transbank.cl/";
		
		
		driver.get(url);
		
		//maximizar la pagina
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		//click al boton "Hazte cliente"
		
		//localizador link hazte cliente
		By locatorHazteCliente = By.linkText("Hazte cliente");
		
		//acción sobre el elemento web
		driver.findElement(locatorHazteCliente).click();
		
		Thread.sleep(3000);
		
		//localizador y acción sobre el elemento web usando xpath Rel
		//click boton retomar contratación
		driver.findElement(By.xpath("//button[contains(text(),'contratación')]")).click();
		
		Thread.sleep(3000);
		
		//enviar texto al campo mail usando xpath Abs
		driver.findElement
		(By.xpath
				("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/section[1]/form[1]/div[2]/div[1]/input[1]"))
					.sendKeys("domingo.saavedra@tsoftglobal.com");
		
		Thread.sleep(3000);
		
		//enviar texto al campo reingreso mail usando selector css
		driver.findElement(By.cssSelector("#mail2")).sendKeys("domingosaavedra@tsoftglobal.com");
		
		
		//mostrar por la consola texto "persona juridica".
		String textoPersonaJuridica = driver.findElement(By.xpath("//body/div[1]/div[1]/main[1]/div[1]/section[1]/footer[1]/p[1]")).getText();
		System.out.println(textoPersonaJuridica);
		
		
		boolean estado = driver.findElement(By.xpath("//button[@id='ingresar']")).isEnabled();
		System.out.println("Boton ingresar habilitado: "+ estado);
		
		
		//click boton volver.
		driver.navigate().back();
		
		
		
		
		
		Thread.sleep(3000);

		
		
		// cerrar el browser
		//driver.close();

	}

}
