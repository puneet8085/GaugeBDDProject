package stepimplementation;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends Driver {
    @Step("Go to Gauge Get Started Page")
    public void gotoGetStartedPage() throws InterruptedException {
        WebElement getStartedButton = Driver.driver.findElement(By.xpath("//a[@href='https://docs.gauge.org/getting_started/installing-gauge.html']"));
        getStartedButton.click();

        Gauge.writeMessage("Page title is %s", Driver.driver.getTitle());
    }

    @Step("Ensure installation instructions are available")
    public void ensureInstallationInstructionsAreAvailable() throws InterruptedException {
        WebElement instructions = Driver.driver.findElement(By.xpath("//a[@href='/writing-specifications.html']"));
        assertThat(instructions).isNotNull();
    }

    @Step("Open the Gauge homepage")
    public void implementation1() {
        String app_url = System.getenv("APP_URL");
        Driver.driver.get(app_url + "/");
        assertThat(Driver.driver.getTitle()).contains("Gauge");
    }
}
