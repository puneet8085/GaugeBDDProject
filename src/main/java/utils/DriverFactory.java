package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class DriverFactory
{

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() {

        String browser = System.getenv("BROWSER");
        browser = (browser == null) ? "CHROME": browser;

                    if ("IE".equals(browser)) {
//               System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
                return new InternetExplorerDriver();
            } else if ("Chrome".equals(browser)) {
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