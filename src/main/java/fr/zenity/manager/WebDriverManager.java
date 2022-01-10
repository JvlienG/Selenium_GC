package fr.zenity.manager;

import fr.zenity.Enum.Browser;
import fr.zenity.drivers.DriverFactory;
import fr.zenity.drivers.Drivers;
import org.openqa.selenium.WebDriver;

public class WebDriverManager implements Drivers {

    private final static WebDriverManager INSTANCE = new WebDriverManager();
    private ThreadLocal<DriverFactory> driver = new ThreadLocal<>();
    protected WebDriverManager(){}

    @Override
    public void quit() { driver.get().quit();}

    @Override
    public void close() {driver.get().close();}

    @Override
    public WebDriver getDriver() { return driver.get().getDriver(); }

    public void setDriver(Browser browser){
        driver.set(new DriverFactory(browser));
    }

    public static WebDriverManager getInstance(){return INSTANCE;}
}
