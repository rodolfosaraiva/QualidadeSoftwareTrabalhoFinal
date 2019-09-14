package br.fib.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoSalarioPage {
    private WebDriver driver;

    public NovoSalarioPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cadastra(String nome, String dependentes, String horasTrabalhadas, String salarioHora) {
        WebElement txtNome = driver.findElement(By.name("name"));
        WebElement txtDependentes = driver.findElement(By.name("dependents"));
        WebElement txtHorasTrabalhadas = driver.findElement(By.name("timeToWork"));
        WebElement txtSalarioHora = driver.findElement(By.name("salaryHour"));
        txtNome.sendKeys(nome);
        txtDependentes.sendKeys(dependentes);
        txtHorasTrabalhadas.sendKeys(horasTrabalhadas);
        txtSalarioHora.clear();
        txtSalarioHora.sendKeys(salarioHora);
        txtNome.submit();
    }
}
