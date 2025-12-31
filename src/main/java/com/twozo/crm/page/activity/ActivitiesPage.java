package com.twozo.crm.page.activity;

import com.twozo.crm.component.TableUtils;
import com.twozo.crm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivitiesPage extends BasePage {

    private final By skeletonLoader = By.cssSelector(".MuiSkeleton-root");
    private final By table = By.xpath("//table[contains(@class,'MuiTable-root twozo-css-prefix-8vhhcj')]");

    public ActivitiesPage(final WebDriver driver) {
        super(driver);
    }

    public TableUtils loadActivitiesTable() {
        waitForElementToDisappear(skeletonLoader);
        final WebElement tables = locateElement(table);

        return new TableUtils(tables);

    }
}
