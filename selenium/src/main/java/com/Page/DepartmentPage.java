package com.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author: gengqiang;
 * @date:" 2020/11/15;
 * @description: 页面元素定位：
 * - 新建部门
 * - 搜索部门
 * - 更新部门
 * - 更新成员信息
 * - 参数化
 */

public class DepartmentPage extends BasePage{
    public DepartmentPage(WebDriver driver){
        super(driver);
    }
    public DepartmentPage newDepartment(String departmentName){
        click(By.linkText("添加"));
        click(By.linkText("添加部门"));
        sendKeys(By.name("name"), departmentName);


        return this;
    }


}
