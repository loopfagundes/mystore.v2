package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CadastraUsuarioAppObject {

    private WebDriver driver;

    public CadastraUsuarioAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getGeneroCheckBox() {
        return driver.findElement(By.id("id_gender1"));
    }

    public WebElement getPrimeiroNomeTextField() {
        return driver.findElement(By.id("customer_firstname"));
    }

    public WebElement getSobrenomeTextField() {
        return driver.findElement(By.id("customer_lastname"));
    }

    public WebElement getSenhaTextField() {
        return driver.findElement(By.id("passwd"));
    }
}