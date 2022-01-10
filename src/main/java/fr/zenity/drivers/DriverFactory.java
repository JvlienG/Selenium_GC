package fr.zenity.drivers;

import fr.zenity.Enum.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory implements DriverFactoryImpl{

    private final WebDriver driver;

    public DriverFactory(Browser browser) {
        driver = createDriver(browser);
    }

    @Override
    public void quit() { driver.quit();}

    @Override
    public void close() {driver.close();}

    @Override
    public WebDriver getDriver() {return driver;}

    private WebDriver createDriver(Browser browser){
        System.out.println(browser.webDriverProp() +"///------"+ browser.webDriverPath());
        System.setProperty(browser.webDriverProp(),browser.webDriverPath());

        return browser.FIREFOX.equals(browser) ? new FirefoxDriver(firefoxOptions()) : new ChromeDriver(chromeOptions());
    }

}
