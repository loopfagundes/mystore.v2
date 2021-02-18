package tasks;

import appobjects.EnvioAppObject;
import com.aventstack.extentreports.Status;
import framework.JsExecutorFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.apache.http.client.CredentialsProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EnvioTask {
    private WebDriver driver;
    private EnvioAppObject envioAppObject;

    public EnvioTask(WebDriver driver) {
        this.driver = driver;
        this.envioAppObject = new EnvioAppObject(driver);
    }

    public void verficiaEnvio() {
        validadoTelaDeEnvio();
        validadoAbaDeEnvio();
        validadoValorDeEnvio();
        termoDeServico();
        fazerCheckout();
    }

    private void validadoTelaDeEnvio() {
        Assert.assertEquals("SHIPPING", envioAppObject.getValidadoTelaDeEnvioText().getText());
        if (envioAppObject.getValidadoTelaDeEnvioText().getText().equals("SHIPPING")) {
            ReportFw.log(Status.PASS, "A tela de envio esta correta.");
        } else {
            JsExecutorFw.highlight(driver, envioAppObject.getValidadoTelaDeEnvioText());
            ReportFw.log(Status.FAIL, "A tela de envio esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void validadoAbaDeEnvio() {
        Assert.assertEquals("04. Shipping", envioAppObject.getValidadoAbaDeEnvioText().getText());
        if (envioAppObject.getValidadoAbaDeEnvioText().getText().equals("04. Shipping")) {
            ReportFw.log(Status.PASS, "A aba de envio esta correta.");
        } else {
            JsExecutorFw.highlight(driver, envioAppObject.getValidadoAbaDeEnvioText());
            ReportFw.log(Status.FAIL, "A aba de envio esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void validadoValorDeEnvio() {
        Assert.assertEquals("$2.00", envioAppObject.getValidadoValorDeEnvioText().getText());
        if (envioAppObject.getValidadoValorDeEnvioText().getText().equals("$2.00")) {
            ReportFw.log(Status.PASS, "O valor de envio esta correta.");
        } else {
            JsExecutorFw.highlight(driver, envioAppObject.getValidadoValorDeEnvioText());
            ReportFw.log(Status.FAIL, "O valor de envio esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void termoDeServico() {
        Assert.assertEquals("Terms of service", envioAppObject.getValidadoTermoDeServicoText().getText());
        if (envioAppObject.getTermoDeServicoCheckBox().isDisplayed()) {
            envioAppObject.getTermoDeServicoCheckBox().click();
            ReportFw.log(Status.PASS, "Checkbox de termo de servico recebeu um cilque.");
        } else {
            JsExecutorFw.highlight(driver, envioAppObject.getTermoDeServicoCheckBox());
            ReportFw.log(Status.FAIL, "Checkbox de termo de servico nao recebeu um cilque.");
        }
    }

    private void fazerCheckout() {
        if (envioAppObject.getFazerCheckoutButton().isDisplayed()) {
            envioAppObject.getFazerCheckoutButton().click();
            ReportFw.log(Status.PASS, "A botao de Procced to Checkout recebeu um cilque.");
        } else {
            JsExecutorFw.highlight(driver, envioAppObject.getFazerCheckoutButton());
            ReportFw.log(Status.FAIL, "A botao de Procced to Checkout nao recebeu um cilque.", ScreenshotFw.viewScreenshot(driver));
        }
    }
}