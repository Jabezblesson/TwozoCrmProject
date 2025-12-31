package com.twozo.crm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WebTable implements TableCriteria {

    private List<String> columns;
    private String matchValue;
}