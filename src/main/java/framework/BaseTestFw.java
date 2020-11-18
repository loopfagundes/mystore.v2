package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import support.FileOperations;

import java.io.File;

import static framework.DriverManagerFactoryFw.*;

public class BaseTestFw {
    private WebDriver driver;
    private static FileOperations fileOperations = new FileOperations();
    private String PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "urlProperties" + File.separator + "url.properties";
    private String prop = "urlIndex";

    public WebDriver getDriver() {
        this.driver = setDriver(DriverChooseFw.CHROME);
        return driver;
    }

    @BeforeClass
    public void setUp() {
        ReportFw.setUpConfigure("Automation Pratice - My Store v.2", "Teste de automacao");
        getDriver().get(fileOperations.readProperties(PATH, prop));
    }

    @AfterClass
    public void tearDown() {
        ReportFw.tearDownFinish();
        quitDriver();
    }
}