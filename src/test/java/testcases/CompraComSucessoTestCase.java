package testcases;

import com.aventstack.extentreports.Status;
import framework.BaseTestFw;
import framework.ReportFw;
import framework.ScreenshotFw;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tasks.*;

public class CompraComSucessoTestCase extends BaseTestFw {

    private final WebDriver driver = getDriver();
    private IndexTask indexTask = new IndexTask(driver);
    private AuthenticationTask authenticationTask = new AuthenticationTask(driver);
    private CadastraUsuarioTask cadastraUsuarioTask = new CadastraUsuarioTask(driver);
    private MinhaContaTask myAccountTask = new MinhaContaTask(driver);
    private ProdutoTask produtoTask = new ProdutoTask(driver);
    private ResumoCarrinhoTask resumoCarrinhoTask = new ResumoCarrinhoTask(driver);
    private EnderecoDeEntregaTask enderecoDeEntregaTask = new EnderecoDeEntregaTask(driver);

    @Test
    public void test() {
        try {
            ReportFw.setUpStart("Fluxo de comprar");
            indexTask.acessaTelaDeLogin();
            authenticationTask.paginaAuthentication();
            cadastraUsuarioTask.registroUsuario();
            myAccountTask.telaDaMinhaConta();
            produtoTask.descricaoProduto();
            resumoCarrinhoTask.ResumoCarrinho();
            enderecoDeEntregaTask.enderecoDeEntregar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportFw.log(Status.ERROR, e.getMessage(), ScreenshotFw.viewScreenshot(driver));
        }
    }
}