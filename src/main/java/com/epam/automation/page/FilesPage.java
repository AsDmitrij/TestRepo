package com.epam.automation.page;

import com.epam.automation.utils.WaitActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilesPage extends AbstractPage {

    private static By filesPlaceXPath = By.xpath("//div[@class='Box mb-3']");

    public FilesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected FilesPage openPage() {
        navigateTo(StringUtils.EMPTY);
        return this;
    }

    public EditFilePage goToPersonalFilePage(String nameOfEditFile) {
        WaitActions.waitUntilElementPresentOnDom(driver(), filesPlaceXPath);

        driver().findElements(By.xpath("//*[text()[contains(.,\"" + nameOfEditFile + "\")]]")).get(0).click();
        return new EditFilePage(driver());
    }
}