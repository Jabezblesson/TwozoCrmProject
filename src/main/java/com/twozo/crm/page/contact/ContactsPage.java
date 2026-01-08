package com.twozo.crm.page.contact;

import com.twozo.crm.component.TableUtils;
import com.twozo.crm.base.BasePage;
import com.twozo.crm.page.duplicatemanagment.DuplicateManagementPage;
import com.twozo.crm.page.dealspage.SearchResultPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage {

    public final SearchResultPage searchResult;

    private final By duplicatesDropdown  = By.xpath("(//div[@class='twozo-css-prefix-mpcrlp']//button)[3]");
    private final By manageDuplicatesBtn  = By.xpath("//li[contains(.,'Manage Duplicates')]");
    private final By skeletonLoader = By.cssSelector(".MuiSkeleton-root");
    private final By table = By.xpath("//table[contains(@class,'MuiTable-root')]");
    private final By toastPopUp = By.xpath("//div[@variant='reminder']");
    private final By actionButton = By.xpath("(//button[@type='button'])[17]");
    private final By delete = By.xpath("//li[contains(.,'Delete')]");
private final By confirmDelete = By.xpath("//button[text()='Cancel']/following-sibling::button");

    public ContactsPage(final WebDriver driver) {
        super(driver);
        searchResult = new SearchResultPage(driver);
    }

    public DuplicateManagementPage openManageDuplicates() {
        waitForElementToDisappear(toastPopUp);
        clickWithWait(duplicatesDropdown );
        clickWithWait(manageDuplicatesBtn);

        return new DuplicateManagementPage(driver);
    }

    public TableUtils loadContactsTable() {
        driver.navigate().refresh();
        waitForElementToDisappear(skeletonLoader);
        final WebElement tables = locateElement(table);

        return new TableUtils(tables);
    }

    public ContactsPage deleteContactByEmail() {
        clickWithWait(actionButton);
        clickWithWait(delete);
        clickWithWait(confirmDelete);

        return this;
    }
}