package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/application.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось загрузить application.properties");
        }
    }

    public static String getHost (){
        return properties.getProperty("host");
    }

    public static String getUsersEndpoint (){
        return properties.getProperty("UrlUsers");
    }

    public static String getProductsEndpoint(){
        return properties.getProperty("UrlProducts");
    }

}
