import CommonApi.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by Masud on 9/18/2015.
 */
public class gmail extends Base {

    @Test
    public void emailsend() throws InterruptedException {
        typeByCss("#Email", "mdmowla01@gmail.com");
        clickByCss("#next");
        typeByCss("#Passwd", "masud8496%tonima");
        clickByCss("#signIn");
        sleepFor(2);
        //clickByCss(".T-I.J-J5-Ji.T-I-KE.L3.T-I-JW");
        clickByXpath(".//*[@id=':hw']/div/div");
        sleepFor(1);
        WebElement element = getWebElementByCss("#oauth2relay220627197");
        iframeHandle(element);
        typeByXpath(".//*[@id=':tm']", "mdmowla01@gmail.com");

        typeByXpath(".//*[@id=':rx']", "SeleniumTest");
        sleepFor(1);
        typeByXpath(".//*[@id=':qv']", "You Pass the Test");
        sleepFor(1);
        clickByXpath(".//*[@id=':s7']");
        clickByXpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span");
        clickByCss("#gb_71");

        //typeByCss("#Email", "mdmsleepFor(2);
        /*owla01@gmail.com");
        clickByCss("#next");
        typeByCss("#Passwd", "masud8496%tonima");
        clickByCss("#signIn");
        sleepFor(2);

        */







    }
}