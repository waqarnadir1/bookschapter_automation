package PageObjects;

import Driver.Config;
import Locators.HomePageLocators;
import Utils.UtilityFunctions;

public class HomePageObjects extends UtilityFunctions implements HomePageLocators {

    public boolean openPage() {
        return openPageJS(Config.URL);
    }

    public boolean clickChapterOne() {
        boolean result = click(ChapterOneLink);
        if (result == false) {
            return false;           // Link is not accessible.
        }
        waitForPageLoad();
        return true;
    }
}
