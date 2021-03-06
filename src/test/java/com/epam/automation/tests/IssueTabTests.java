package com.epam.automation.tests;

import com.epam.automation.page.IssuePage;
import com.epam.automation.page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;


public class IssueTabTests extends AbstractTest {

    private final Date dateNow = new Date();
    private final String nameOfFileForTestIssues = "TestFileForIssue";

    @Test
    public void createIssueTest() {
        String issueName = "Test issue" + dateNow.toString();
        String resultIssueTitle = new MainPage(getDriver())
                .openRepositoryPage()
                .openIssueTab()
                .createNewIssue()
                .addCreatingIssueName(issueName)
                .submitNewIssue()
                .getIssueTitle();
        Assert.assertEquals(issueName, resultIssueTitle);
    }

    @Test(dependsOnMethods = {"createIssueTest"})
    public void commitChangesWithIssueRequestTest() {
        String textCommitChanges = "Test commit" + " #4 " + dateNow.toString();
        String lastIssueCommit = makeChangesAndCommitFile(textCommitChanges)
                .getLastIssueCommit();
        Assert.assertEquals(lastIssueCommit, textCommitChanges);
    }

    @Test(dependsOnMethods = {"commitChangesWithIssueRequestTest"})
    public void closeIssueWithCommitTest() {
        String textCommitChanges = "Test commit" + " fixes" + " #4 " + dateNow.toString();
        String resultIssueStatus = makeChangesAndCommitFile(textCommitChanges)
                .getIssueStatus();
        Assert.assertEquals(resultIssueStatus, "Closed");
    }

    private IssuePage makeChangesAndCommitFile(String textOfCommit) {
        return new MainPage(getDriver())
                .openRepositoryPage()
                .openFilesPage()
                .goToPersonalFilePage(nameOfFileForTestIssues)
                .startEditingFile()
                .addChangesToFile(textOfCommit)
                .addCommitToChanges(textOfCommit)
                .submitChanges()
                .followIssueLink()
                .waitForLastIssueCommitLoad();
    }

}
