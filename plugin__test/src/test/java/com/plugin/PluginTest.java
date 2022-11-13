package com.plugin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PluginTest extends BasicTest{

    @Test (priority = 10)
    public void openPlugin(){

        plugin.getPluginBtn().click();


        Assert.assertTrue(
                plugin.getTxtInput().isDisplayed(),
                "ERROR: 'Welcome message should be displayed'"
        );

    }

    @Test (priority = 20)

    public void text() throws InterruptedException {

        plugin.getPluginBtn().click();
        plugin.getTxtInput().sendKeys("Hello");
        Thread.sleep(1000);
        plugin.getSendBttn().click();

        Assert.assertTrue(
                plugin.getResponse().getText().contains("Hi"),
                "ERROR, message is not correct");



    }

    @Test (priority = 30)

    public void video() throws InterruptedException {
        plugin.getPluginBtn().click();
        plugin.getTxtInput().sendKeys("how to brew v-60");
        Thread.sleep(1000);
        plugin.getSendBttn().click();

        Assert.assertTrue(
                plugin.getResponseVideo().isDisplayed(),
                "ERROR, YT video is not displayed!");

    }

    @Test (priority = 40)

    public void image() throws InterruptedException {
        plugin.getPluginBtn().click();
        plugin.getTxtInput().sendKeys("show the coffee of the month");
        Thread.sleep(1000);
        plugin.getSendBttn().click();

        Assert.assertTrue(
                plugin.getResponseImage().isDisplayed(),
                "ERROR, coffee of the month is not displayed!");

    }


    @Test (priority = 60)

    public void button() throws InterruptedException {
        plugin.getPluginBtn().click();
        plugin.getTxtInput().sendKeys("buy gift card");
        Thread.sleep(1000);
        plugin.getSendBttn().click();

        plugin.waitResponseBtn();

        Assert.assertEquals(
                plugin.getResponseButton().getText(),
                "Buy gift card",
                "ERROR, button not displayed");

    }

    @Test (priority = 70)

    public void highlight() throws InterruptedException {
        plugin.getPluginBtn().click();
        plugin.getTxtInput().sendKeys("what is boxes");
        Thread.sleep(1000);
        plugin.getSendBttn().click();

        plugin.waitHighlighedDiv();

        Assert.assertEquals(plugin.getResponseHighlight().getText(),
                "Here!",
                "ERROR!");

    }
    @Test (priority = 80)

    public void redirect() throws InterruptedException {
        plugin.getPluginBtn().click();
        plugin.getTxtInput().sendKeys("tell me about coffeevine");
        Thread.sleep(1000);
        plugin.getSendBttn().click();

        plugin.waitRedirection();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/highlight_page_two.html"),
                "ERROR, not redirected");

    }

    @Test (priority = 90)
    public void fallback() throws InterruptedException {

        plugin.getPluginBtn().click();
        plugin.getTxtInput().sendKeys("x");
        Thread.sleep(1000);
        plugin.getSendBttn().click();

        Assert.assertTrue(
                plugin.getResponseFallback()
                        .getText()
                        .contains("I cannot provide a good answer for this now. " +
                                "Can you rephrase your request?"),
                "ERROR"
        );

    }

}
