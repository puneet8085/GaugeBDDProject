package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverFactory
{


    public static WebDriver getDriver() {

        String browser = System.getenv("BROWSER");

            if ("IE".equals(browser))
            {
//             System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
       //s     return new InternetExplorerDriver();
            } else if ("Chrome".equals(browser))
            {
                System.setProperty("webdriver.chrome.driver", "./env/driver/chromedriver.exe");
                return new ChromeDriver();
            }
           System.setProperty("webdriver.gecko.driver", "./env/driver/geckodriver.exe");
            return new FirefoxDriver();
        }

        public static void closeDriver(WebDriver driver) throws Exception {
            driver.quit();

        }
    }