package CignaTest;

import CommonApi.Base;
import org.testng.annotations.Test;

/**
 * Created by Masud on 9/20/2015.
 */
public class GlobalProducts extends Base {
    @Test

    public void global() throws InterruptedException {
        clickByCss(".international>a>span");
        sleepFor(2);
        clickByCss(".cigna-color-white");
        sleepFor(2);


    }
}
