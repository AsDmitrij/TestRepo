package com.epam.automation.page;

import com.epam.automation.utils.WaitActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditFilePage extends AbstractPage {
    private final String editFileButtonXPath = "//button[@class='btn-octicon tooltipped tooltipped-nw']";
    private final String textAreaInputXPath = "//div[1]/pre[@class=' CodeMirror-line ' and 1]";
    private final String commitSummaryFieldXPath = "//input[@id='commit-summary-input']";
    private final String submitEditButtonXPath = "//button[@id='submit-file']";
    private final String issueLinkButtonXPath = "//a[@class='issue-link js-issue-link']";

    public EditFilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected EditFilePage openPage() {
        navigateTo(StringUtils.EMPTY);
        return this;
    }

    public EditFilePage startEditingFile() {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(editFileButtonXPath)).click();
        return this;
    }

    public EditFilePage addChangesToFile(String textForChangingFile) {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(textAreaInputXPath)).sendKeys(textForChangingFile);
        return this;
    }

    public EditFilePage addCommitToChanges(String textOfCommit) {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(commitSummaryFieldXPath)).sendKeys(textOfCommit);
        return this;
    }

    public EditFilePage submitChanges() {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(submitEditButtonXPath)).click();
        return this;
    }

    public IssuePage followIssueLink() {
        WaitActions.waitUntilElementPresentOnDom(driver(), By.xpath(issueLinkButtonXPath)).click();
        return new IssuePage(driver());
    }
}