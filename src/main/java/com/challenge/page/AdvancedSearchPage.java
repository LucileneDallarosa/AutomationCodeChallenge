package com.challenge.page;

import com.challenge.service.DSL;
import org.openqa.selenium.WebDriver;

public class AdvancedSearchPage {
    private DSL dsl;

    public AdvancedSearchPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void setZipCode(String zipCode){
        dsl.getById("zipundefined").sendKeys(zipCode);
    }

    public void setConditionCertified(){
        dsl.getByXpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div[1]/form/div[3]/div/div[2]/div/div/div/div[3]/label/div").click();
    }

    public void setStyleConvertible(){
        dsl.getByXpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div[1]/form/div[5]/div/div[2]/div/div/div[1]/label[1]/div[1]").click();
    }

    public void setYearFrom(String year){
        dsl.setSelect("4101482096", year);
    }

    public void setYearTo(String year){
        dsl.setSelect("258002540", year);
    }

    public void setMark(String mark){
        dsl.setSelect("1970425032", mark);
    }

    public void clickButtonSearch(){
        dsl.getByXpath("//*[@id=\"mountNode\"]/div/div[1]/div/div/div[1]/form/div[15]/div/div/button").click();
    }
}
