
/**
 * Created by Masud on 9/17/2015.
 */

package CommonApi;

        import org.apache.commons.io.FileUtils;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.htmlunit.HtmlUnitDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;
        import org.openqa.selenium.interactions.Action;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.openqa.selenium.safari.SafariDriver;
        import org.openqa.selenium.support.ui.ExpectedCondition;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.annotations.*;

        import java.io.File;
        import java.io.IOException;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.concurrent.TimeUnit;


public class Base {

    public WebDriver driver = null;

    @Parameters({"useSauceLab","userName", "key","appUrl","os","browserName","browserVersion"})
    @BeforeMethod
    public void setUp(boolean useSauceLab,String userName,String key,String appUrl, String os,
                      String browserName,String browserVersion )throws IOException {

        if(useSauceLab == true){
            getSauceLabDriver(userName, key, os, browserName, browserVersion);
        }else{
            getLocalDriver(os, browserName);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(appUrl);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void cleanUp()throws InterruptedException{
        //  sleepFor(2);
        driver.quit();
    }
    //get local driver
    public WebDriver getLocalDriver(String os, String browserName){

        if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("chrome")){
            if(os.equalsIgnoreCase("windows")){
                System.setProperty("webdriver.chrome.driver","Generic\\selenium-browser-driver\\chromedriver.exe");
            }else{
                System.setProperty("webdriver.chrome.driver", "Generic/selenium-browser-driver/chromedriver");
            }
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }else if(browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","Generic\\selenium-browser-driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browserName.equalsIgnoreCase("htmlunit")){
            driver = new HtmlUnitDriver();
        }

        return driver;
    }

    //get cloud driver
    public WebDriver getSauceLabDriver(String userName, String key, String os, String browserName,
                                       String browserVersion )throws IOException{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browserName);
        cap.setCapability("version", browserVersion);

        driver = new RemoteWebDriver(new URL("http://"+ userName + ":" +  key +
                "@ondemand.saucelabs.com:80/wd/hub"), cap);

        return driver;
    }

    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void typeByCss(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.CLEAR);
    }
    public void typeByCssThenEnter(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.CLEAR, value,Keys.ENTER);
    }
    public void typeByXpath(String locator,String value){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void clickById(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public void clickByName(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public void navigateBack(){
        driver.navigate().back();
    }
    public void navigateForward(){
        driver.navigate().forward();
    }
    public String getTextByCss(String locator){
        String st = driver.findElement(By.cssSelector(locator)).getText();

        return st;
    }

    public String getTextByXpath(String locator){
        String st = driver.findElement(By.xpath(locator)).getText();

        return st;
    }
    public String getTextById(String locator){
        String st = driver.findElement(By.id(locator)).getText();

        return st;
    }
    public String getTextByName(String locator){
        String st = driver.findElement(By.name(locator)).getText();

        return st;
    }
    public WebElement getWebElementByCss(String locator){
        WebElement element = driver.findElement(By.cssSelector(locator));

        return element;
    }
    public List<WebElement> getWebElementsByCss(String locator){
        List<WebElement> elementList = new ArrayList<WebElement>();
        elementList = driver.findElements(By.cssSelector(locator));

        return elementList;
    }
    public WebElement getWebElementByXpath(String locator){
        WebElement element = driver.findElement(By.xpath(locator));

        return element;
    }

    //constant sleep time
    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(1000*sec);
    }

    //Synchronization
    public void waitUntilClickAble(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilSelectable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    //get WebElements
    public List<WebElement> getWebElements(String locator){
        List<WebElement> elements = driver.findElements(By.cssSelector(locator));
        return elements;
    }
    //get texts
    public List<String> getElementTexts(String  locator){
        List<String> texts = new ArrayList<String>();
        List<WebElement> element = new ArrayList<WebElement>();
        element = getWebElements(locator);
        for(WebElement st:element){
            texts.add(st.getText());
        }
        return texts;
    }

    //Keys
    public void clearInputBox(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void mouseHoverByCSS(String locator){
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }
    public void mouseHoverByXpath(String locator){
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }
    //handling Alert
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //iFrame Handle
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }

    //get Links
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    //Taking Screen shots
    public void takeScreenShot()throws IOException{
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenShots.png"));
    }

}
