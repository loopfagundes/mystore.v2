package tasks;

import appobjects.IndexAppObject;
import com.aventstack.extentreports.Status;
import framework.ReportFw;
import org.openqa.selenium.WebDriver;

public class IndexTask {

    private WebDriver driver;
    private IndexAppObject indexAppObject;


    public IndexTask(WebDriver driver) {
        this.driver = driver;
        this.indexAppObject = new IndexAppObject(driver);
    }

    public void acessaTelaDeLogin() {
        ReportFw.log(Status.INFO, "A pagina de Index.");
        if (indexAppObject.getSignUpButton().isDisplayed()) {
            indexAppObject.getSignUpButton().click();
            ReportFw.log(Status.PASS, "A botao de Sign Up recebeu um clique.");
        } else {
            ReportFw.log(Status.FAIL, "A botao de Sign Up recebeu um clique.");
        }
    }
}