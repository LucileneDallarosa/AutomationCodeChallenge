package com.challenge.teste;

import com.challenge.page.AdvancedSearchPage;
import com.challenge.page.AutotraderPage;
import com.challenge.page.CarsListResultPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class AutotraderTest {
    private WebDriver driver;
    private AutotraderPage autotraderpage;
    private AdvancedSearchPage advancedSearchPage;
    private CarsListResultPage carsListResultPage;

    @Before
    public void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.autotrader.com/");

        autotraderpage = new AutotraderPage(driver);
        advancedSearchPage = new AdvancedSearchPage(driver);
        carsListResultPage = new CarsListResultPage(driver);
        driver.switchTo().activeElement();
        autotraderpage.closeBanner();
    }

    @After
    public void end(){
        driver.quit();
    }

    @Test
    public void validLinkBrowseByMake(){
        Assert.assertTrue(autotraderpage.validLinkBrowseByMake());
    }

    @Test
    public void validLinkBrowseByStyle(){
        Assert.assertTrue(autotraderpage.validLinkBrowseByStyle());
    }

    @Test
    public void validLinkAdvancedSearch(){
        Assert.assertTrue(autotraderpage.validLinkAdvancedSearch());
    }

    @Test
    public void validButtonSearch(){
        Assert.assertTrue(autotraderpage.validButtonSearch());
    }

    @Test
    public void validDropDownMake(){
        Assert.assertTrue(autotraderpage.validLinkBrowseByMake());
    }

    @Test
    public void validDropDownModel(){
        Assert.assertTrue(autotraderpage.validDropDownModel());
    }

    @Test
    public void advancedSearchTest(){
        autotraderpage.clickAdvancedSearch();
        advancedSearchPage.setZipCode("30004");
        advancedSearchPage.setConditionCertified();
        advancedSearchPage.setStyleConvertible();
        advancedSearchPage.setYearFrom("2017");
        advancedSearchPage.setYearTo("2020");
        advancedSearchPage.setMark("BMW");
        advancedSearchPage.clickButtonSearch();

        //Verify Results
        ArrayList<String> cars = carsListResultPage.getCarsList();

        ArrayList<String> carBMW = new ArrayList<String>();
        for(String car:cars) {
            if (car.contains("BMW")){
                carBMW.add(car);
            }
        }

        Assert.assertEquals(cars.size(), carBMW.size());
        System.out.println(carBMW.size());
    }

}
