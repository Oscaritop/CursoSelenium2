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

import pages.*;
import utilidades.DataDriven;

public class Tests {
	//definir atributos
	private WebDriver driver;
	private HomePage homePage;
	private DataDriven data;
	private ArrayList<String> datosCP;

	private AccesoClientesLoginPage loginPage;
	private CarroCompra carroCom;
	private RecuperarClave recuperarPsw;
	private FormularioRegistro registroCliente;


	@BeforeMethod
	public void prepararSitio() {
		homePage.maximizarBrowser();
		homePage.cargarSitio("https://www.pcfactory.cl//");
	}

	@BeforeTest
	public void before() {

		String rutaDriver = Paths.get(System.getProperty("user.dir"), "\\src\\test\\resources\\drivers\\chromedriver.exe").toString();
		String navegador = "chrome";
		String propertyDriver = "webdriver.chrome.driver";

		homePage = new HomePage(driver);

		data = new DataDriven();

		homePage.conexionDriver(navegador, rutaDriver, propertyDriver);

		loginPage = new AccesoClientesLoginPage(homePage.getDriver());

		carroCom = new CarroCompra(loginPage.getDriver());

		recuperarPsw = new RecuperarClave(loginPage.getDriver());

		registroCliente = new FormularioRegistro(loginPage.getDriver());

	}

	@AfterTest
	public void after() throws InterruptedException {

		homePage.cerrarBrowser();


	}
	@Test
	public void CP001_Login_Contrasena_Incorrecta() throws IOException {
		datosCP = data.getData("CP001_Login_Contrasena_Incorrecta");
		homePage.irAlogin();
		loginPage.login(datosCP.get(1), datosCP.get(2));
		Assert.assertEquals(loginPage.obtenerMensajeErrorLogin(), datosCP.get(3));
	}

	@Test
	public void CP002_login_Rut_Incorrecto() throws IOException {
		datosCP = data.getData("CP002_login_Rut_Incorrecto");
		homePage.irAlogin();
		loginPage.login(datosCP.get(1), datosCP.get(2));
		Assert.assertEquals(loginPage.obtenerMensajeErrorLogin(), datosCP.get(3));
	}

	@Test
	public void CP003_Ingreso_Invitado() throws IOException {
		homePage.irAlogin();
		loginPage.accesoInvitado();
		carroCom.botonDespacho();

	}

	@Test
	public void CP004_Recuperar_Clave() throws IOException, InterruptedException {
		datosCP = data.getData("CP004_Recuperar_Clave");
		homePage.irAlogin();
		loginPage.recuperarclave();
		recuperarPsw.recuperarClave(datosCP.get(1));
		Assert.assertEquals(recuperarPsw.mensajeMail(), datosCP.get(2));

	}

	@Test
	public void CP005_Formulario_Registro_Cliente() throws IOException {
		datosCP = data.getData("CP005_Formulario_Registro_Cliente");
		homePage.irAlogin();
		loginPage.botonRegistrateaqui();
		Assert.assertEquals(registroCliente.labelFormularioIngresaDatos(), datosCP.get(1));
	}


	@Test
	public void CP006_Recuperar_Clave_Rut_Invalido() throws IOException, InterruptedException {
		datosCP = data.getData("CP006_Recuperar_Clave_Rut_Invalido");
		homePage.irAlogin();
		loginPage.recuperarclave();
		recuperarPsw.recuperarClave(datosCP.get(1));
		Assert.assertEquals(recuperarPsw.mensajeRutinvalido(), datosCP.get(2));
	}

	@Test
	public void CP007_Recuperar_Clave_Rut_No_Registrado() throws IOException, InterruptedException {
		datosCP = data.getData("CP007_Recuperar_Clave_Rut_No_Registrado");
		homePage.irAlogin();
		loginPage.recuperarclave();
		recuperarPsw.recuperarClave(datosCP.get(1));
		Assert.assertEquals(recuperarPsw.mensajeRutnoRegistrado(), datosCP.get(2));


	}

	@Test
	public void CP008_Login_Correcto() throws IOException {
		datosCP = data.getData("CP008_Login_Correcto");
		homePage.irAlogin();
		loginPage.login(datosCP.get(1), datosCP.get(2));
		Assert.assertEquals(homePage.mensajeMiCuenta(), datosCP.get(3));
		homePage.irAlogin();
		homePage.cerrarSesion();

	}
}