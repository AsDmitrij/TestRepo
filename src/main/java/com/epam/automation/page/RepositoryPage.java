package com.epam.automation.page;

import com.epam.automation.utils.WaitActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryPage extends AbstractPage {

    private final String issueTabButtonXPath = "//span[@data-content='Issues']";
    private final String filesTabButtonXPath = "//span[@data-content='Code']";

    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected RepositoryPage openPage() {
        navigateTo(StringUtils.EMPTY);
        return this;
    }

    public FilesPage openFilesPage() {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(filesTabButtonXPath)).click();
        return new FilesPage(driver());
    }

    public IssuePage openIssueTab() {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(issueTabButtonXPath)).click();
        return new IssuePage(driver());
    }
}