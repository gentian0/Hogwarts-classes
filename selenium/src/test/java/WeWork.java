import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WeWork {
    public static  WebDriver driver;

    static void needLogins() throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        //sleep 20
        Thread.sleep(20000);

        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);
    }

    @BeforeAll
    static void before() throws IOException, InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        File file = new File("cookies.yaml");
        if (file.exists()){
            driver.get("https://work.weixin.qq.com/wework_admin/frame");
            driver.manage().window().maximize();
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {};
            List<HashMap<String, Object>> cookies = mapper.readValue(file, typeReference);
            System.out.println(cookies);
            cookies.forEach(cookieMap-> driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString())));
            driver.navigate().refresh();
            }else {
            needLogins();
        }
    }
    @Test
    void addMember() throws InterruptedException {
        driver.findElement(By.linkText("添加成员")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("344");
        driver.findElement(By.name("acctid")).sendKeys("434");
        driver.findElement(By.name("mobile")).sendKeys("18900000023");
        driver.findElement(By.linkText("保存")).click();
    }
}

