package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

    public WebElement getValidadoNomeProdutoText() {
        WebElement iframeElement = driver.findElement(By.cssSelector(".fancybox-iframe"));
        WebDriver iframeDriver = driver.switchTo().frame(iframeElement);
        return iframeDriver.findElement(By.cssSelector("#product > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1"));
    }

    public WebElement getQuantidadeProdutoText() {
        driver.switchTo().defaultContent();
        WebElement iframeElement = driver.findElement(By.cssSelector(".fancybox-iframe"));
        WebDriver iframeDriver = driver.switchTo().frame(iframeElement);
        return iframeDriver.findElement(By.id("quantity_wanted"));
    }

    public Select getTamanhoProdutoComboBox() {
        driver.switchTo().defaultContent();
        WebElement iframeElement = driver.findElement(By.cssSelector(".fancybox-iframe"));
        WebDriver iframeDriver = driver.switchTo().frame(iframeElement);
        return new Select(iframeDriver.findElement(By.id("group_1")));
    }

    public WebElement getCorProdutoButton() {
        driver.switchTo().defaultContent();
        WebElement iframeElement = driver.findElement(By.cssSelector(".fancybox-iframe"));
        WebDriver iframeDriver = driver.switchTo().frame(iframeElement);
        return iframeDriver.findElement(By.id("color_11"));
    }

    public WebElement getAdicionaCarrinhoButton() {
        driver.switchTo().defaultContent();
        WebElement iframeElement = driver.findElement(By.cssSelector(".fancybox-iframe"));
        WebDriver iframeDriver = driver.switchTo().frame(iframeElement);
        return iframeDriver.findElement(By.cssSelector("#add_to_cart > button"));
    }

    public WebElement getFazerCheckoutButton() {
        driver.switchTo().defaultContent();
        return driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span"));
    }
}