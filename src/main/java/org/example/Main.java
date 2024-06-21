package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.*;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.Keys;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    @Test
    public void login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions dragger = new Actions(driver);

        driver.manage().window().maximize();
        //Open Traveloka link
        driver.get("https://www.traveloka.com/id-id");

        //Click rental mobil
        WebElement carSelect = By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div/div/div[6]/div/div[2]").findElement(driver);
        carSelect.click();

        Thread.sleep(2000);

        //Click tanpa supir
        WebElement withoutDriver = By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h4:nth-child(3)").findElement(driver);
        withoutDriver.click();

        //Fill pickup location
        WebElement location = By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/input").findElement(driver);
        location.click();
        location.sendKeys("Jakarta");
        Thread.sleep(3000);
        WebElement locationSelect = By.xpath("//div[@aria-label='Jakarta']//h3[@role='heading']").findElement(driver);
        locationSelect.click();

        js.executeScript("window.scrollBy(0,250)", "");

        WebElement pickUp = By.xpath("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]").findElement(driver);
        pickUp.click();
        String pattern = "dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        int dateInt = Integer.parseInt(date) + 4 + 2;

        String datePath = String.format("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[3]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[3]/div[%s]",String.valueOf(dateInt));
        Thread.sleep(2000);

        WebElement pickUpSelect = By.xpath(datePath).findElement(driver);
        Thread.sleep(2000);
        pickUpSelect.click();

        //WebElement pickUpHoursSelect = By.xpath("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/div[1]/input[1]").findElement(driver);
        //pickUpHoursSelect.click();

        WebElement pickDown = By.xpath("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[1]/input[1]").findElement(driver);
        pickDown.click();

        int dateOutInt = Integer.parseInt(date) + 4 + 5;

        String dateOutPath = String.format("/html[1]/body[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[%s]",String.valueOf(dateOutInt));
        Thread.sleep(2000);

        WebElement pickDownSelect = By.xpath(dateOutPath).findElement(driver);
        Thread.sleep(2000);
        pickDownSelect.click();

        WebElement search = By.xpath("//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-61z16t']//*[name()='svg']").findElement(driver);
        search.click();

        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement provider = By.xpath("//*[@id=\"__next\"]/div/div[5]/div[2]/div[1]/div[1]/div[8]/div[1]").findElement(driver);
        provider.click();

        Thread.sleep(2000);
        WebElement providerSelect = By.xpath("//body/div[@id='__next']/div[@class='css-1dbjc4n r-1ihkh82']/div[@class='css-1dbjc4n r-1kihuf0 r-169s5xo r-uwe93p r-136ojw6']/div[@class='css-1dbjc4n r-1wzrnnt']/div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1ifxtd0 r-1g40b8q']/div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1h0z5md']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-vmmdp4 r-1addiju r-nvplwv r-14lw9ot r-kdyh1x r-b4qz5r r-6koalj r-1d2f490 r-ek4qxl r-1udh08x r-95jzfe r-u8s1d r-9dmdro']/div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-1s2bzr4 r-1pxuy4t r-11yh6sk r-1rnoaur r-1sncvnh']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-ymttw5 r-1f1sjgu']/div[1]/div[1]").findElement(driver);
        providerSelect.click();
        provider.click();

        Thread.sleep(2000);
        WebElement carSelection = By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[3]/div").findElement(driver);
        carSelection.click();

        js.executeScript("window.scrollBy(0,250)", "");
        WebElement carNext = By.xpath("/html/body/div[1]/div/div[5]/div/div[4]/div/div[2]/div[2]/div[1]").findElement(driver);
        carNext.click();

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement carNextAgain = By.xpath("/html/body/div[1]/div/div[5]/div/div[3]/div[2]/div/div[2]/div/div[1]/div[3]").findElement(driver);
        carNextAgain.click();

        js.executeScript("window.scrollBy(0,1200)", "");
        Thread.sleep(5000);
        WebElement pickUpLoc = By.xpath("//*[@id=\"RENTAL_PICKUP_LOCATION\"]/div/div/div[3]/div[1]/div[2]/div/div/div[2]").findElement(driver);
        pickUpLoc.click();

        WebElement pickUpLocNext = By.xpath("//*[@id=\"RENTAL_PICKUP_LOCATION\"]/div/div/div[3]/div[2]/div/div/div[1]/div[1]/div").findElement(driver);
        pickUpLocNext.click();

        Thread.sleep(1000);
        WebElement pickUpLocFinal = By.xpath("//*[@id=\"RENTAL_PICKUP_LOCATION\"]/div/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div[1]").findElement(driver);
        pickUpLocFinal.click();

        js.executeScript("window.scrollBy(0,250)", "");

        Thread.sleep(5000);
        WebElement pickOutLocFinal = By.xpath("/html/body/div[1]/div/div[5]/div/div[1]/div/div[3]/div[2]/div/div/div[5]/div[1]/div[2]/div").findElement(driver);
        pickOutLocFinal.click();

        WebElement pickOutLocInput = By.xpath("//*[@id=\"RENTAL_DROPOFF_LOCATION\"]/div/div/div[5]/div[2]/div/div/div[1]/div/div[1]/input").findElement(driver);
        pickOutLocInput.click();

        WebElement pickOutLocNow = By.xpath("/html/body/div[1]/div/div[5]/div/div[1]/div/div[3]/div[2]/div/div/div[5]/div[2]/div/div/div[1]/div/div[2]/div/div/div/div[3]").findElement(driver);
        pickOutLocNow.click();

        js.executeScript("window.scrollBy(0,350)", "");
        WebElement nextFinal = By.xpath("//*[@id=\"__next\"]/div/div[5]/div/div[1]/div/div[5]/div[3]/div").findElement(driver);
        nextFinal.click();

        js.executeScript("window.scrollBy(0,250)", "");
        WebElement pemesan = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div[1]/input").findElement(driver);
        pemesan.click();
        pemesan.sendKeys("tester");

        WebElement phone = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[1]/input").findElement(driver);
        phone.click();
        phone.sendKeys("82282828282");

        WebElement mail = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div[1]/input").findElement(driver);
        mail.click();
        mail.sendKeys("test@gmail.com");

        js.executeScript("window.scrollBy(0,250)", "");
        WebElement titel = By.xpath("//*[@id=\"adultForm0\"]/div/div/div[2]/div[1]/div/div/select").findElement(driver);
        titel.click();
        titel.sendKeys(Keys.DOWN);
        titel.sendKeys(Keys.RETURN);

        WebElement driverName = By.xpath("//*[@id=\"adultForm0\"]/div/div/div[2]/div[2]/div/div[1]/input").findElement(driver);
        driverName.click();
        driverName.sendKeys("Driver test");

        WebElement driverPhone = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/input[1]").findElement(driver);
        driverPhone.click();
        driverPhone.sendKeys("82282828283");

        WebElement nextAgain = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[4]/div/div/div").findElement(driver);
        nextAgain.click();

        Thread.sleep(5000);

        js.executeScript("window.scrollBy(0,500)", "");
        WebElement specialRequest = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[9]/div/div/div[3]/div[1]/textarea").findElement(driver);
        specialRequest.click();
        specialRequest.sendKeys("Special Request");

        WebElement syarat = By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[1]/div[11]/div/div/div/div[2]").findElement(driver);
        syarat.click();
        WebElement all = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]").findElement(driver);
        all.click();
        WebElement scroll = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]").findElement(driver);
        scroll.sendKeys(Keys.PAGE_DOWN);
        WebElement save = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div[2]/div[1]").findElement(driver);
        save.click();

        js.executeScript("window.scrollBy(0,500)", "");
        WebElement proceed = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[14]/div[1]/div[1]/div[1]/div[2]/div[1]").findElement(driver);
        proceed.click();

        Thread.sleep(500);
        WebElement nextProcess = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div[3]/div[2]").findElement(driver);
        nextProcess.click();
        Thread.sleep(5000);

        WebElement transfer = By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/div/div/div[3]/div/div").findElement(driver);
        transfer.click();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,1000)", "");

        WebElement finalTransfer = By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div[7]/div[2]/div[2]/div").findElement(driver);
        finalTransfer.click();
    }
}