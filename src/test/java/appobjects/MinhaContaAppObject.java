package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MinhaContaAppObject {
    private WebDriver driver;

    public MinhaContaAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValidadoTelaDaMinhaContaText() {
        return driver.findElement(By.className("page-heading"));
    }

    public WebElement getSelecionaWomenButton() {
        return driver.findElement(By.className("sf-with-ul"));
    }
}