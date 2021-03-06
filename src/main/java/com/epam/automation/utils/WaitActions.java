package com.epam.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitActions {
    // must be configurable
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration DEFAULT_POLLING = Duration.ofSeconds(2);

    public static WebElement waitUntilElementPresentOnDom(WebDriver driver, By locator) {
        return new WebDriverWait(driver, DEFAULT_TIMEOUT.toSeconds(), DEFAULT_POLLING.toMillis())
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}