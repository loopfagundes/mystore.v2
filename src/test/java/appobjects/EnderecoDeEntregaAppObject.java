package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EnderecoDeEntregaAppObject {
    private WebDriver driver;

    public EnderecoDeEntregaAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValidadoTelaDeEnderecoText() {
        return driver.findElement(By.className("page-heading"));
    }

    public WebElement getValidadoAbaDeEnderecoText() {
        return driver.findElement(By.cssSelector("#order_step > li.step_current.third > span"));
    }

    public WebElement getValidadoTituloEnderecoDeEntregaText() {
        return driver.findElement(By.cssSelector("#address_delivery > li.address_title > h3"));
    }

    public WebElement getValidadoNomeDoUsuarioText() {
        return driver.findElement(By.cssSelector("#address_delivery > li.address_firstname.address_lastname"));
    }

    public WebElement getValidadoEnderecoText() {
        return driver.findElement(By.cssSelector("#address_delivery > li.address_address1.address_address2"));
    }

    public WebElement getValidadoCidadeEstadoCepText() {
        return driver.findElement(By.cssSelector("#address_delivery > li.address_city.address_state_name.address_postcode"));
    }

    public WebElement getValidadoPaisText() {
        return driver.findElement(By.cssSelector("#address_delivery > li.address_country_name"));
    }

    public WebElement getValidadoNumeroDeTelefoneText() {
        return driver.findElement(By.cssSelector("#address_delivery > li.address_phone"));
    }

    public WebElement getObeservaDeEntregaTextField() {
        return driver.findElement(By.cssSelector("#ordermsg > .form-control"));
    }

    public WebElement getFazerCheckoutButton() {
        return driver.findElement(By.cssSelector("#center_column > form > p > button > span"));
    }
}