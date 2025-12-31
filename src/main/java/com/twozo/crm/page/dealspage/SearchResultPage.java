package com.twozo.crm.page.dealspage;

import com.twozo.crm.model.SearchData;

import com.twozo.crm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {

    private final By searchBar = By.cssSelector("input[placeholder='Search']");
    private final By buttons = By.xpath("//button[contains(@class,'MuiButtonBase-root MuiToggleButton-root')]");
    private final By nameInsideResult = By.xpath("(//p[contains(@class,'MuiTypography-root MuiTypography-body1')]//span)[3]");
    private final By emailInsideResult = By.xpath("//div[@class='twozo-css-prefix-v8imfp']//p[1]");
    private final By popupContainer = By.xpath("//li[@role='menuitem']");

    public SearchResultPage(final WebDriver driver) {
        super(driver);
    }

    private void clickTab(final String text, final String tabName) {
        type(searchBar, text);
        final List<WebElement> tabs = locateElements(buttons);

        for (WebElement tab : tabs) {
            if (tab.getText().trim().equalsIgnoreCase(tabName)) {
                tab.click();
                break;
            }
        }
    }

    private WebElement getFirstResult() {
        final List<WebElement> results = locateElements(popupContainer);
        return results.getFirst();
    }

    private String getFirstResultName() {
        final WebElement first = getFirstResult();
        return first.findElement(nameInsideResult).getText().trim();
    }

    private String getFirstResultEmail() {
        final WebElement first = getFirstResult();
        return first.findElement(emailInsideResult).getText().trim();
    }

    public void getSearchResults(final SearchData data) {
        clickTab(data.getName(), data.getButton());
        final String name = getFirstResultName();
        final String email = getFirstResultEmail();
        System.out.print("NAME : " + name + " " + "Email : " + email);
    }
}