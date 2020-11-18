package framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsExecutorFw {
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver ;
        jse.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", element);
    }
}