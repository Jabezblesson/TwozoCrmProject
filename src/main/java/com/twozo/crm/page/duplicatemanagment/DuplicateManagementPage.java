package com.twozo.crm.page.duplicatemanagment;

import com.twozo.crm.component.DuplicateReviewComponent;

import com.twozo.crm.model.DuplicateData;
import com.twozo.crm.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DuplicateManagementPage extends BasePage {

    private final By contactButton = By.cssSelector("button[value='Contact']");
    private final By loadingSkeleton = By.cssSelector(".MuiSkeleton-root");
    private final By duplicateRows = By.cssSelector("table tbody tr");
    private final By reviewButton = By.xpath(".//button[normalize-space()='Review']");
    private final By reviewPopup = By.xpath("(//div[contains(@class,'MuiPaper-root MuiPaper-elevation')])[2]");
    private final By companyButton = By.xpath("//button[text()='Company']");

    public DuplicateManagementPage(final WebDriver driver) {
        super(driver);
    }

    public void contactTables() {
        clickWithWait(contactButton);
        waitForElementToDisappear(loadingSkeleton);
    }
    public void companyTables() {
        clickWithWait(companyButton);
        waitForElementToDisappear(loadingSkeleton);
    }

    public DuplicateReviewComponent reviewTable(final DuplicateData Data) {
        final String id = Data.getSearchKey().toLowerCase();
        final List<WebElement> rows = locateElements(duplicateRows);

        for (WebElement row : rows) {
            final String text = row.getText().toLowerCase().trim();

            if (text.contains(id)) {
                row.findElement(reviewButton).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(reviewPopup));
                final WebElement root = locateElement(reviewPopup);

                return new DuplicateReviewComponent(root);
            }
        }
        System.out.println("No duplicate row found: " + Data.getSearchKey());

        return null;
    }
}
