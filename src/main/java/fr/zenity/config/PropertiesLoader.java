package fr.zenity.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.function.BiConsumer;

public class PropertiesLoader {

    private final static String CONFIG_FILE = "config/%s.properties";

    private Properties prop = new Properties();

    public PropertiesLoader(String configFile) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(String.format(CONFIG_FILE, configFile)));
            prop.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key){return prop.getProperty(key);}

    public String getProperty (String key, String defaultValue) {return prop.getProperty(key,defaultValue);}

    public Boolean getProperty (String key, Boolean defaultValue) {
        return prop.getProperty(key) == null ? defaultValue : Boolean.valueOf(getProperty(key));
    }

    public void forEach(BiConsumer<String,String> biConsumer) {
        prop.forEach((Object key, Object value)->biConsumer.accept((String)key, (String)value));
    }

    public static PropertiesLoader of(String configFile){
        return new PropertiesLoader(configFile);
    }
}