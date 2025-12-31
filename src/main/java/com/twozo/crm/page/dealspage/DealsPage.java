package com.twozo.crm.page.dealspage;

import com.twozo.crm.component.TableUtils;

import com.twozo.crm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DealsPage extends BasePage {

    public final SearchResultPage searchResult;
    public final SideBar sideBar;

    private final By table = By.xpath("//table[contains(@class,'MuiTable-root twozo-css-prefix-8vhhcj')]");
    private final By skeletonLoader = By.cssSelector(".MuiSkeleton-root");
    private final By clickList = By.xpath("//button[@value='list']");
    private final By toastPopUp = By.xpath("//div[@variant='reminder']");
    private final By clickAdd = By.xpath("(//button[@type='button']//span)[1]/parent::button");

    public DealsPage(final WebDriver driver) {
        super(driver);
        this.searchResult = new SearchResultPage(driver);
        this.sideBar = new SideBar(driver);
    }

    public TableUtils loadDealsTable() {

        waitForElementToDisappear(toastPopUp);
        clickWithWait(clickList);
        waitForElementToDisappear(skeletonLoader);
        final WebElement tables = locateElement(table);

        return new TableUtils(tables);
    }

    public AddOption openAddOption() {
        waitForElementToDisappear(toastPopUp);
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(clickAdd))).click();

        return new AddOption(driver);
    }
}