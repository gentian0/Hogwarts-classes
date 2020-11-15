package com.Page;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author: gengqiang;
 * @date:" 2020/11/15;
 * @description:
 */
public class MainPage extends BasePage {

    void needLogin() throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        Thread.sleep(300000);
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"), cookies);
        System.exit(0);
    }

    void beforeAll() throws InterruptedException, IOException {
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
            needLogin();
        }
    }

    public MainPage() throws InterruptedException, IOException {
        this.beforeAll();
    }

    public DepartmentPage contact(){
        click(By.id("menu_contacts"));
        return new DepartmentPage(driver);
    }



}
