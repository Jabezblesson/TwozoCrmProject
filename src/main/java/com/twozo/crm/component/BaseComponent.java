package com.twozo.crm.component;

import org.openqa.selenium.*;

import java.util.List;

public abstract class BaseComponent {

    protected final WebElement root;

    public BaseComponent(final WebElement rootElement) {
        this.root = rootElement;
    }

    protected WebElement locateElement(final By locator) {
        return root.findElement(locator);
    }

    protected List<WebElement> locateElements(final By locator) {
        return root.findElements(locator);
    }

    protected void click(final By locator) {
        locateElement(locator).click();
    }

    protected String getText(final By locator) {
        return locateElement(locator).getText().trim();
    }
}
