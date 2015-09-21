package voa;

import CommonApi.Base;
import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by Masud on 9/17/2015.
 */
public class LogIn extends Base {
    @Test
    public void logIn()throws InterruptedException{
        clickByCss("#login-trigger");
        WebElement element = getWebElementByCss(".fancybox-iframe");
        iframeHandle(element);
        //WebElement innerFrame = getWebElementByCss("#fancybox-frame1442541498160");
        //iframeHandle(innerFrame);
        // typeByCss(".input_password","mdmowla01@yahoo.com");
        sleepFor(2);
        typeByCss(".input_text", "mdmowla01@yahoo.com");

        sleepFor(2);




        //typeByCss(".input_password","masud8496");
        typeByCss(".input_password", "masud8496");
        sleepFor(2);
        clickByCss(".input_submit");

       /* try {
            takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        sleepFor(3);

        driver.switchTo().defaultContent();
    }

}

