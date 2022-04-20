package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
userShouldLoginSuccessfullyWithValidCredentials

 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        WebElement userName = driver.findElement(By.name("username"));
        //        WebElement userName = driver.findElement(By.className("username"));
        userName.sendKeys("Lil1@yahoo.com");
        //Enter valid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Lily123");
        //Click on ‘LOGIN’ button
        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();
        // Verify the ‘Accounts Overview’ text is display
        WebElement verifyAccOverView = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMessage = verifyAccOverView.getText();
        String expectedMessage = "Accounts Overview";
        Assert.assertEquals("Wrong Message", expectedMessage, actualMessage);

    }
    @Test
    public void verifyLogInErrorMessage() {
        // Enter invalid username
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("jet@yahoo.com");
        //Enter invalid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("jet123");
        //Click on ‘LOGIN’ button
        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();
        // Verify the error message ‘The username and password could not be verified.’
        WebElement verifyErrorMessage = driver.findElement(By.xpath("//p[@class='error']"));
        System.out.println(verifyErrorMessage);
        String actualMessage = verifyErrorMessage.getText();
        String expectedMessage = "The username and password could not be verified.";
        //Assert.assertEquals("Error in Message", expectedMessage, actualMessage);
        Assert.assertEquals("Error in Message", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully() {
        //Enter valid username
        WebElement userName = driver.findElement(By.name("username"));
        //        WebElement userName = driver.findElement(By.className("username"));
        userName.sendKeys("Lil1@yahoo.com");
        //Enter valid password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Lily123");
        //Click on ‘LOGIN’ button
        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();
        //			* Click on ‘Log Out’ link
        WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
        logOut.click();
        //			* Verify the text ‘Customer Login’
        WebElement customerLogIn = driver.findElement(By.xpath("//div[@id='leftPanel']//h2"));
//        String actualText = customerLogIn.getText();
//        String expectedText = "Customer Login";
//        Assert.assertEquals("Wrong Text", expectedText,actualText);
        Assert.assertEquals("Wrong Text", "Customer Login", customerLogIn.getText());
    }
    @After
    public void tearDown() {
         closeBrowsers();
    }
}