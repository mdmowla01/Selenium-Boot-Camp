package CnnNews;

import CommonApi.Base;
import org.testng.annotations.Test;
import util.DataReader;

import java.io.IOException;

/**
 * Created by Masud on 9/20/2015.
 */
public class Search extends Base {

    DataReader dr=new DataReader();
    String path="Cnn\\Data\\file1.xls";



    @Test
    public void SearchItems() throws IOException
    {
        String[][] itemLocator= dr.fileReader(path);
        for(int i=1;i<itemLocator.length;i++)
        {
            typeByCssThenEnter(itemLocator[i][0], itemLocator[i][1]);
            //clickByCss("#search_loupe_bt");
            //sleepFor(1);
            /*try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


        }

    }
}
