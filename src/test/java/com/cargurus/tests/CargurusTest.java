package com.cargurus.tests;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import utilities.ExcelUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utilities.Constant.*;

/**
 * CargurusTest Tester.
 *
 * @author Grigor Nikolov
 * @since <pre>Feb 02, 2019</pre>
 * @version 1.0
 */

@RunWith(Parameterized.class)
public class CargurusTest {

private static WebDriver driver;
    private String make;
    private String model;
    private String zip;

    @Before
    public void before() {
        System.setProperty(DRIVER_TYPE, DRIVER_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("/usr/bin/google-chrome-stable");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void after() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> spreadsheetData() throws IOException {
        return new ExcelUtils(new FileInputStream(PATH_TEST_DATA + FILE_TEST_DATA)).getData();
    }

    public CargurusTest(String make, String model, String zip) {
        super();
        this.make = make;
        this.model = model;
        this.zip = zip;
    }

    @Test
    public void testSearchResultForMatches() {
        driver.get(URL);
        new Select(driver.findElement(By.id(USED_MAKE_ID))).selectByVisibleText(make);
        new Select(driver.findElement(By.id(USED_MODEL_ID))).selectByVisibleText(model);
        driver.findElement(By.id(ZIP_ID)).sendKeys(zip);
        driver.findElement(By.id(SUBMIT_ID)).click();
        List<WebElement> resultList = driver.findElements(By.xpath(RESULT_XPATH));
        boolean matchAll = true;
        for (WebElement we : resultList) {
            if(!(we.getText().contains(make) && we.getText().contains(model))) {
                matchAll = false;
            }
        }
        Assert.assertTrue(matchAll);
    }
}