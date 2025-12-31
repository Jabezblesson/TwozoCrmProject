package com.twozo.crm.page.dealspage;

import com.twozo.crm.page.caller.CallerPage;
import com.twozo.crm.page.activity.ActivitiesPage;
import com.twozo.crm.page.activity.ActivityGoalsPage;
import com.twozo.crm.page.analytics.AnalyticsPage;
import com.twozo.crm.page.company.CompanyPage;
import com.twozo.crm.page.contact.ContactsPage;
import com.twozo.crm.base.BasePage;
import com.twozo.crm.page.message.MessagePage;
import com.twozo.crm.page.settings.SettingsPage;
import com.twozo.crm.page.useraccount.UserAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideBar extends BasePage {

    private final By dealButton = By.xpath("(//div[@role='button'])[1]");
    private final By contactButton = By.xpath("(//div[@role='button'])[2]");
    private final By companyButton = By.xpath("(//div[@role='button'])[3]");
    private final By activityButton = By.xpath("(//div[@role='button'])[4]");
    private final By activities = By.xpath("//p[normalize-space(text())='Activities']");
    private final By activityGoal = By.xpath("//p[normalize-space(text())='Activity Goals']");
    private final By settingButton = By.xpath("(//div[@role='button'])[5]");
    private final By messageButton = By.xpath("(//div[@role='button'])[6]");
    private final By analyticButton = By.xpath("(//div[@role='button'])[7]");
    private final By twozoCallerButton = By.xpath("(//button[@type='button'])[3]");
    private final By accountButton = By.xpath("(//div[@class='twozo-css-prefix-1kr1lm1']//div)[3]");
    private final By toastPopUp = By.xpath("//div[@variant='reminder']");

    public SideBar(final WebDriver driver) {
        super(driver);
    }

    public DealsPage clickDeals() {
        click(dealButton);
        return new DealsPage(driver);
    }

    public ContactsPage clickContacts() {
        click(contactButton);
        return new ContactsPage(driver);
    }

    public CompanyPage clickCompany() {
        click(companyButton);
        return new CompanyPage(driver);
    }

    public ActivitiesPage clickActivities() {
        waitForElementToDisappear(toastPopUp);
        click(activityButton);
        click(activities);

        return new ActivitiesPage(driver);
    }

    public ActivityGoalsPage clickActivityGoal() {
        moveToElement(activityButton, activityGoal);
        return new ActivityGoalsPage(driver);
    }

    public SettingsPage clickSettings() {
        click(settingButton);
        return new SettingsPage(driver);
    }

    public MessagePage clickMessage() {
        click(messageButton);
        return new MessagePage(driver);
    }

    public AnalyticsPage clickAnalytics() {
        click(analyticButton);
        return new AnalyticsPage(driver);
    }

    public CallerPage clickCaller() {
        click(twozoCallerButton);
        return new CallerPage(driver);
    }

    public UserAccountPage clickAccount() {
        click(accountButton);
        return new UserAccountPage(driver);
    }
}
