package fr.zenity;

import fr.zenity.Enum.Browser;
import fr.zenity.pageObjects.ExcelData;
import fr.zenity.pageObjects.LoginPage;
import fr.zenity.config.Properties;
import fr.zenity.manager.WebDriverManager;
import io.cucumber.java.an.E;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Objects;

public class JUnitTest {
    @Parameters({"browser"})
    @BeforeClass
    public void setUp(@Optional String browser){
        //if(!Objects.isNull(browser)) Properties.Config.setBrowser(browser);
        WebDriverManager
                .getInstance()
                .setDriver(Objects.isNull(browser) ? Properties.Config.getBrowser() : Browser.valueOf(browser.toUpperCase()));
    }

    @Test
    public void test1() throws IOException {
        /*LoginPage loginPage = new LoginPage();
        loginPage.NavigateTo();
        loginPage.ClickOnUser("UTILISATEUR");
        loginPage.setLogin("tester1");
        loginPage.setPassword("tester1");
        loginPage.clickOnLogin();
        /*ExcelData excelData = new ExcelData();
        excelData.loadData("Create");
        String test = excelData.getAdresseMail();
        System.out.println(test);*/
    }

    @AfterClass
    public void tearDown(){
        WebDriverManager.getInstance().quit();
    }

}
