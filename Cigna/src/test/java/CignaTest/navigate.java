package CignaTest;

import CommonApi.Base;
import org.testng.annotations.Test;

/**
 * Created by Masud on 9/20/2015.
 */
public class navigate extends Base {
    @Test
    public void navigatecigna() throws InterruptedException {
        clickByXpath(".//*[@id='1386067114266']/div/header/div/div[2]/nav/ul/li[1]/a");
        sleepFor(2);
        //clickByXpath(".//*[@id='1410174722402']/div/header/div/div[2]/nav/ul/li[1]/div/div/div[2]/ul/li[2]/a/div");
        //sleepFor(2);

    }
}
