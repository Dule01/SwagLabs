package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class RunTests extends BaseTest {

    @BeforeMethod
    public void setUp(){
        init("CHROME", 15);
    }

    @AfterMethod
    public void tearDown(){
        quitBrowser();
    }

    @Test
    public void validLogin(){
        LoginPage lp = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");
        lp.enterValidCredentials();
        lp.clickLoginBtn();

        String productsText = driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        Assert.assertEquals(productsText, "PRODUCTS");
    }

    @Test
    public void invalidLogin(){
        LoginPage lp = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");
        lp.enterInvalidCredentials("randomname", "randompassword");
        lp.clickLoginBtn();

        String errorMsg = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        Assert.assertEquals(errorMsg, "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void emptyLogin(){
        LoginPage lp = new LoginPage(driver);

        driver.get("https://www.saucedemo.com/");
        lp.clickLoginBtn();

        String errorMsg = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        Assert.assertEquals(errorMsg, "Epic sadface: Username is required");
    }

}
