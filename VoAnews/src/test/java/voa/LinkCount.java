package voa;

import CommonApi.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Masud on 9/18/2015.
 */
public class LinkCount extends Base {

    @Test
    public void testFindElements()
    {
        List<WebElement> links =driver.findElements(By.tagName("a"));
        int count=0;
        for(WebElement link : links) {
            count++;
            System.out.println(link.getAttribute("href"));

        }
        System.out.println("Total Link: "+count);



    }

}
