package com.twozo.crm.component;

import com.twozo.crm.model.TableCriteria;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableUtils {

    private final WebElement tables;
    private final By tableHead = By.cssSelector("table th");
    private final By tableRows = By.cssSelector("tbody tr");
    private final By tableColumn = By.cssSelector("td");

    public TableUtils(final WebElement tables) {
        this.tables = tables;
    }

    private Map<String, Integer> getHeader() {
        final Map<String, Integer> headermap = new HashMap<>();
        final List<WebElement> headers = tables.findElements(tableHead);
        final int size = headers.size();

        for (int i = 0; i < size; i++) {
            String header = headers.get(i).getText().trim().toLowerCase();
            headermap.put(header, i);
        }
        return headermap;
    }

    public final void printMatchingRow(final TableCriteria tableCriteria) {
        final Map<String, Integer> headermap = getHeader();

        Integer FirstIndex = -1;
        Integer SecondIndex = -1;

        for (String key : headermap.keySet()) {
            if (key.contains(tableCriteria.getColumns().get(0).toLowerCase())) FirstIndex = headermap.get(key);
            if (key.contains(tableCriteria.getColumns().get(1).toLowerCase())) SecondIndex = headermap.get(key);
        }

        if (FirstIndex == -1 || SecondIndex == -1) {
            throw new RuntimeException("required colum not found!");
        }

        final List<WebElement> rows = tables.findElements(tableRows);
        for (WebElement row : rows) {
            final List<WebElement> cols = row.findElements(tableColumn);
            final String name = cols.get(FirstIndex).getText().trim();

            if (name.equalsIgnoreCase(tableCriteria.getMatchValue())) {
                final String email = cols.get(SecondIndex).getText().trim();
                System.out.println(
                        tableCriteria.getColumns().get(0).toUpperCase() + ": " + name + " | " +
                                tableCriteria.getColumns().get(1).toUpperCase() + ": " + email);
            }
        }
    }
}
