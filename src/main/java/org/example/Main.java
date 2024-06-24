package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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

        File uploadFile = new File("src/main/resources/file1.jpeg");
        File uploadFile2 = new File("src/main/resources/file2.txt");

        driver.manage().window().maximize();
        //Open Builder url
        driver.get("https://sendbird-uikit-react.netlify.app/url-builder");

        ArrayList<String> userData1 = registerUser(driver, appIdStr, 1);

        gotoTab(driver, 0); // zero based

        ArrayList<String> userData2 = registerUser(driver, appIdStr, 2);

        gotoTab(driver, 0);

        Thread.sleep(5000);

        createMessage(driver,1, userData2.getFirst());

        sendMessage(driver,null);
        sendMessage(driver,uploadFile);
        sendMessage(driver,uploadFile2);

        Thread.sleep(500);
        verifyMessage(driver,2,userData1.getLast());

        //driver.quit();
    }

    public void createMessage(WebDriver driver, int num, String userId) throws InterruptedException, IOException, UnsupportedFlavorException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        gotoTab(driver, num);

        WebElement newChat = driver.findElement(By.xpath("//div[@class=' sendbird-icon sendbird-icon-create sendbird-icon-color--primary']//*[name()='svg']"));
        newChat.click();

        WebElement newGroup = driver.findElement(By.xpath("//div[@class='sendbird-add-channel__rectangle']"));
        newGroup.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//label[contains(@for,'%s')]//span[contains(@class,'sendbird-checkbox--checkmark')]",userId))));

        WebElement userChat = driver.findElement(By.xpath(String.format("//label[contains(@for,'%s')]//span[contains(@class,'sendbird-checkbox--checkmark')]",userId)));
        // Javascript executor
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", userChat);
        Thread.sleep(800);
        userChat.click();

        WebElement createChat = driver.findElement(By.xpath("//button[contains(@class,'sendbird-button--primary sendbird-button--big')]"));
        createChat.click();
    }

    public void verifyMessage(WebDriver driver, int num, String userId) throws InterruptedException, IOException, UnsupportedFlavorException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        gotoTab(driver, num);

        //WebElement newChat = driver.findElement(By.xpath("//div[@class='sendbird-channel-preview__content__upper__header__channel-name sendbird-label sendbird-label--subtitle-2 sendbird-label--color-onbackground-1']"));
        WebElement newChat = driver.findElement(By.xpath(String.format("//span[[text()='%s']",userId)));
        newChat.click();

        WebElement newGroup = driver.findElement(By.xpath("//div[@class='sendbird-add-channel__rectangle']"));
        newGroup.click();
    }

    public void sendMessage(WebDriver driver, File uploadFile) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(5000);

        if (uploadFile != null){
            WebElement filepath = driver.findElement(By.cssSelector("input[type=file]"));
            filepath.sendKeys(uploadFile.getAbsolutePath());
        } else {
            WebElement test2 = driver.findElement(By.xpath("//div[@id='sendbird-message-input-text-field']"));
            test2.sendKeys("Hay");

            WebElement test = driver.findElement(By.xpath("//button[@data-testid='sendbird-message-input-send-button']"));
            test.click();
        }
    }

    public static String generateRandomUserId() {
        return "test_"+ (RandomStringUtils.randomAlphabetic(3))+"_"+(RandomStringUtils.randomNumeric(1));
    }

    public ArrayList<String> registerUser(WebDriver driver, String appIdStr, int num) throws InterruptedException, IOException, UnsupportedFlavorException {
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

        ArrayList<String> userData = new ArrayList<String>();
        userData.add(userId1);
        userData.add(nickname1);

        return userData;
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