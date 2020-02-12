package org.example;

import com.google.common.annotations.VisibleForTesting;
import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class WebExercise1 {
    static protected WebDriver driver;

    //Before method
    @Before
    public void openBrwser() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    // After method
     @After
     public void closeBrowser() {
       driver.quit();

     }

    //time stamp method
    public String timeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("ddmmyyhhmmss");
        Date date = new Date();
        return (dateFormat.format(date));

    }

    //wait for click on element method
    public void clickOnElelement(By by) {
        driver.findElement(by).click();

    }

    //wait for clickable method
    public void waitForClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //wait for visibility method
    public void waitForVisibility(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //wait for Elements is present method
    public void waitForElementsIsPresent(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    //enter text method
    public void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
        waitForClickable(by, 60);

    }

    //get text from element method
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();

    }

    //select from dropdown by value method
    public void selectFromDropdownByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    //select from dropdown by visible text method
    public void selectFromDropdownByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    //select from dropdown by index method
    public void selectFromDropdownByIndex(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }


    @Test
    //register successfully
    public void userShouldAbleToRegisterSuccessfully() {
         // type URL
        driver.get("https://demo.nopcommerce.com/");
        //click on register
        clickOnElelement(By.linkText("Register"));
        //wait for element
        waitForClickable(By.id("register-button"), 70);
        //wait for element to clickable
        waitForClickable(By.id("FirstName"), 50);
        //enter your name
        enterText(By.id("FirstName"), "mansi");
        //enter your last name
        enterText(By.id("LastName"), "shah");
        //select date of birth from dropdown
        selectFromDropdownByValue(By.name("DateOfBirthDay"), "11");
        //select date of birth month from dropdown
        selectFromDropdownByIndex(By.name("DateOfBirthMonth"), 2);
        //select date of birth year from dropdown
        selectFromDropdownByVisibleText(By.name("DateOfBirthYear"), "1981");
        //enter your email Id
        enterText(By.id("Email"), "mshah6135+" + timeStamp() + "@gmail.com");
        //enter your password
        enterText(By.id("Password"), "Shah123");
        //enter your confirm password
        enterText(By.id("ConfirmPassword"), "Shah123");
        //click on register
        clickOnElelement(By.id("register-button"));
        // register successfully
        getTextFromElement(By.className("result"));
        //display expected and actual result
        String expected = "Your registration successfully";
        String actual = getTextFromElement(By.className("result"));
        Assert.assertEquals("Fail", expected, actual);
    }
    @Test
    public void orangeHarm() {
        // type URL
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //enter user name
        enterText(By.id("txtUsername"), "Admin");
        //enter password
        enterText(By.id("txtPassword"), "admin123");
        // click on login successfully
        clickOnElelement(By.name("Submit"));
        //wait for elements
        waitForElementsIsPresent(By.cssSelector("a.panelTrigger"), 70);
        // display expected and actual result
        String expected = "Welcome";
        String actual = getTextFromElement(By.cssSelector("a.panelTrigger"));
        Assert.assertEquals("Fail", expected, actual);
    }
    @Test
    public void Website_com() {
         // type URL
        driver.get("https://www.website.com/sign-in/");
        //wait for element
        waitForClickable(By.id("signin-submit2"), 60);
        //enter user name
        enterText(By.id("username"), "Bimal");
        //enter password
        enterText(By.id("password"), "B123");
        //click on login
        clickOnElelement(By.id("signin-submit2"));
        //display expected and actual result
        String expected = "valid Login.";
        String actual = getTextFromElement(By.className("errorMsg"));
        Assert.assertEquals("Fail", expected, actual);
    }
    @Test
    public void mockplus() {
        // type URL
        driver.get("https://www.mockplus.com/");
        //click on register
        clickOnElelement(By.className("user-btn"));
        //enter email
        enterText(By.id("email"), "patelradha11+" + timeStamp() + "@test.com");
        //enter password
        enterText(By.id("password"), "patel123");
        //enter conform password
        enterText(By.id("cofPassword"), "patel123");
        //click on terms
        clickOnElelement(By.id("agree"));
        //click on register successfully
        clickOnElelement(By.id("register"));
        // display expected and actual result
        String expected = "Welcome to Mockplus";
        String actual = getTextFromElement(By.className("logo"));
        Assert.assertEquals("Fail", expected, actual);
    }
    @Test
    public void Ocado() {
         // type URL
        driver.get("https://www.ocado.com/webshop/startWebshop.do");
        //click on register
        clickOnElelement(By.id("quickReg"));
        //wait for element
        waitForClickable(By.id("registration-submit-button"), 50);
        //select title from dropdown
        selectFromDropdownByVisibleText(By.id("title"), "Mr");
        //enter first name
        enterText(By.id("firstName"), "raj");
        //enter last name
        enterText(By.id("lastName"), "patel");
        //enter email id
        enterText(By.id("login"), "raj15+" + timeStamp() + "@gmail.com");
        //enter password
        enterText(By.id("password"), "patel11");
        //enter your postcode
        enterText(By.id("postcode"), "UB5 7SA");
        // click on register successfully
        clickOnElelement(By.id("registration-submit-button"));
        // display expected and actul result
        String expected = "Ocado";
        String actual = getTextFromElement(By.cssSelector("a.primary-bar-link"));
        Assert.assertEquals("Fail", expected, actual);
    }
    @Test
    public void Asda (){
        //type URL
        driver.get("https://groceries.asda.com/?cmpid=ppc-_-ghs-_--_-google-_-asda-_-dskwid-s43700013662392458_dc");
        //click on register
        clickOnElelement(By.linkText("Register"));
        //enter your email id
        enterText(By.xpath("//input[@type='email']"),"raj15+"+ timeStamp() + "@gmail.com");
        //enter your password
        enterText(By.xpath("//input[@type='password']"),"patel11");
        //enter your postcode
        enterText(By.xpath("//input[@type='text']"),"sm3 2ad");
        //click on element to accepet terms and conditions
        clickOnElelement(By.className("checkmark"));
        //click on register
        clickOnElelement(By.xpath("//button[@class='primary full']"));
        clickOnElelement(By.xpath("//button[@type='submit']"));
        clickOnElelement(By.id("need-help"));
        // display expected and actual result
        String Expected = "Registration completed";
        String Actual = getTextFromElement(By.id("need-help"));
        Assert.assertEquals("Fail",Expected,Actual);
    }


}







