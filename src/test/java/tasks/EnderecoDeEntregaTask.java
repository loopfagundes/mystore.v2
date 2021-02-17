package tasks;

import appobjects.EnderecoDeEntregaAppObject;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import framework.JsExecutorFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EnderecoDeEntregaTask {
    private WebDriver driver;
    private EnderecoDeEntregaAppObject enderecoDeEntregaAppObject;
    private Faker faker = new Faker();

    public EnderecoDeEntregaTask(WebDriver driver) {
        this.driver = driver;
        this.enderecoDeEntregaAppObject = new EnderecoDeEntregaAppObject(driver);
    }

    public void enderecoDeEntregar() {
        validadoTelaDeEndereco();
        validadoAbaDeEndereco();
        validadoDoTituloDeEnderecoDeEntrega();
        testAll();
        observaDeEntrega();
        fazerCheckout();
    }

    private void validadoTelaDeEndereco() {
        Assert.assertEquals("ADDRESSES", enderecoDeEntregaAppObject.getValidadoTelaDeEnderecoText().getText());
        if (enderecoDeEntregaAppObject.getValidadoTelaDeEnderecoText().getText().equals("ADDRESSES")) {
            ReportFw.log(Status.PASS, "A tela de Endereco esta correta.");
        } else {
            JsExecutorFw.highlight(driver, enderecoDeEntregaAppObject.getValidadoTelaDeEnderecoText());
            ReportFw.log(Status.FAIL, "A tela de Endereco esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void validadoAbaDeEndereco() {
        Assert.assertEquals("03. Address", enderecoDeEntregaAppObject.getValidadoAbaDeEnderecoText().getText());
        if (enderecoDeEntregaAppObject.getValidadoAbaDeEnderecoText().getText().equals("03. Address")) {
            ReportFw.log(Status.PASS, "A aba de \"Address\" esta correta.");
        } else {
            JsExecutorFw.highlight(driver, enderecoDeEntregaAppObject.getValidadoAbaDeEnderecoText());
            ReportFw.log(Status.FAIL, "A aba de \"Address\" esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void validadoDoTituloDeEnderecoDeEntrega() {
        Assert.assertEquals("YOUR DELIVERY ADDRESS", enderecoDeEntregaAppObject.getValidadoTituloEnderecoDeEntregaText().getText());
        if (enderecoDeEntregaAppObject.getValidadoTituloEnderecoDeEntregaText().getText().equals("YOUR DELIVERY ADDRESS")) {
            ReportFw.log(Status.PASS, "O titulo de endereco de entrega esta correta.");
        } else {
            JsExecutorFw.highlight(driver, enderecoDeEntregaAppObject.getValidadoTituloEnderecoDeEntregaText());
            ReportFw.log(Status.FAIL, "O titulo de endereco de entrega esta correta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void testAll() {
        ReportFw.log(Status.INFO, "Validados os nomes, endereco, cep, pais e numero de telefone foram alternacoes...");
        System.out.println("Nome: " + enderecoDeEntregaAppObject.getValidadoNomeDoUsuarioText().getText());
        System.out.println("Endereco: " + enderecoDeEntregaAppObject.getValidadoEnderecoText().getText());
        System.out.println("Cep, city: " + enderecoDeEntregaAppObject.getValidadoCidadeEstadoCepText().getText());
        System.out.println("pais: " + enderecoDeEntregaAppObject.getValidadoPaisText().getText());
        System.out.println("numero telefone: " + enderecoDeEntregaAppObject.getValidadoNumeroDeTelefoneText().getText());
    }

    private void observaDeEntrega() {
        enderecoDeEntregaAppObject.getObeservaDeEntregaTextField().sendKeys(faker.harryPotter().house());
    }

    private void fazerCheckout() {
        if (enderecoDeEntregaAppObject.getFazerCheckoutButton().isDisplayed()) {
            enderecoDeEntregaAppObject.getFazerCheckoutButton().click();
            ReportFw.log(Status.PASS, "A botao de Procced to Checkout recebeu um clique.");
        } else {
            JsExecutorFw.highlight(driver, enderecoDeEntregaAppObject.getFazerCheckoutButton());
            ReportFw.log(Status.FAIL, "A botao de Procced to Checkout nao recebeu um clique." , ScreenshotFw.viewScreenshot(driver));
        }
    }
}