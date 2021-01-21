package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.Driver;

public class HomePage extends Driver {

    private Logger logger;


    @FindBy(xpath = "//button[@id='ok-btn']")
    WebElement popupOKbtn;

    public HomePage()
    {
        objcommonutils= new CommonUtils();
        logger =Logger.getLogger(this.getClass());
        PageFactory.initElements(driver,this);
    }

    public void clickOkBtnOnPopup()
    {
        objcommonutils.clickElement(popupOKbtn);
        logger.info("clicked on Ok button of PopUP");
    }
    //Launch Application
    public void launchApplication()
    {
        String URL = System.getenv("APP_URL");
        driver.get(URL);
    }


}
