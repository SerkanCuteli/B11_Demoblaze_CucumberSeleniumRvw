package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }


    protected Alert alert;
    Faker faker = new Faker();
    protected WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

    @FindBy(id = "login2")
    public WebElement homePage_LoginBtn;

    @FindBy(id = "logout2")
    public WebElement logout;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeMenu;

    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cartMenu;


}
