import Driver.Config;
import PageObjects.ChapterOnePageObject;
import PageObjects.HomePageObjects;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestChapterOne {

    HomePageObjects homepage;
    ChapterOnePageObject chapterOne;

    @BeforeClass
    public void Setup() {
        homepage = new HomePageObjects();
        chapterOne = new ChapterOnePageObject();
    }

    @Test(priority = 1)
    public void testOpenPage() {
        boolean result = homepage.openPage();
        Assert.assertTrue(result, "Unable to open page.");
    }

    @Test(priority = 2)
    public void checkForText() {
        String textToVerify = "Assert that this text is on the page";
        boolean moveToChapterOne = homepage.clickChapterOne();
        Assert.assertTrue(moveToChapterOne, "Unable to open page.");
        boolean compareText = chapterOne.compareLeftDivText(textToVerify);
        Assert.assertTrue(compareText, "Failed. Text not matched.");

    }

    @Test(priority = 3)
    public void returnToHomePage(){
        Assert.assertTrue(chapterOne.moveToHomePage(),"HomePage link not visible");
    }


    @AfterClass
    public void teardown() {
        homepage.closeDriver();
    }
}
