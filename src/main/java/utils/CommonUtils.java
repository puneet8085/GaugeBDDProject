package utils;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class CommonUtils extends Driver {

    Actions act = new Actions(driver);
    WebDriverWait wait= new WebDriverWait(driver,30);



    public CommonUtils()
    {

    }



    //click on element
    public void clickElement(WebElement element)

    {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    //enter text in a WebElement
    public void enterText(WebElement element,String text)
    {
        if(element.isEnabled())
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
        }
    }
    //Method for select Class
    public Select selectClass(WebElement element)
    {
         return  new Select(element);
    }

    //Select dropdown value by index
    public void selectDDByIndex(WebElement element,int index)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
       selectClass(element).selectByIndex(index);

    }

    //Select dropdown value by visible text
    public void selectDDByVisibleText(WebElement element,String text)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        selectClass(element).selectByVisibleText(text);

    }
    //Select dropdown value by Value
    public void selectDDByValue(WebElement element,String text)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        selectClass(element).selectByValue(text);

    }
    //check element is enabled or not
    public boolean isElementEnabled(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
       return element.isEnabled();
    }
    //check element is Displayed or not
    public boolean isElementDisplayed(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    //To check checkbox is checked or not
    public boolean isCheckboxChecked(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isSelected();
    }



    //To check whether dropdown is a multi select dropdown or not
    public boolean isMultipleDD(WebElement element)
    {
      wait.until(ExpectedConditions.visibilityOf(element));
      return   selectClass(element).isMultiple();
    }
// to get all option from dropdown
    public List<WebElement> getDDOptions(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        return selectClass(element).getOptions();
    }

    //get current date time with seconds
    public final static String getDateTimeWithSec()
    {
        DateFormat df= new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss_S");
        df.setTimeZone(TimeZone.getTimeZone("GNT"));
        return df.format(new Date());
    }

    //select checkbox
    public void selectCheckbox(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    //Mouse hover on a element and click
    public void mouseHoverAndClick(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        act.moveToElement(element).perform();
        act.click(element).perform();

    }

// right click method on a element
public void rightClick(WebElement element)
{
    wait.until(ExpectedConditions.visibilityOf(element));
    act.contextClick(element).perform();

}

    //double click on a webelement
    public void doubleClick(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        act.doubleClick(element).perform();

    }

    // method to get session ID of current window
    public String getSessionIDOfWindow()
    {
        return driver.getWindowHandle();
    }

    //method to get page title
    public String pageTitle()
    {
        return driver.getTitle();

    }

    //method to get current page url
    public String getCurrentPageURl()
    {
        return driver.getCurrentUrl();
    }


    //Method to switch window
    public void switchWindow() {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);

        }
    }}