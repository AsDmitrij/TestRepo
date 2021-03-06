package com.epam.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    private static final String ROOT_URL = "https://github.com";

    private final WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver(), this);
    }

    protected abstract AbstractPage openPage();

    public WebDriver driver() {
        return driver;
    }

    protected void navigateTo(String relative) {
        driver().navigate().to(ROOT_URL + relative);
    }
}