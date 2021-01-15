package utils;


import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Driver {


    // Holds the WebDriver instance
    public static WebDriver driver;
    private Logger logger = Logger.getLogger(this.getClass());

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSpec
    public void initializeDriver(){
        driver = DriverFactory.getDriver();
        logger.info("Browser Opened Successfully");
    }

    // Close the webDriver instance
    @AfterSpec
    public void closeDriver(){
        driver.quit();
        logger.info("Browser clossed Successfully");
    }

}
