package tests;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploSelenium_clase3 {

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

		String url = "https://www.google.cl";

		// la función get del webdriver levanta el browser
		driver.get(url);

		System.out.println("Titulo del site:" + driver.getTitle());

		System.out.println("Url del site: " + driver.getCurrentUrl());

		System.out.println("---------------------------------------");

		// System.out.println("recurso del site:"+ driver.getPageSource());
		System.out.println("---------------------------------------");

		driver.navigate().to("https://www.bci.cl");

		// espera de 3 segundos
		Thread.sleep(3000);

		driver.navigate().back();

		// espera de 3 segundos
		Thread.sleep(3000);
		
		driver.navigate().refresh();

		// espera de 10 segundos
		Thread.sleep(10000);

		// cerrar el browser
		driver.close();

	}

}
