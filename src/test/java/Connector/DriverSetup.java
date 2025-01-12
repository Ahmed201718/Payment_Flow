package Connector;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.payment.Utilities.PropertiesHandler;


public class DriverSetup {

    public static WebDriver driver;
    public JavascriptExecutor jsDriver;

    PropertiesHandler propertiesHandler = new PropertiesHandler();

    @Before
    public void driverSetup() {
        switch (propertiesHandler.getBrowser()) {
            case ("Chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case ("Edge"):
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        jsDriver = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get(propertiesHandler.getUrl());
    }


    @After
    public void afterTest() {
        driver.quit();
    }

}
