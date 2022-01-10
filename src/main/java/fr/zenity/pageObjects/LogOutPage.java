package fr.zenity.pageObjects;

import fr.zenity.config.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogOutPage extends Page{

    /* ------------------- BY ------------------- */
        By compte = By.xpath("//a[@href='/client/compte.html']");
        By deco = By.xpath("(//a[contains(@href, '/deconnexion.html')])[2]");

    public void logOut(){
        WebElement wCompte = this.driver.findElement(compte);
        wCompte.click();

        WebElement wDeco = this.driver.findElement(deco);
        wDeco.click();
    }
}
