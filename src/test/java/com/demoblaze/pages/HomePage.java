package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "nameofuser")
    public WebElement nameofuser;
    @FindBy(id = "logout2")
    public WebElement logout;

    @FindBy(xpath = "//a[text()='Welcome salih']")
    public WebElement welcomeText;

    public void verifyWelcomeMessage(){
        BrowserUtils.waitForVisibility(logout,10);
        String actualMessage=welcomeText.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertTrue(actualMessage.contains(ConfigurationReader.get("username")));
    }

    public void verifyWelcomeMessage(String username){
        BrowserUtils.waitForVisibility(logout,10);
        String actualMessage=welcomeText.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertTrue(actualMessage.contains(username));
    }

    public void invalidLoginWarningMessage(String message){
        BrowserUtils.waitFor(3);
        Alert alert = Driver.get().switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        Assert.assertEquals(alert.getText(), message);
    }
}
