package com.epam.automation.page;

import com.epam.automation.utils.WaitActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IssueCreationPage extends AbstractPage {

    private static By creatingIssueTitleXPath = By.xpath("//input[@id='issue_title']");


    private final String submitNewIssueButtonXPath = "//*[text()[contains(.,\"Submit new issue\")]]";
    @FindBy(xpath = submitNewIssueButtonXPath)
    List<WebElement> submitNewIssueButton;

    public IssueCreationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected IssueCreationPage openPage() {
        navigateTo(StringUtils.EMPTY);
        return this;
    }

    public IssueCreationPage addCreatingIssueName(String issueName) {
        WaitActions.waitUntilElementPresentOnDom(driver(), creatingIssueTitleXPath).sendKeys(issueName);
        return this;
    }

    public IssuesPage submitNewIssue() {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(submitNewIssueButtonXPath));
        submitNewIssueButton.get(0).click();
        return new IssuesPage(driver());
    }
}