package testsuite;
/*
Write down the following test into ‘RegisterTest’ class
	1.verifyThatSigningUpPageDisplay
			 2.userShouldRegisterAccountSuccessfully
*/

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();
        WebElement pageTitle = driver.findElement(By.className("title"));
        pageTitle.getText();
        // Verify the text ‘Signing up is easy!
        String actualMessage = pageTitle.getText();
        String expectedMessage = "Signing up is easy!";
        Assert.assertEquals("Wrong Message", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();
        //Enter First name
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Lily");
        //Enter Last name
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        driver.findElement(By.id("customer.lastName"));
        //Enter Address
        lastName.sendKeys("Lotus");
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("105,Shaftbury");
        //Enter City
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("Cardiff");
        // Enter State
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("Cardiff");
        //Enter Zip Code
        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("WA19QT");
        //Enter Phone
        WebElement phonNo = driver.findElement(By.id("customer.phoneNumber"));
        phonNo.sendKeys("12345678912");
        // Enter SSN
        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("12345");
        //Enter Username
        WebElement userName = driver.findElement(By.id("customer.username"));
        userName.sendKeys("Lil1@yahoo.com");
        //Enter Password
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("Lily123");
        // Enter Confirm
        WebElement confirm = driver.findElement(By.id("repeatedPassword"));
        confirm.sendKeys("Lily123");
        //Click on REGISTER button
        WebElement register = driver.findElement(By.xpath("//input[@value='Register']"));
        register.click();
        //Verify the text 'Your account was created successfully. You are now logged in.’
        WebElement verifySignIn = driver.findElement(By.xpath("//div[@id='rightPanel']//p"));

        String actualMessage = verifySignIn.getText();
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals("Wrong Message", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowsers();

    }
}