package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;
import java.awt.datatransfer.*;
import java.awt.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    @Test
    public void register() throws InterruptedException, IOException, UnsupportedFlavorException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions dragger = new Actions(driver);

        String appIdStr = "37C8DB25-8B44-435F-A528-5BA9B9965FD0";

        driver.manage().window().maximize();
        //Open Builder url
        driver.get("https://sendbird-uikit-react.netlify.app/url-builder");

        registerUser(driver, appIdStr, 1);

        gotoTab(driver, 0); // zero based

        registerUser(driver, appIdStr, 2);

        Thread.sleep(5000);

        driver.quit();
    }

    public static String generateRandomUserId() {
        return "test_"+ (RandomStringUtils.randomAlphabetic(3))+"_"+(RandomStringUtils.randomNumeric(1));
    }

    public void registerUser(WebDriver driver, String appIdStr, int num) throws InterruptedException, IOException, UnsupportedFlavorException {
        //Input appId
        WebElement appId = By.xpath("//input[@name='appId']").findElement(driver);
        appId.clear();
        appId.sendKeys(appIdStr);

        //Input userId1
        WebElement userId = By.xpath("//input[@name='userId']").findElement(driver);
        String userId1 = generateRandomUserId();
        userId.clear();
        userId.sendKeys(userId1);

        //Input nickname1
        WebElement nickname = By.xpath("//input[@name='nickname']").findElement(driver);
        String nickname1 = userId1.substring(5,10);
        nickname.clear();
        nickname.sendKeys(nickname1);

        WebElement copy = By.xpath("//button[@class='sticky-bottom-button']").findElement(driver);
        copy.click();

        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();

        // Open new tab for userId1
        openNewTab(driver);
        gotoTab(driver, num); // zero based
        driver.get(c.getData(DataFlavor.stringFlavor).toString());
    }

    public void openNewTab(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('');");
        Thread.sleep(100);
    }

    public void gotoTab(WebDriver driver, int tabIndex) throws InterruptedException {
        List<String> winHandles = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(500);
        driver.switchTo().window(winHandles.get(tabIndex));
    }
}