package com.twozo.crm.page.company;

import com.twozo.crm.component.TableUtils;
import com.twozo.crm.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompanyPage extends BasePage {

    private final By skeletonLoader = By.cssSelector(".MuiSkeleton-root");
    private final By table = By.xpath("//table[contains(@class,'MuiTable-root')]");

    public CompanyPage(final WebDriver driver) {
        super(driver);
    }

    public TableUtils loadCompanyTable() {
        waitForElementToDisappear(skeletonLoader);
        final WebElement tables = locateElement(table);

        return new TableUtils(tables);
    }
}
