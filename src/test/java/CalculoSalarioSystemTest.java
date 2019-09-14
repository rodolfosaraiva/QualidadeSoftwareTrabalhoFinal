import br.fib.page.SalarioPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class CalculoSalarioSystemTest {
    private WebDriver driver;
    private SalarioPage salariosPage;

    @Before
    public void inicializa(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        this.driver = new ChromeDriver();
        this.salariosPage = new SalarioPage(driver);
    }


    @Test
    public void deveEditarUmUsuario() {
        salariosPage.visita();
        salariosPage.novo().cadastra("Manoel da Silva", "1", "10", "50");
        salariosPage.editar("Manoel da Silva").editar("Novo nome Rodolfo", "2", "10", "500");
        assertTrue(salariosPage.existeNaListagem("Novo nome Rodolfo"));
    }


    @Test
    public void deveExcluirUmUsuario() {
        salariosPage.visita();
        salariosPage.novo().cadastra("Usuario a ser excluido", "1", "10", "50");
        salariosPage.excluir("Usuario a ser excluido");
        assertFalse(salariosPage.existeNaListagem("Usuario a ser excluido"));
    }

    @Test
    public void deveAdicionarUmNovoSalario() {
        salariosPage.visita();
        salariosPage.novo().cadastra("Manoel da Silva", "1", "10", "50");
        assertTrue(salariosPage.existeNaListagem("Manoel da Silva"));
    }

    @After
    public void encerra(){
        driver.close();
    }

}
