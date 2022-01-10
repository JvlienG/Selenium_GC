package fr.zenity.pageObjects;

import fr.zenity.manager.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait longWait;
    protected WebDriverWait middleWait;

    protected JavascriptExecutor js;
    protected Actions actions;

    protected Page(){
        driver = WebDriverManager.getInstance().getDriver();
        PageFactory.initElements(driver,this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        middleWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        longWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        js = (JavascriptExecutor)driver;
        actions = new Actions(driver);
    }

    public void clickOn(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void maximize(){
        driver.manage().window().maximize();
    }

}
