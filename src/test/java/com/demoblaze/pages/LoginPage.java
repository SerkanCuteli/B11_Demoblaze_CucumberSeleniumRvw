package com.demoblaze.pages;

import com.demoblaze.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "loginusername")
    public WebElement loginusername;

    @FindBy(id = "loginpassword")
    public WebElement loginpassword;

    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginBtn;

    public void login() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        homePage_LoginBtn.click();
        loginusername.sendKeys(username);
        loginpassword.sendKeys(password);
        loginBtn.click();
    }

    public void login(String username, String password) {
        homePage_LoginBtn.click();
        loginusername.sendKeys(username);
        loginpassword.sendKeys(password);
        loginBtn.click();
    }
}
