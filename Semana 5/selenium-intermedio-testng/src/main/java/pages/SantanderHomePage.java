package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class SantanderHomePage extends BasePage {

    private static final By PERSONAS_MENU =
            By.id("firstLevel-mainItem-0-menu-button");

    private static final By EMPRESAS_MENU =
            By.id("firstLevel-mainItem-1-menu-button");

    private static final By PYMES_MENU =
            By.id("firstLevel-mainItem-2-menu-button");

    private static final By BANCA_PRIVADA =
            By.cssSelector(
                "a[href='https://www.santander.com.mx/bp/home/']"
            );

    private static final By ACERCA_BANCO_MENU =
            By.id("firstLevel-mainItem-4-menu-button");


    public SantanderHomePage(WebDriver driver) {
        super(driver);
    }


    // =========================
    // PERSONAS
    // =========================

    public void openPersonasMenu() {
        click(PERSONAS_MENU);
    }

    public void clickPersonasOption(String option) {

        By locator = By.xpath(
            "//div[@id='firstLevel-mainItem-0-menu']" +
            "//a[normalize-space(.)='" + option + "']"
        );

        WebElement element = find(locator);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", element);
    }


    // =========================
    // EMPRESAS
    // =========================

    public void openEmpresasMenu() {
        click(EMPRESAS_MENU);
    }

    public void clickEmpresasOption(String option) {
        click(By.xpath(
            "//div[@id='firstLevel-mainItem-1-menu']" +
            "//a[normalize-space(.)='" + option + "']"
        ));
    }


    // =========================
    // PYMES
    // =========================

    public void openPymesMenu() {
        click(PYMES_MENU);
    }

    public void clickPymesOption(String option) {
        click(By.xpath(
            "//div[@id='firstLevel-mainItem-2-menu']" +
            "//a[normalize-space(.)='" + option + "']"
        ));
    }


    // =========================
    // BANCA PRIVADA
    // =========================

    public void clickBancaPrivada() {
        click(BANCA_PRIVADA);
    }


    // =========================
    // ACERCA DEL BANCO
    // =========================

    public void openAcercaBancoMenu() {
        click(ACERCA_BANCO_MENU);
    }

    public void clickAcercaBancoOption(String option) {
        click(By.xpath(
            "//div[@id='firstLevel-mainItem-4-menu']" +
            "//a[normalize-space(.)='" + option + "']"
        ));
    }


    // =========================
    // URL VALIDATION
    // =========================

    public boolean checkUrl(String expectedUrl) {
        return driver.getCurrentUrl().equals(expectedUrl);
    }
}