package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoAppObject {
    private WebDriver driver;

    public ProdutoAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getValidadoTelaDosProdutosText() {
        return driver.findElement(By.className("cat-name"));
    }

    public WebElement getEscolheVestidoButton() {
        return driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(5) > div > div.left-block > div > a.product_img_link > img"));
    }
}