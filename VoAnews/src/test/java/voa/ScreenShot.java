package voa;

import CommonApi.Base;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Masud on 9/18/2015.
 */
public class ScreenShot extends Base {

    @Test
    public void ScreeenShots() throws InterruptedException {
        clickByXpath(".//*[@id='header']/div/ul/li[7]/a");
        sleepFor(2);

        try {
            takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
