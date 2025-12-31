package com.twozo.crm.component;

import com.twozo.crm.model.DuplicateData;

import org.openqa.selenium.*;

import java.util.List;

public class DuplicateReviewComponent extends BaseComponent {

    private final By mergeButton = By.xpath("//button[contains(.,'Merge')]");
    private final By duplicateCards = By.cssSelector("div.twozo-css-prefix-1c3jdm9");
    private final By selectionRadio = By.cssSelector("input[type='radio']");

    public DuplicateReviewComponent(final WebElement root) {
        super(root);
    }

    public void mergeDuplicateRecord(final DuplicateData data) {
       final List<WebElement> cards = locateElements(duplicateCards);
       final WebElement retainCard = cards.stream()
                .filter(c -> c.getText().toLowerCase().contains(data.getRetainName().toLowerCase()))
                .findFirst()
                .orElse(null);

        if (retainCard == null) {
            System.out.println(" Retain option NOT found: " + data.getRetainName());
            return;
        }

        retainCard.findElement(selectionRadio).click();
        click(mergeButton);
        System.out.println("✔ Merge completed for: " + data.getSearchKey());
    }
}