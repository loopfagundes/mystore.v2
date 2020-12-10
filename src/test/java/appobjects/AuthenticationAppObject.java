package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationAppObject {

    private WebDriver driver;

    public AuthenticationAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValidadoPaginaAuthenticationText() {
        return driver.findElement(By.cssSelector("#center_column > .page-heading"));
    }

    public WebElement getCriarContaTextField() {
        return driver.findElement(By.id("email_create"));
    }
}