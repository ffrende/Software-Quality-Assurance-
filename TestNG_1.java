package com.TestNG_1.ar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_1 {
    WebDriver driver;
@Test
public void test_login() throws InterruptedException {
    ///////////// Usuario
    WebElement txt_usuario = driver.findElement(By.id("tuusuario"));
    txt_usuario.sendKeys("Mi_Usuario");
    ///////////// Clave
    WebElement txt_clave = driver.findElement(By.id("tuclave"));
    txt_clave.sendKeys("Clave_Secreta");
    ///////////// Email
    WebElement txt_mail = driver.findElement(By.id("tumail"));
    txt_mail.sendKeys("daniel@hotmail.com");
    ///////////// Boton Ingresar
    WebElement btn_ingresar = driver.findElement(By.cssSelector("body > form > button:nth-child(8)"));
    // Espera 4 seg.
    Thread.sleep(4000);
    btn_ingresar.click(); // hago el click
    // Espera 4 seg. Carga la nueva página
    Thread.sleep(2000);
    WebElement title_acceso = driver.findElement(By.cssSelector("body > h3"));
    System.out.println(title_acceso.getText());  // mostrar el texto del titulo en la consola
    //JOptionPane.showMessageDialog(null,title_acceso.getText()); // Popup Gráfico, del mensaje de la consola del renglón anterior. Detiene el Test.
    ////////////////////// comparación de lo devuelto --> Aserción de la respuesta
    WebElement link_volver = driver.findElement(By.id("volver"));
    // Si el titulo title_acceso contiene el mensaje Acceso correcto, quiere decir que ingresé en la pantalla correcta
    link_volver.click();

    }

    @BeforeTest
    public void antesTest() {
        //Abrir el navegador
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.institutoweb.com.ar/test/login.html");
    }

    @AfterTest
    public void despuesTest() {
        driver.close();
    }

}
