package utils;

public class Constants {
    public static final String SITE_URL;
    public static final String BROWSER;
    public static final String SCREENSHOT_LOCATION;
    public static final String WEBDRIVERS_LOCATION;


    static {
        PropertyReader propertyReader = new PropertyReader();
        SCREENSHOT_LOCATION = propertyReader.getProperty("screenshot.location");
        WEBDRIVERS_LOCATION = propertyReader.getProperty("webdrivers.location");
        SITE_URL = getURL();
        BROWSER = getBrowser();
        //add more properties
    }

    private static String getBrowser() {
        String browser = System.getProperty("browser");
        return browser == null ? "chrome" : browser;
    }

    private static String getURL() {
        String url = System.getProperty("url");
        return url == null ? "http://localhost:8080/" : url;
    }
}
