package com.challenge.page;

import com.challenge.service.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CarsListResultPage {
    private DSL dsl;

    public CarsListResultPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public ArrayList<String> getCarsList() {
        List<WebElement> elements = dsl.getByXpathList("//div[@data-qaid='cntnr-listings-tier-listings']");

        ArrayList<String> car = new ArrayList<String>();
        for (WebElement element : elements) {
            String title = element.findElement(By.xpath("/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/a/h2")).getText();
            car.add(title);
        }
        return car;
    }

}
