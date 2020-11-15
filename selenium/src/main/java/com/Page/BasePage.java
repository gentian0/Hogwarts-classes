package com.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author: gengqiang;
 * @date:" 2020/11/15;
 * @description: 封装selenium基本使用方法
 */

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver=driver;
    }

    public BasePage() {
    }

    void click(By by) {
        driver.findElement(by).click();
    }

    void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }
}
