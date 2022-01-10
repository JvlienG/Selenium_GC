package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.AccountPage;
import fr.zenity.pageObjects.LoginPage;
import fr.zenity.pageObjects.HomePage;

import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class NewAccountStep implements En{

    public NewAccountStep(AccountPage accountPage){
        When("^user fill fields$", () -> {
            accountPage.createCompteValid();
        });

        Then("^he should be on page for account activation$",() -> {
            assertTrue(accountPage.createdAccount());
        });
    }
}
