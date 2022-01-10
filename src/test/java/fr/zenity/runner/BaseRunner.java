package fr.zenity.runner;

import fr.zenity.Enum.Browser;
import fr.zenity.config.Properties;
import fr.zenity.manager.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Objects;

public class BaseRunner extends AbstractTestNGCucumberTests {

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional String browser){
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.getInstance().quit();
    }


}
