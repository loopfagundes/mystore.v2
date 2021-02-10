package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastraUsuarioAppObject {

    private WebDriver driver;

    public CadastraUsuarioAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValidadoTelaDeCriarContaText() {
        return driver.findElement(By.cssSelector("#noSlide > h1"));
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

    public Select getDiaComboBox() {
        return new Select(driver.findElement(By.id("days")));
    }

    public Select getMesComboBox() {
        return new Select(driver.findElement(By.id("months")));
    }

    public Select getAnoComboBox() {
        return new Select(driver.findElement(By.id("years")));
    }

    public WebElement getAssinaNossoSiteCheckBox() {
        return driver.findElement(By.id("newsletter"));
    }

    public WebElement getRecebeOfertasSiteCheckBox() {
        return driver.findElement(By.id("optin"));
    }

    public WebElement getEnderecoTextField() {
        return driver.findElement(By.id("address1"));
    }

    public WebElement getCidadeTextField() {
        return driver.findElement(By.id("city"));
    }

    public Select getEstadoComboBox() {
        return new Select(driver.findElement(By.id("id_state")));
    }

    public WebElement getCepTextField() {
        return driver.findElement(By.id("postcode"));
    }

    public WebElement getAddInformacaoTextField() {
        return driver.findElement(By.id("other"));
    }

    public WebElement getNumeroTelefoneTextField() {
        return driver.findElement(By.id("phone"));
    }

    public WebElement getRegistroButton() {
        return driver.findElement(By.id("submitAccount"));
    }
}