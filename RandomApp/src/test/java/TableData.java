import CommonApi.Base;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Masud on 9/18/2015.
 */
public class TableData extends Base{
    @Test
    public void table() throws InterruptedException {

        //List<WebElement> listOfTD = getWebElementsByXpath(".//*[@id='main']/div[4]");
        List<WebElement> listOfTD = getWebElementsByCss(".MsoTableGrid");
        for (int i=1; i<5; i++) {
            String data = getTextByXpath(".//*[@id='page_content']/table/tbody/tr[2]/td[2]/div/table/tbody/tr[2]/td["+i+"]/p");
            sleepFor(2);
            System.out.print(data+" ");
        }
    }

}
