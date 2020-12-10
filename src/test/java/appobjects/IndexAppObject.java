package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexAppObject {

    private WebDriver driver;

    public IndexAppObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.cssSelector("div.header_user_info > a"));
    }
}