package PageObjects;

import Locators.ChapterOneLocators;
import Utils.UtilityFunctions;

public class ChapterOnePageObject extends UtilityFunctions implements ChapterOneLocators {

    public boolean compareLeftDivText(String expectedResult) {
        String result = getText(leftDivLocator);
        if (result == null) {
            return false; // element not found
        }
        return expectedResult.equalsIgnoreCase(result);
    }

    public boolean moveToHomePage() {
        return  click(HomePageLinkLocator);
    }
}
