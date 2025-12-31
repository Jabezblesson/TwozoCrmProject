package com.twozo.crm.base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void clickWithWait(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void click(final By locator) {
        driver.findElement(locator).click();
    }

    protected void type(final By locator, final String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected String getParentWindow() {
        return driver.getWindowHandle();
    }

    protected WebDriver switchToNewTab() {
        return driver.switchTo().newWindow(WindowType.TAB);
    }

    protected void switchToOriginalWindow(final String parentWindow) {
        driver.switchTo().window(parentWindow);
    }

    protected void switchToFrameId(final By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    protected void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    protected void waitForElementToDisappear(final By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected WebElement locateElement(final By locator) {
        return driver.findElement(locator);
    }

    protected WebElement locateElementWithVisibility(final By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> locateElements(final By locator) {
        return driver.findElements(locator);
    }

    protected void moveToElement(final By locator1, final By locator2) {
        final WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(locator1));
        final WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(locator2));
        final Actions actions = new Actions(driver);

        actions.moveToElement(element1)
                .pause(Duration.ofMillis(500))
                .click(element2)
                .perform();
    }

    protected void searchAndSelectDropDown(final By dropdownLocator, final By searchInputLocator, final String text) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator)).click();
        final WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputLocator));
        input.clear();
        input.sendKeys(text);
        final By option = By.xpath("//li[@role='option']//p[normalize-space()='" + text + "']");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    protected void selectDropDownOption(final By locator, final String value) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        final By optionLocator = By.xpath("//li[@role='option']//p[normalize-space()='" + value + "']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    protected void selectFromMuiAutoComplete(final By Locator, final String text) {
        final WebElement input = wait.until(ExpectedConditions.elementToBeClickable(Locator));
        input.click();
        input.clear();
        input.sendKeys(text);
        final By listBox = By.xpath("//ul[@role='listbox']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(listBox));
        final By option = By.xpath("//ul[@role='listbox']//div[@role='option']//p[normalize-space()='" + text + "']");
        final WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(option));
        optionElement.click();
    }

    protected void selectFromMuiAutoCompleteSecondOption(final By locator, final String text) {
        final WebElement input = wait.until(ExpectedConditions.elementToBeClickable(locator));
        input.click();
        input.clear();
        input.sendKeys(text);

        final By listBox = By.xpath("//ul[@role='listbox']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(listBox));
        final By secondOption = By.xpath(" //ul[@role='listbox']//div[@role='option' and @data-option-index='1']");
        wait.until(ExpectedConditions.elementToBeClickable(secondOption)).click();
    }

    protected final void selectDropDownMultipleInputs(final By dropdown, final List<String> values) {

        for (String value : values) {
            wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
            final By option = By.xpath("//li[@role='option']//p[normalize-space()='" + value + "']");
            wait.until(ExpectedConditions.elementToBeClickable(option)).click();
        }
    }
}