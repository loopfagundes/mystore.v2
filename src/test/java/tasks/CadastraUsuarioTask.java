package tasks;

import appobjects.CadastraUsuarioAppObject;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import framework.JsExecutorFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;

public class CadastraUsuarioTask {

    private WebDriver driver;
    private CadastraUsuarioAppObject cadastraUsuarioAppObject;
    private Faker faker = new Faker();

    public CadastraUsuarioTask(WebDriver driver) {
        this.driver = driver;
        this.cadastraUsuarioAppObject = new CadastraUsuarioAppObject(driver);
    }

    public void registroUsuario() {
        validadoTelaDaCriarConta();
        ReportFw.log(Status.INFO, "Registra do Usuario.");
        generoUsuario();
        nomeDoUsuario();
        senhaDoUsuario();
        dataDeNascimento();
        assinaNossoSite();
        ofertarNossaSite();
        enderecoDoUsuario();
        cidadeDoUsuario();
        estadoDoUsuario();
        cepDoUsuario();
        adicionaInformacao();
        numeroDeTeleoneDoUsuario();
        registro();
    }

    private void validadoTelaDaCriarConta() {
        if(cadastraUsuarioAppObject.getValidadoTelaDeCriarContaText().isDisplayed()) {
            ReportFw.log(Status.PASS, "A pagina de criar conta esta correta.");
        } else {
            JsExecutorFw.highlight(driver, cadastraUsuarioAppObject.getRegistroButton());
            ReportFw.log(Status.FAIL, "A pagina de criar conta esta incorreta", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void generoUsuario() {
        cadastraUsuarioAppObject.getGeneroCheckBox().click();
        if(cadastraUsuarioAppObject.getGeneroCheckBox().isSelected()) {
            ReportFw.log(Status.PASS, "CheckBox de genero do usuario recebeu um clique.");
        } else {
            JsExecutorFw.highlight(driver, cadastraUsuarioAppObject.getRegistroButton());
            ReportFw.log(Status.FAIL, "CheckBox de genero do usuario nao recebeu um clique.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void nomeDoUsuario() {
        cadastraUsuarioAppObject.getPrimeiroNomeTextField().sendKeys(faker.name().firstName());
        cadastraUsuarioAppObject.getSobrenomeTextField().sendKeys(faker.name().lastName());
    }

    private void senhaDoUsuario() {
        cadastraUsuarioAppObject.getSenhaTextField().sendKeys(faker.internet().password());
    }

    private void dataDeNascimento() {
        cadastraUsuarioAppObject.getDiaComboBox().selectByValue("20");
        cadastraUsuarioAppObject.getMesComboBox().selectByValue("10");
        cadastraUsuarioAppObject.getAnoComboBox().selectByValue("1990");
    }

    private void assinaNossoSite() {
        cadastraUsuarioAppObject.getAssinaNossoSiteCheckBox().click();
        if(cadastraUsuarioAppObject.getAssinaNossoSiteCheckBox().isSelected()) {
            ReportFw.log(Status.PASS, "CheckBox de Assina do nosso site recebeu um clique.");
        } else {
            JsExecutorFw.highlight(driver, cadastraUsuarioAppObject.getRegistroButton());
            ReportFw.log(Status.FAIL, "CheckBox de Assina do nosso site nao recebeu um clique.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void ofertarNossaSite() {
        cadastraUsuarioAppObject.getRecebeOfertasSiteCheckBox().click();
        if(cadastraUsuarioAppObject.getRecebeOfertasSiteCheckBox().isSelected()) {
            ReportFw.log(Status.PASS, "CheckBox de Ofertar recebeu um clique.");
        } else {
            JsExecutorFw.highlight(driver, cadastraUsuarioAppObject.getRegistroButton());
            ReportFw.log(Status.FAIL, "CheckBox de Ofertar nao recebeu um clique.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void enderecoDoUsuario() {
        cadastraUsuarioAppObject.getEnderecoTextField().sendKeys(faker.address().fullAddress());
    }

    private void cidadeDoUsuario() {
        cadastraUsuarioAppObject.getCidadeTextField().sendKeys(faker.address().city());
    }

    private void estadoDoUsuario() {
        cadastraUsuarioAppObject.getEstadoComboBox().selectByValue("32");
    }

    private void cepDoUsuario() {
        cadastraUsuarioAppObject.getCepTextField().sendKeys(faker.number().digits(5));
    }

    private void adicionaInformacao() {
        cadastraUsuarioAppObject.getAddInformacaoTextField().sendKeys(faker.chuckNorris().fact());
    }

    private void numeroDeTeleoneDoUsuario() {
        cadastraUsuarioAppObject.getNumeroTelefoneTextField().sendKeys(faker.phoneNumber().cellPhone());
    }

    private void registro() {
       if(cadastraUsuarioAppObject.getRegistroButton().isDisplayed()) {
           cadastraUsuarioAppObject.getRegistroButton().click();
           ReportFw.log(Status.PASS, "A botao de registro recebeu um clique. Registrou com sucesso.");
       } else {
           ReportFw.log(Status.FAIL, "A botao de registro nao recebeu um clique.");
       }
    }
}