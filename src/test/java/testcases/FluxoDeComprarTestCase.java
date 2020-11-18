package testcases;

import com.aventstack.extentreports.Status;
import framework.BaseTestFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FluxoDeComprarTestCase extends BaseTestFw {

    private WebDriver driver;

    @Test
    public void test() {
        try {
            ReportFw.setUpStart("Fluxo de comprar");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportFw.log(Status.ERROR, e.getMessage(), ScreenshotFw.viewScreenshot(driver));
        }
    }
}
