package com.plugin;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BasicTest {

    protected WebDriver driver;
    protected String baseUrl= "https://plugins.gigaaa.com/global/test/highlight_page_one.html";

    protected PluginPage plugin;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        plugin = new PluginPage(driver);

    }


    @BeforeMethod
    public void beforeMethod() {

        driver.get(baseUrl);

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}



