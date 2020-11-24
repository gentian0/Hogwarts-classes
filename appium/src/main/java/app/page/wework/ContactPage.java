package app.page.wework;


import app.page.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

/**
 * @Author: kong
 * @Date: 2020/11/24 15:50
 * @Description: 通讯录
 * 添加成员
 * 搜索并更新成员更新
 * 成员删除
 */

public class ContactPage extends BasePage {
    public ContactPage(AppiumDriver<MobileElement> driver){
        super(driver);

    }

//----------------------------------添加成员----------------------------------

    @AndroidFindBy(xpath = "//*[text=\"添加成员\"]")
    private WebElement addMembersBtn;

    @AndroidFindBy(xpath = "//*[@text=\"手动输入添加\"]")
    private WebElement manualAddBtn;

    @AndroidFindBy(xpath = "//*[@text=\"姓名　\"]/..//*[@resource-id=\"com.tencent.wework:id/b4t\"]")
    private WebElement memberName;

    @AndroidFindBy(id = "com.tencent.wework:id/fow")
    private WebElement phone;

    @AndroidFindBy(uiAutomator = "resourceId(\"com.tencent.wework:id/b5m\").text(\"设置部门\")")
    private WebElement setDepartBtn;

    @AndroidFindBy(xpath = "//*[@text=\"上海组\"]/../../..//*[@resource-id==\"com.tencent.wework:id/gsi\"]")
    private WebElement departGsi;

    @AndroidFindBy(id = "com.tencent.wework:id/gsh")
    private WebElement confirmBtn;

    @AndroidFindBy(id = "com.tencent.wework:id/i6k")
    private WebElement savaBtn;

    @AndroidFindBy(id = "com.tencent.wework:id/i63")
    private WebElement backBtn;




    public  ContactPage addMember(){
        click(addMembersBtn);
        click(manualAddBtn);
        sendKey(memberName,"sString");
        sendKey(phone,"18012635497");
        click(setDepartBtn);
        click(departGsi);
        click(confirmBtn);
        click(savaBtn);
        return this;
    }

}
