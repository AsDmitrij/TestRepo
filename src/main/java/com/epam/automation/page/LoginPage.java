package com.epam.automation.page;

import com.epam.automation.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(id = "login_field")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block']")
    private WebElement verifyAccountButton;

    private final By verificationFieldXPath = By.xpath("//input[@class='form-control input-block']");
    @FindBy(xpath = "//input[@class='form-control input-block']")
    WebElement verificationField;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        navigateTo("/login");
        return this;
    }

    public MainPage login(User user) {
        inputLogin.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        buttonSubmit.click();
        return new MainPage(driver());
    }

    public boolean isVerificationFieldExists() {
        return !driver().findElements(verificationFieldXPath).isEmpty();
    }

    public LoginPage putVerificationCode(int verifyCode) {
        verificationField.sendKeys(String.valueOf(verifyCode));
        return this;
    }

    public void submitVerifyCode() {
        verifyAccountButton.click();
    }
}