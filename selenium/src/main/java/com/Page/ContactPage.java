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
    private final By partyInfo=By.cssSelector(".js_party_info");

    //======================================部门============================================

    private final By addBtn = By.linkText("添加");
    private final By createDepartment = By.linkText("添加部门");
    private final By departmentList = By.linkText("选择所属部门");
    private final By createDepartmentName = By.name("name");
    private final By departmentTreeAnchor = By.linkText("上海组");
    private final By createConfirm = By.linkText("确定");

    //======================================搜索============================================

    private final By memberSearchInput = By.id("memberSearchInput");
    private final By searchPartyList = By.id("search_party_list");;

    public DepartmentPage(WebDriver driver){
        super(driver);
    }

    public DepartmentPage newDepartment(String departmentName){
        click(addBtn);
        click(createDepartment);
        sendKeys(createDepartmentName, departmentName);
        click(departmentList);
        driver.findElements(departmentTreeAnchor).get(1).click();
        click(createConfirm);

        return this;
    }
    public String getPartyInfo(){
        String content = driver.findElement(partyInfo).getText();
        System.out.println(content);
        return content;
    }

    public DepartmentPage search(String departName){
        click(memberSearchInput);
        sendKeys(memberSearchInput, departName);
        String content = driver.findElement(searchPartyList).getText();
        System.out.println(content);
        return this;
    }


}
