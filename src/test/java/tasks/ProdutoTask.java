package tasks;

import appobjects.ProdutoAppObject;
import com.aventstack.extentreports.Status;
import framework.JsExecutorFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;

public class ProdutoTask {
    private WebDriver driver;
    private ProdutoAppObject produtoAppObject;

    public ProdutoTask(WebDriver driver) {
        this.driver = driver;
        this.produtoAppObject = new ProdutoAppObject(driver);
    }

    public void descricaoProduto() {
        ReportFw.log(Status.INFO, "A pagina dos produtos.");
        validadoTelaDosProdutos();
        escolheProduto();
    }

    private void validadoTelaDosProdutos() {
        if(produtoAppObject.getValidadoTelaDosProdutosText().isDisplayed()) {
            ReportFw.log(Status.PASS, "A tela dos produtos esta correta.");
        } else {
            JsExecutorFw.highlight(driver, produtoAppObject.getValidadoTelaDosProdutosText());
            ReportFw.log(Status.FAIL, "A tela dos produtos esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void escolheProduto() {
        produtoAppObject.getEscolheVestidoButton().click();
    }
}
