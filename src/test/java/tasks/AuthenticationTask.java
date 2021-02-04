package tasks;

import appobjects.AuthenticationAppObject;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AuthenticationTask {

    private WebDriver driver;
    private AuthenticationAppObject authenticationAppObject;
    private Faker faker = new Faker();

    public AuthenticationTask(WebDriver driver) {
        this.driver = driver;
        this.authenticationAppObject = new AuthenticationAppObject(driver);
    }

    public void paginaAuthentication() {
        validadoPaginaAuthentication();
        criarConta();
    }

    private void validadoPaginaAuthentication() {
        Assert.assertEquals(authenticationAppObject.getValidadoPaginaAuthenticationText().getText(), "AUTHENTICATION");
        if (authenticationAppObject.getValidadoPaginaAuthenticationText().getText().equals("AUTHENTICATION")) {
            ReportFw.log(Status.PASS, "A validacao da pagina de Authentication esta correta.");
        } else {
            ReportFw.log(Status.FAIL, "A validacao da pagina de Authentication nao esta correta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void criarConta() {
        ReportFw.log(Status.INFO, "Digite no campo de email para criar uma conta.");
        authenticationAppObject.getCriarContaTextField().sendKeys(faker.internet().emailAddress());
        authenticationAppObject.getCriarContaButton().click();
    }
}