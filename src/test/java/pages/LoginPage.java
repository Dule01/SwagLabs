package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonActions{
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-name")
    WebElement userNameField;

    @FindBy(css = "#password")
    WebElement passwordField;

    public void enterValidCredentials(){
        typeText(userNameField, "standard_user");
        typeText(passwordField, "secret_sauce");
    }

    @FindBy(css = "#login-button")
    WebElement loginBtn;

    public void clickLoginBtn(){
        clickElement(loginBtn);
    }



}
