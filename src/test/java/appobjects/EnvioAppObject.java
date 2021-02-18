package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnvioAppObject {
    private WebDriver driver;

    public EnvioAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValidadoTelaDeEnvioText() {
        return  driver.findElement(By.cssSelector("#carrier_area > h1"));
    }

    public WebElement getValidadoAbaDeEnvioText() {
        return driver.findElement(By.cssSelector("#order_step > li.step_current.four > span"));
    }

    public WebElement getValidadoValorDeEnvioText() {
        return driver.findElement(By.cssSelector("td.delivery_option_price > div"));
    }

    public WebElement getValidadoTermoDeServicoText() {
        return driver.findElement(By.cssSelector("#form > div > p.carrier_title"));
    }

    public WebElement getTermoDeServicoCheckBox() {
        return driver.findElement(By.id("uniform-cgv"));
    }

    public WebElement getFazerCheckoutButton() {
        return driver.findElement(By.cssSelector("#form > p > button > span"));
    }
}