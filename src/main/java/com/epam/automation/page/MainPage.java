package com.epam.automation.page;

import com.epam.automation.utils.WaitActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends AbstractPage {

    private final String nameOfRepositoriesXPath = "//li[@class='private source no-description']";
    @FindBy(xpath = nameOfRepositoriesXPath)
    List<WebElement> nameOfRepositories;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage openPage() {
        navigateTo(StringUtils.EMPTY);
        return this;
    }

    public String getLoggedInUserName() {
        return WaitActions
                .waitUntilElementPresentOnDom(driver(), By.xpath("//meta[@name='user-login']"))
                .getAttribute("content");
    }

    public RepositoryPage openRepositoryPage() {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(nameOfRepositoriesXPath));
        nameOfRepositories.get(0).click();
        return new RepositoryPage(driver());
    }
}