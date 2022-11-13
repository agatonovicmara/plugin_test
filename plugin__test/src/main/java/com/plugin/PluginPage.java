package com.plugin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PluginPage {

    private WebDriver driver;
    public PluginPage(WebDriver driver) {this.driver=driver;}

    public WebElement getPluginBtn(){
        return driver.findElement(By.xpath("//div[@class='sc-kHNMoK eXomOH']"));
    }

    public void waitFirstMsg(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-iktFzd')]")));
    }
    public WebElement getFirstMsg(){
        return driver.findElement(By.xpath("//div[contains(@class, 'sc-iktFzd')]"));
    }
    public WebElement getTxtInput(){
        return driver.findElement(By.xpath("//div[contains(@class, 'sc-fHYxKZ')]/span"));
    }

    public WebElement getResponse(){
        return driver.findElement(By.xpath("//div[contains(@class, 'myResponeHolder')]//p"));
    }

    public WebElement getSendBttn(){
        return driver.findElement(By.xpath("//div[contains(@class, 'sc-gkdzZj')]"));
    }

    public WebElement getResponseVideo(){
        return driver.findElement(By.xpath("//p[text()='I found a good video for you.']"));
    }
    public void waitResponseYT(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='I found a good video for you.']")));
    }


    public WebElement getResponseImage(){
        return driver.findElement(By.xpath( "//p[text()='Here is the coffee of the month!']"));
    }

    public void waitRedirection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/highlight_page_two.html"));
    }

    public WebElement getResponseButton(){
        return driver.findElement(By.xpath( "//div[contains(@class, 'dUuiwJ')]/div"));
    }

    public void waitResponseBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'dUuiwJ')]/div")));
    }


    public void waitHighlighedDiv(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class= 'giftTitle']")));
    }

    public WebElement getResponseHighlight(){
        return driver.findElement(By.xpath( "//div[@class= 'giftTitle']"));
    }

    public WebElement getResponseFallback(){
        return driver.findElement(By.xpath( "//div[text()='I cannot provide a good answer for this now. Can you rephrase your request?']"));
    }


}
