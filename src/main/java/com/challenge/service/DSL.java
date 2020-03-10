package com.challenge.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DSL {
    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getByDescriptionFromTagName(String tagName, String text) {
        List<WebElement> listElement = driver.findElements(By.tagName(tagName));
        int i = listElement.size();
        for (int j = 0; j < i; j++) {
            if (text.equals(listElement.get(j).getText())) {
                return listElement.get(j);
            }
        }
        return null;
    }

    public WebElement getById(String id){
        return driver.findElement(By.id(id));
    }

    public WebElement getByXpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }

    public void setSelect(String id, String value){
        WebElement element = this.getById(id);
        Select combo = new Select(element);
        combo.selectByVisibleText(value);
    }

    public List<WebElement> getByXpathList(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }
}
