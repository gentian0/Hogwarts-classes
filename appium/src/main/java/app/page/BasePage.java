package app.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Author: kong
 * @Date: 2020/11/24 15:16
 * @Description: 封装appium
 */

public class BasePage {
    public AppiumDriver driver;
    public WebDriverWait wait;
    String appPackage;
    String appActivity;


    public BasePage(String appPackage,String appActivity){
        this.appPackage = appPackage;
        this.appActivity = appActivity;
        startApp(this.appPackage,this.appActivity);
    }
    public BasePage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 60);
    }

    public void startApp(String appPackage,String appActivity){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName","gentian");
        caps.setCapability("appPackage", appPackage);
        caps.setCapability("appActivity", appActivity);
        caps.setCapability("noReset","true");
        caps.setCapability("udid", "");
        caps.setCapability("dontStopAppOnReset", "true");
        caps.setCapability("skipLogcatCapture","true");

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(url, caps);
        implicitlyWait(60);
    }

    public void implicitlyWait(int time) {
        driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
    }

    public void scroll(WebElement element){
        implicitlyWait(3);
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        long startTime = System.currentTimeMillis();

        while (true){
            if (!element.isDisplayed()){
                getTouchAction().moveTo(PointOption.point(startX, startY - 50)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)));
                long endTime = System.currentTimeMillis();
                if ((endTime - startTime) > 60*1000){
                    break;
                }
            }else {
                break;
            }
        }
        implicitlyWait(5);
    }

    private TouchAction getTouchAction() {
        return new TouchAction(driver);
    }


    void click(WebElement element, boolean scroll){
        if (scroll){
            scroll(element);
        }
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void click(WebElement element){
        click(element,false);
    }

    public void sendKey(WebElement element, String keywords){
        if (element.isDisplayed()){
            element.clear();
            element.sendKeys(keywords);
        }else {
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keywords);
        }

    }



}
