package fr.zenity.config;

import fr.zenity.Enum.Browser;
import fr.zenity.Enum.Urls;


public class PropertiesConfig {

    private final static PropertiesConfig INSTANCE = new PropertiesConfig();

    private final PropertiesLoader prop = PropertiesLoader.of("config");

    private String webDriverPath;
    private String proxy;
    private Boolean isProxy;
    private Boolean headless;
    private Browser browser;

    private Urls environment;


    private PropertiesConfig(){
        String browserString;
        String tmp;

        proxy = prop.getProperty("proxy");
        isProxy = prop.getProperty("isProxy",false );
        //headless = Boolean.valueOf(prop.getProperty("headless"));
        headless = Boolean.valueOf(System.getProperty("headless",prop.getProperty("headless")));
        //browser = prop.getProperty("browser");
        browserString = System.getProperty("browser", prop.getProperty("browser", "chrome"));
        browser = Browser.valueOf(browserString.toUpperCase()) ;
        webDriverPath = prop.getProperty(browserString);
        tmp = System.getProperty("env",prop.getProperty("env","production")).toUpperCase();
        environment = Urls.valueOf(tmp);
    }

    public Browser getBrowser(){return browser;}
    public String getWebDriverPath() {return webDriverPath;}
    public String getProxy() {return proxy;}
    public Boolean getHeadless() {return headless;}
    public Boolean getIsProxy(){return isProxy;}
    public Urls getEnvironment(){ return environment; }
/*
    public void setBrowser(String b){
        browser = Browser.valueOf(b.toUpperCase());
        webDriverPath = prop.getProperty(browser.getBrowserName());
    }

 */

    public static PropertiesConfig getInstance(){return INSTANCE;}

}
