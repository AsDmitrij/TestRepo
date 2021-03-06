package com.epam.automation.page;

import com.epam.automation.utils.WaitActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IssuePage extends AbstractPage {

    private static By createNewIssueButtonXPath = By.xpath("//a[@class='btn btn-primary']");

    @FindBy(xpath = "//div[@class='flex-shrink-0 mb-2 flex-self-start flex-md-self-center']")
    WebElement statusOfIssueButton;

    private final String listOfIssueCommitXPath = "//div[@class='pr-1 flex-auto min-width-0']";
    @FindBy(xpath = listOfIssueCommitXPath)
    List<WebElement> listOfIssueCommit;

    public IssuePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected IssuePage openPage() {
        navigateTo(StringUtils.EMPTY);
        return this;
    }

    public IssueCreationPage createNewIssue() {
        WaitActions.waitUntilElementPresentOnDom(driver(), createNewIssueButtonXPath).click();
        return new IssueCreationPage(driver());
    }

    public IssuePage waitForLastIssueCommitLoad() {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(listOfIssueCommitXPath));
        return this;
    }

    public String getLastIssueCommit() {
        return listOfIssueCommit.get(listOfIssueCommit.size() - 1).getText();
    }

    public String getIssueStatus() {
        return statusOfIssueButton.getText();
    }
}
