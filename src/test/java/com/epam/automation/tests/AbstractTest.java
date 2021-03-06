package com.epam.automation.tests;

import com.epam.automation.driver.WebDriverFactory;
import com.epam.automation.model.User;
import com.epam.automation.page.LoginPage;
import com.epam.automation.service.UserFactory;
import com.epam.automation.utils.VerificationEmailUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;


public abstract class AbstractTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        int n = VerificationEmailUtil.getVerificationEmailCode("readMessage");
        driver = WebDriverFactory.getDriver();
        User testUser = UserFactory.createUser();
        new LoginPage(getDriver())
                .openPage()
                .login(testUser);
        ArrayList<String> currentTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(currentTabs.get(0));
        driver.close();
        driver.switchTo().window(currentTabs.get(1));
        if (new LoginPage(getDriver()).isVerificationFieldExists()) {
            new LoginPage(getDriver())
                    .putVerificationCode(VerificationEmailUtil.getVerificationEmailCode("readMessage"))
                    .submitVerifyCode();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        WebDriverFactory.closeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
