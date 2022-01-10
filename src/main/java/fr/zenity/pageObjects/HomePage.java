package fr.zenity.pageObjects;

import fr.zenity.config.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page{

    private final static String URL = Properties.Config.getEnvironment().getEnvironment();

    /* ------------------- FIND BY ------------------- */

        @FindBy(xpath = "//div[@id='blockLogo']/a/img")
        private WebElement logo;

        //@FindBy(className = "content");
        //private WebElement welcome;

    /* ----------------- FIN FIND BY ----------------- */

    /* ------------------- BY ------------------- */

        By welcome = By.className("content");

    /* ----------------- FIN BY ----------------- */

        private String currentUrl = driver.getCurrentUrl();

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch(Exception e){}
    }

    public void navigateTo(){
        if(this.currentUrl.equals(this.URL)){
            return;
        }
        driver.get(URL);
    }

    public void returnTo(){
        logo.click();
    }

    public boolean isHomePage(){
        if(driver.getCurrentUrl().equals(URL)){
            return true;
        }
        return false;
    }

    public boolean isWelcomeDisplayed(){
        //this.wait.until(driver -> true);

        this.pause(2000);

        if(driver.findElement(welcome).isDisplayed()){
            System.out.println("Element is Visible");
            return true;
        }else {
            System.out.println("Element is InVisible");
            return false;
        }
    }
}
