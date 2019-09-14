package br.fib.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SalarioPage {

    private WebDriver driver;

    public SalarioPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visita() {
        driver.get("http://localhost:9098/");
    }

    public NovoSalarioPage novo() {
        // clica no link de novo usuario
        driver.findElement(By.linkText("Novo Calculo")).click();
        // retorna a classe que representa a nova pagina
        return new NovoSalarioPage(driver);
    }

    public EditarSalarioPage editar(String nome) {
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        for (WebElement row : rows)
        {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > 0 && cells.get(0).getText().equals(nome))
            {
                row.findElement(By.cssSelector("td:nth-child(6) a")).click();
                // retorna a classe que representa a edição da pagina
                return new EditarSalarioPage(driver);
            }
        }

        // retorna a classe que representa a edição da pagina
        return new EditarSalarioPage(driver);
    }


    public void excluir(String nome) {
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        for (WebElement row : rows)
        {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > 0 && cells.get(0).getText().equals(nome))
            {
                row.findElement(By.cssSelector("td:nth-child(7) a")).click();
                return;
            }
        }

        // retorna a classe que representa a edição da pagina
        return;
    }


    public boolean existeNaListagem(String nome) {
        // verifica se ambos existem na listagem
        return driver.getPageSource().contains(nome);
    }
}
