package fr.zenity.stepDefinitions;

import fr.zenity.pageObjects.AccountPage;
import fr.zenity.pageObjects.LogOutPage;
import io.cucumber.java8.En;

import static org.testng.Assert.assertTrue;

public class LogOutStep implements En {

    public LogOutStep(AccountPage accountPage, LogOutPage logOutPage){
        Given("^user is on account page$", () -> {
            accountPage.navigateTo();
        });

        When("^user click on \"log out\"$", () -> {
            logOutPage.logOut();
        });

        Then("^he should be disconnect$", () -> {
            assertTrue(accountPage.isLogOut());
        });
    }
}
