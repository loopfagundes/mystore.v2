package tasks;

import appobjects.ResumoCarrinhoAppObject;
import com.aventstack.extentreports.Status;
import framework.JsExecutorFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;

public class ResumoCarrinhoTask {
    private WebDriver driver;
    private ResumoCarrinhoAppObject resumoCarrinhoAppObject;

    public ResumoCarrinhoTask(WebDriver driver) {
        this.driver = driver;
        this.resumoCarrinhoAppObject = new ResumoCarrinhoAppObject(driver);
    }

    public void ResumoCarrinho() {
        validadoTelaResumoDoCarrinho();
        validadoAbaDeResumo();
}

    private void validadoTelaResumoDoCarrinho() {
        if(resumoCarrinhoAppObject.getValidadoTelaResumoCarrinhoText().getText().equals("SHOPPING-CART SUMMARY\n" +
                "Your shopping cart contains: 2 Products")) {
            ReportFw.log(Status.PASS, "A pagina de Resumo do carrinho esta correta.");
        } else {
            JsExecutorFw.highlight(driver, resumoCarrinhoAppObject.getValidadoTelaResumoCarrinhoText());
            ReportFw.log(Status.FAIL, "A pagina de Resumo do carrinho esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void validadoAbaDeResumo() {
        if(resumoCarrinhoAppObject.getValidadoAbaResumoText().getText().equals("01. Summary")) {
            ReportFw.log(Status.PASS, "A aba de \"Summary\" esta correta");
        } else {
            JsExecutorFw.highlight(driver, resumoCarrinhoAppObject.getValidadoAbaResumoText());
            ReportFw.log(Status.FAIL, "A aba de \"Summary\" esta incorreta", ScreenshotFw.viewScreenshot(driver));
        }
    }
}