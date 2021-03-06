package com.epam.automation.page;

import com.epam.automation.utils.WaitActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuesPage extends AbstractPage {

    private final String resultIssueTitleXPath = "//span[@class='js-issue-title']";

    public IssuesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected IssuesPage openPage() {
        navigateTo(StringUtils.EMPTY);
        return this;
    }

    public String getIssueTitle() {
        return WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(resultIssueTitleXPath)).getText();
    }
}