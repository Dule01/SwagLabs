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
        init("EDGE", 15);
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

}
