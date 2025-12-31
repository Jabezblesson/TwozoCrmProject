package com.twozo.crm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateContactsData implements DuplicateData {

    private String searchKey;  // email or phone
    private String retainName;      // name to retain
}