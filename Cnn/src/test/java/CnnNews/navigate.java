package CnnNews;


import CommonApi.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import News.Page;


/**
 * Created by Masud on 9/20/2015.
 */
public class navigate extends Base {

    Page page = null;
    String techHeadLine = "App makes sure you never walk home alone";
    String politicsHeadLine="ABC";

    @Test
    public void navigation() throws InterruptedException {

        page = PageFactory.initElements(driver, Page.class);

        //page.clickByElement(page.politics);

        //navigateBack();

        page.clickByElement(page.tech);
        String news = getTextByCss(".cd__headline-text");
        System.out.println(news);
        Assert.assertEquals(news, techHeadLine);
        sleepFor(1);
        navigateBack();


        page.clickByElement(page.politics);
        String newspolitics = getTextByCss(".cd__headline-text");
        System.out.println("Actual: " +newspolitics);
        Assert.assertEquals(newspolitics, politicsHeadLine);
        System.out.println("Test");
        sleepFor(1);



        /*String description = getTextByCss(".cd__description");
        System.out.println(description);*/
        //sleepFor(2);



    /* //clickByCss(".section.us.js-has-meganav.has-meganav>a");
     clickByXpath(".//*[@id='nav-header']/nav/div/div[4]/ul/li[1]/div/ul/li[1]/a");
        String news = getTextByCss(".cd__headline-text");
        System.out.println(news);
        Assert.assertEquals(news, techHeadLine);
        sleepFor(1); */

    }

}
