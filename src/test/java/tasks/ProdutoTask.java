package tasks;

import appobjects.ProdutoAppObject;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import framework.JsExecutorFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import framework.WaitFw;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProdutoTask {
    private WebDriver driver;
    private ProdutoAppObject produtoAppObject;
    private Faker faker = new Faker();

    public ProdutoTask(WebDriver driver) {
        this.driver = driver;
        this.produtoAppObject = new ProdutoAppObject(driver);
    }

    public void descricaoProduto() {
        ReportFw.log(Status.INFO, "A pagina dos produtos.");
        validadoTelaDosProdutos();
        escolheProduto();
        validadoNomeDoProduto();
        quantidadeProduto();
        tamanhoProduto();
        corProduto();
        adicionaNoCarrinho();
        fazerCheckout();
    }

    private void validadoTelaDosProdutos() {
        if (produtoAppObject.getValidadoTelaDosProdutosText().isDisplayed()) {
            ReportFw.log(Status.PASS, "A tela dos produtos esta correta.");
        } else {
            JsExecutorFw.highlight(driver, produtoAppObject.getValidadoTelaDosProdutosText());
            ReportFw.log(Status.FAIL, "A tela dos produtos esta incorreta.", ScreenshotFw.viewScreenshot(driver));
        }
    }

    private void escolheProduto() {
        produtoAppObject.getEscolheVestidoButton().click();
    }

    private void validadoNomeDoProduto() {
        ReportFw.log(Status.INFO, "Escolhe um produto: Vestido");
        Assert.assertEquals("Printed Summer Dress", produtoAppObject.getValidadoNomeProdutoText().getText());
    }

    private void quantidadeProduto() {
        ReportFw.log(Status.INFO, "Quantidade do produto: 2");
        produtoAppObject.getQuantidadeProdutoText().clear();
        produtoAppObject.getQuantidadeProdutoText().sendKeys("2");
    }

    private void tamanhoProduto() {
        ReportFw.log(Status.INFO, "Tamanho do produto: S como P");
        produtoAppObject.getTamanhoProdutoComboBox().selectByValue("1");
    }

    private void corProduto() {
        ReportFw.log(Status.INFO, "Escolhe cor do produto: Preto");
        produtoAppObject.getCorProdutoButton().click();
    }

    private void adicionaNoCarrinho() {
        produtoAppObject.getAdicionaCarrinhoButton().click();
    }

    private void fazerCheckout() {
        WaitFw.visibilityOf(driver, produtoAppObject.getFazerCheckoutButton());
        if (produtoAppObject.getFazerCheckoutButton().isDisplayed()) {
            produtoAppObject.getFazerCheckoutButton().click();
            ReportFw.log(Status.PASS, "A botao de Proceed to checkout recebe um clique.");
        } else {
            JsExecutorFw.highlight(driver, produtoAppObject.getFazerCheckoutButton());
            ReportFw.log(Status.FAIL, "A botao de Proceed to checkout nao recebe um clique.", ScreenshotFw.viewScreenshot(driver));
        }
    }
}