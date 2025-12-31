package com.twozo.crm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateCompanyData implements DuplicateData {

    private String searchKey;
    private String retainName;
}
