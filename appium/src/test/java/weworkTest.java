import app.page.wework.ContactPage;
import app.page.wework.MainPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author: gengqiang;
 * @date: 2020/11/25 0:26;
 * @description: 测试
 */

public class weworkTest {
    static MainPage mainPage;
    private static AppiumDriver<MobileElement> driver;
    ContactPage contactPage;

    @BeforeAll
    public static void beforeAll(){
        mainPage.initDriver();
    }

    @Test
    public void addMemberTest(){
        contactPage.addMember();
//        assertEquals(contactPage.get);
    }



}
