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

    public WebElement getNomeDoProdutoText() {
        WebElement iframeElement = driver.findElement(By.cssSelector(".fancybox-iframe"));
        WebDriver iframeDriver = driver.switchTo().frame(iframeElement);
        return iframeDriver.findElement(By.cssSelector("#product > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1"));
    }
}