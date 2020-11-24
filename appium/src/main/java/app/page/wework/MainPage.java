package app.page.wework;

import app.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * @author: gengqiang;
 * @date: 2020/11/24 21:56;
 * @description: 主页面
 */

public class MainPage extends BasePage {
    public MainPage(AppiumDriver<MobileElement> driver){
        super(driver);
    }
    public void initDriver(){
        new BasePage("com.tencent.wework",".launch.WwMainActivity");
    }

    @AndroidFindBy(uiAutomator = "resourceId=\"com.tencent.wework:id/egd\", text=\"通讯录\"")
    private WebElement contactBrn;

    public ContactPage contact(){
        click(contactBrn);
        return new ContactPage(driver);
    }
}
