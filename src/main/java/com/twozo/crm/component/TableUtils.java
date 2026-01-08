package com.twozo.crm.component;

import com.twozo.crm.model.TableCriteria;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.By.cssSelector;

public class TableUtils {

    private final WebElement table;

    private final By tableHead = cssSelector("th");
    private final By tableRows = cssSelector("tbody tr");
    private final By tableColumn = cssSelector("td");

    public TableUtils(final WebElement table) {
        this.table = table;
    }

    private Map<String, Integer> getHeader() {
        final Map<String, Integer> headerMap = new HashMap<>();
        final List<WebElement> headers = table.findElements(tableHead);

        for (int i = 0; i < headers.size(); i++) {
            String header = headers.get(i).getText().trim().toLowerCase();
            headerMap.put(header, i);
        }
        return headerMap;
    }

    public boolean printMatchingRow(final TableCriteria tableCriteria) {
        final Map<String, Integer> headerMap = getHeader();

        Integer firstIndex = -1;
        Integer secondIndex = -1;

        for (String key : headerMap.keySet()) {
            if (key.contains(tableCriteria.getColumns().get(0).toLowerCase()))
                firstIndex = headerMap.get(key);
            if (key.contains(tableCriteria.getColumns().get(1).toLowerCase()))
                secondIndex = headerMap.get(key);
        }

        if (firstIndex == -1 || secondIndex == -1) {
            throw new RuntimeException("Required column not found!");
        }

        final List<WebElement> rows = table.findElements(tableRows);

        for (WebElement row : rows) {
            final List<WebElement> cols = row.findElements(tableColumn);
            final String name = cols.get(firstIndex).getText().trim();

            if (name.equalsIgnoreCase(tableCriteria.getMatchValue())) {
                final String email = cols.get(secondIndex).getText().trim();
                final WebElement checkboxCell = cols.get(0);
                checkboxCell.click();
                System.out.println("✔ Checkbox clicked for: " + name);
                System.out.println(tableCriteria.getColumns().get(0).toUpperCase() + ": " + name + " | " +
                        tableCriteria.getColumns().get(1).toUpperCase() + ": " + email
                );
                return true;
            }
        }
        return false;
    }
}