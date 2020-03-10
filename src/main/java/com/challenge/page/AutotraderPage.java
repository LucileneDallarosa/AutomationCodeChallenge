package com.challenge.page;

import com.challenge.service.DSL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutotraderPage {
    private DSL dsl;

    public AutotraderPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void closeBanner(){
        dsl.getByDescriptionFromTagName("button","Continue to Autotrader").click();
    }

    public boolean validLinkBrowseByMake() {
        WebElement linkBrowseByMake = dsl.getByDescriptionFromTagName("span","Browse by Make");
        return linkBrowseByMake != null;
    }

    public boolean validLinkBrowseByStyle() {
        WebElement linkBrowseByStyle = dsl.getByDescriptionFromTagName("span","Browse by Style");
        return linkBrowseByStyle != null;
    }

    public boolean validLinkAdvancedSearch() {
        WebElement linkAdvancedSearch = dsl.getByDescriptionFromTagName("a","Advanced Search");
        return linkAdvancedSearch != null;
    }

    public void clickAdvancedSearch() {
        WebElement linkAdvancedSearch = dsl.getByDescriptionFromTagName("a","Advanced Search");
        linkAdvancedSearch.click();
    }

    public boolean validButtonSearch(){
        try {
            dsl.getById("search");
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean validDropDownMake(){
        try {
            dsl.getById("makeCodeListPlaceHolder");
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean validDropDownModel(){
        try {
            dsl.getById("modelCodeListPlaceHolder");
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
