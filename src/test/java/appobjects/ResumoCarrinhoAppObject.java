package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResumoCarrinhoAppObject {
    private WebDriver driver;

    public ResumoCarrinhoAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValidadoTelaResumoCarrinhoText() {
        return driver.findElement(By.id("cart_title"));
    }

    public WebElement getValidadoAbaResumoText() {
        return driver.findElement(By.cssSelector("#order_step > li.step_current.first > span"));
    }
}