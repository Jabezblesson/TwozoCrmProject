package com.twozo.crm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DealsTables implements TableCriteria {

    private List<String> columns;
    private String matchValue;
}
