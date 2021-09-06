package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AccesoClientesLoginPage;
import pages.FormularioRetomaContratacionPage;
import pages.HomePage;
import pages.RetomaContratacionPage;
import utilidades.DataDriven;

public class Tests {
	//definir atributos
	private WebDriver driver;
	private HomePage homePage;
	private DataDriven data;
	private ArrayList<String> datosCP;
	
	
	private RetomaContratacionPage retomaContratacionPage;
	private FormularioRetomaContratacionPage formularioPage;
	private AccesoClientesLoginPage loginPage;
	
	@BeforeMethod
	public void prepararSitio() {
		homePage.maximizarBrowser();
		homePage.cargarSitio("https://publico.transbank.cl/");
	}
	
	@BeforeTest
	public void before() {
		
		String rutaDriver = Paths.get(System.getProperty("user.dir"), "\\src\\test\\resources\\drivers\\chromedriver.exe").toString();
		String navegador = "chrome";
		String propertyDriver = "webdriver.chrome.driver";
		
		homePage = new HomePage(driver);
		
		data = new DataDriven();
		
		homePage.conexionDriver(navegador, rutaDriver, propertyDriver);
		
		retomaContratacionPage = new RetomaContratacionPage(homePage.getDriver());
		
		formularioPage = new FormularioRetomaContratacionPage(retomaContratacionPage.getDriver());
		
		loginPage = new AccesoClientesLoginPage(homePage.getDriver());
	
	}
	
	
	@AfterTest
	public void after() {
		
	}
	
	@Test
	public void CP001_retomaFormularioContratacion_ctaBloqueada() throws IOException {
		datosCP = data.getData("CP001_retomaFormularioContratacion_ctaBloqueada");
		homePage.irAHazteCliente();
		retomaContratacionPage.irARetormarContratacion();
		formularioPage.completarFormularioPersonaNatural(datosCP.get(1),datosCP.get(2));
		Assert.assertEquals(formularioPage.obtenerMensajeBloqueoCta(), datosCP.get(3));
	}
	
	
	@Test
	public void CP002_errorLogin_usuarioInvalido() throws IOException {
		datosCP = data.getData("CP002_errorLogin_usuarioInvalido");
		homePage.irAAccesoClientes();
		loginPage.login(datosCP.get(1),datosCP.get(2));
		Assert.assertEquals(loginPage.obtenerMensajeErrorLogin(),datosCP.get(3));
	}

}
