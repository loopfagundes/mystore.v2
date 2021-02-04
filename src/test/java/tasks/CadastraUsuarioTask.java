package tasks;

import appobjects.CadastraUsuarioAppObject;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import framework.ReportFw;
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
        ReportFw.log(Status.INFO, "Registro do Usuario.");
        generoUsuario();
        nomeDoUsuario();
        senhaDoUsuario();
    }

    private void generoUsuario() {
        cadastraUsuarioAppObject.getGeneroCheckBox().click();
    }

    private void nomeDoUsuario() {
        cadastraUsuarioAppObject.getPrimeiroNomeTextField().sendKeys(faker.name().firstName());
        cadastraUsuarioAppObject.getSobrenomeTextField().sendKeys(faker.name().lastName());
    }

    private void senhaDoUsuario() {
        cadastraUsuarioAppObject.getSenhaTextField().sendKeys(faker.internet().password());
    }


}
