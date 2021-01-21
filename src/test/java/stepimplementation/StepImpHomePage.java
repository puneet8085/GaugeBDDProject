package stepimplementation;

import com.thoughtworks.gauge.Step;
import pages.HomePage;

public class StepImpHomePage {

    HomePage home = new HomePage();

    @Step("Go to Icegate Home Page")
    public void openApplication()
    {
       home.launchApplication();
    }

    @Step("Click on Ok button from POPUP")
    public void clickOK()
    {
        home.clickOkBtnOnPopup();
    }
}
