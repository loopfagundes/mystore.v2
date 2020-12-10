package testcases;

import com.aventstack.extentreports.Status;
import framework.BaseTestFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tasks.AuthenticationTask;
import tasks.IndexTask;

public class CompraComSucessoTestCase extends BaseTestFw {

    private WebDriver driver = getDriver();
    private IndexTask indexTask = new IndexTask(driver);
    private AuthenticationTask authenticationTask = new AuthenticationTask(driver);

    @Test
    public void test() {
        try {
            ReportFw.setUpStart("Fluxo de comprar");
            indexTask.acessaTelaDeLogin();
            authenticationTask.paginaAuthentication();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportFw.log(Status.ERROR, e.getMessage(), ScreenshotFw.viewScreenshot(driver));
        }
    }
}