package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

public class HomePage extends BasePage{

    @FindBy(xpath = "nameofuser")
    public WebElement nameofuser;
    @FindBy(id = "logout2")
    public WebElement logout;

    @FindBy(xpath = "//a[text()='Welcome salih']")
    public WebElement welcomeText;

    @FindBy(linkText = "Add to cart")
    public WebElement add_to_cart_Btn;

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement priceText;
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

    public int addProduct(String product, String category){

        try{
            WebElement categoryTab = Driver.get().findElement(By.linkText(category));
            BrowserUtils.waitForClickablility(categoryTab,5).click();
        }catch(Exception e){
            BrowserUtils.clickWithWait(By.linkText(category),5);
        }
        try{
            WebElement productItem = Driver.get().findElement(By.linkText(product));
            BrowserUtils.scrollToElement(productItem);
            BrowserUtils.waitForClickablility(productItem,5).click();
        }catch(Exception e){
            BrowserUtils.clickWithWait(By.linkText(product),5);
        }

        System.out.println("priceText.getText() = " + priceText.getText());
        String[] arrayAmount = priceText.getText().split(" ");
        System.out.println(Arrays.toString(arrayAmount));
        int lastPrice = Integer.parseInt(arrayAmount[0].substring(1));
        System.out.println("lastPrice = " + lastPrice);


        add_to_cart_Btn.click();
        //wait.until(ExpectedConditions.alertIsPresent());
        BrowserUtils.waitFor(2);
        alert = Driver.get().switchTo().alert();
        alert.accept();
        homeMenu.click();

        return lastPrice;
    }
}
