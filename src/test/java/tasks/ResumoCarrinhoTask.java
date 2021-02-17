package tasks;

import appobjects.ResumoCarrinhoAppObject;
import com.aventstack.extentreports.Status;
import framework.JsExecutorFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
        validadoTotalProduto();
        validadoTotalEnvio();
        validadoTodoTotal();
        fazerCheckout();
    }

    private void validadoTelaResumoDoCarrinho() {
        Assert.assertEquals("SHOPPING-CART SUMMARY\n" +
                "Your shopping cart contains: 2 Products", resumoCarrinhoAppObject.getValidadoTelaResumoCarrinhoText().getText());
        if (resumoCarrinhoAppObject.getValidadoTelaResumoCarrinhoText().getText().equals("SHOPPING-CART SUMMARY\n" +
                "Your shopping cart contains: 2 Products")) {
            ReportFw.log(Status.PASS, "A pagina de Resumo do carrinho esta correta.");
        } else {
            JsExecutorFw.highlight(driver, resumoCarrinhoAppObject.getValidadoTelaResumoCarrinhoText());
            ReportFw.log(Status.FAIL, "A pagina de Resumo do carrinho esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void validadoAbaDeResumo() {
        Assert.assertEquals("01. Summary", resumoCarrinhoAppObject.getValidadoAbaResumoText().getText());
        if (resumoCarrinhoAppObject.getValidadoAbaResumoText().getText().equals("01. Summary")) {
            ReportFw.log(Status.PASS, "A aba de \"Summary\" esta correta.");
        } else {
            JsExecutorFw.highlight(driver, resumoCarrinhoAppObject.getValidadoAbaResumoText());
            ReportFw.log(Status.FAIL, "A aba de \"Summary\" esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void validadoTotalProduto() {
        Assert.assertEquals("$57.96", resumoCarrinhoAppObject.getTotalProdutoText().getText());
        if (resumoCarrinhoAppObject.getTotalProdutoText().getText().equals("$57.96")) {
            ReportFw.log(Status.PASS, "Total os produtos estao corretas.");
        } else {
            JsExecutorFw.highlight(driver, resumoCarrinhoAppObject.getTotalProdutoText());
            ReportFw.log(Status.FAIL, "Total os produtos estao incorretas. Verificar, por favor.");
        }
    }

    private void validadoTotalEnvio() {
        Assert.assertEquals("$2.00", resumoCarrinhoAppObject.getTotalEnvioText().getText());
        if (resumoCarrinhoAppObject.getTotalEnvioText().getText().equals("$2.00")) {
            ReportFw.log(Status.PASS, "O valor de envio esta correta.");
        } else {
            JsExecutorFw.highlight(driver, resumoCarrinhoAppObject.getTotalEnvioText());
            ReportFw.log(Status.FAIL, "O valor de envio esta incorreta, Verificar, por favor.");
        }
    }

    private void validadoTodoTotal() {
        Assert.assertEquals("$59.96", resumoCarrinhoAppObject.getTodoTotalText().getText());
        if (resumoCarrinhoAppObject.getTodoTotalText().getText().equals("$59.96")) {
            ReportFw.log(Status.PASS, "O valor de total esta correta.");
        } else {
            JsExecutorFw.highlight(driver, resumoCarrinhoAppObject.getTodoTotalText());
            ReportFw.log(Status.FAIL, "O valor de total esta incorreta. Verificar, por favor.");
        }
    }

    private void fazerCheckout() {
        resumoCarrinhoAppObject.getFazerCheckoutButton().click();
    }
}