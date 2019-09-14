package br.fib.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditarSalarioPage {
    private WebDriver driver;

    public EditarSalarioPage(WebDriver driver) {
        this.driver = driver;
    }

    public void editar(String nome, String dependentes, String horasTrabalhadas, String salarioHora) {
        WebElement txtNome = driver.findElement(By.name("name"));
        WebElement txtDependentes = driver.findElement(By.name("dependents"));
        WebElement txtHorasTrabalhadas = driver.findElement(By.name("timeToWork"));
        WebElement txtSalarioHora = driver.findElement(By.name("salaryHour"));
        txtNome.clear();
        txtNome.sendKeys(nome);
        txtDependentes.clear();
        txtDependentes.sendKeys(dependentes);
        txtHorasTrabalhadas.clear();
        txtHorasTrabalhadas.sendKeys(horasTrabalhadas);
        txtSalarioHora.clear();
        txtSalarioHora.sendKeys(salarioHora);
        txtNome.submit();
    }
}
