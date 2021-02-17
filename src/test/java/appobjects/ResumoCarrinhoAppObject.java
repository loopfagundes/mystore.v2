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

    public WebElement getTotalProdutoText() {
        return driver.findElement(By.id("total_product"));
    }

    public WebElement getTotalEnvioText() {
        return driver.findElement(By.id("total_shipping"));
    }

    public WebElement getTodoTotalText() {
        return driver.findElement(By.id("total_price"));
    }

    public WebElement getFazerCheckoutButton() {
        return driver.findElement(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span"));
    }
}