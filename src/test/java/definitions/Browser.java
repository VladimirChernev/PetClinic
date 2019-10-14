package definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Constants;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static final Logger LOGGER = LoggerFactory.getLogger(Browser.class);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //Drivers location
    public static final String CHROME_DRIVER_NAME = "chromedriver.exe";
    public static final String FIREFOX_DRIVER_NAME = "geckodriver.exe";
    public static final String IE_DRIVER_NAME = "IEDriverServer.exe";
    public static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    public static final String FIREFOX_PROPERTY = "webdriver.gecko.driver";
    public static final String IE_PROPERTY = "webdriver.ie.driver";
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void startBrowser(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(FIREFOX_PROPERTY, Constants.WEBDRIVERS_LOCATION + FIREFOX_DRIVER_NAME);
            driver = new FirefoxDriver();
            configureBrowser(browser);
        }
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(CHROME_PROPERTY, Constants.WEBDRIVERS_LOCATION + CHROME_DRIVER_NAME);
            driver = new ChromeDriver();
            configureBrowser(browser);
        }
        if (browser.equalsIgnoreCase("ie")) {
            System.setProperty(IE_PROPERTY, Constants.WEBDRIVERS_LOCATION + IE_DRIVER_NAME);
            driver = new InternetExplorerDriver();
            configureBrowser(browser);
        }

    }

    private void configureBrowser(String browser) {
        LOGGER.info("Starting browser:" + browser.toUpperCase());
        driver.manage().deleteAllCookies(); //delete cookies
        driver.manage().window().maximize(); //To maximize browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //Implicit wait
    }


    @Before
    public void before() {
        startBrowser(Constants.BROWSER);
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE); //capture screenshot
                String fileName = scenario.getName() + ".png";
                FileUtils.copyFile(src, new File(Constants.SCREENSHOT_LOCATION + sdf.format(timestamp) + "\\" + fileName)); //copy file to location
                LOGGER.info("Successfully captured a screenshot");
                LOGGER.info("Stored image:" + fileName + " at:" + Constants.SCREENSHOT_LOCATION);
            } catch (Exception e) {
                LOGGER.info("Exception while taking screenshot " + e.getMessage());
            }
        }
        driver.quit();
    }
}
