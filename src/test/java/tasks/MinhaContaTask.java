package tasks;

import appobjects.MinhaContaAppObject;
import com.aventstack.extentreports.Status;
import framework.JsExecutorFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MinhaContaTask {
    private WebDriver driver;
    private MinhaContaAppObject myAccountAppObject;

    public MinhaContaTask(WebDriver driver) {
        this.driver = driver;
        this.myAccountAppObject = new MinhaContaAppObject(driver);
    }

    public void telaDaMinhaConta() {
        ReportFw.log(Status.INFO, "A pagina de minha conta.");
        validadoTelaDaMinhaConta();
        acessaWomen();
    }

    private void validadoTelaDaMinhaConta() {
        Assert.assertEquals("MY ACCOUNT", myAccountAppObject.getValidadoTelaDaMinhaContaText().getText());
        if (myAccountAppObject.getValidadoTelaDaMinhaContaText().getText().equals("MY ACCOUNT")) {
            ReportFw.log(Status.PASS, "A tela da minha conta esta correta.");
        } else {
            JsExecutorFw.highlight(driver, myAccountAppObject.getValidadoTelaDaMinhaContaText());
            ReportFw.log(Status.FAIL, "A tela da minha conta esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void acessaWomen() {
        if (myAccountAppObject.getSelecionaWomenButton().isDisplayed()) {
            myAccountAppObject.getSelecionaWomenButton().click();
            ReportFw.log(Status.PASS, "A botao de Mulher \"Women\" recebeu um cilque para acessa na pagina dos produtos.");
        } else {
            JsExecutorFw.highlight(driver, myAccountAppObject.getSelecionaWomenButton());
            ReportFw.log(Status.FAIL, "A botao de Mulher \"Women\" nao recebeu um cilque.");
        }
    }
}