package fr.zenity.runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features",
        //monochrome = true,
        glue = {"fr.zenity.stepDefinitions", "fr/zenity/pageObjects"},
        plugin = {"pretty",
                    "html:test-output",
                    "json:target/cucumber-report/cucumber.json",
                    "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        publish= true,
        tags = "@Select"

)
public class TestRunner extends BaseRunner{
}
