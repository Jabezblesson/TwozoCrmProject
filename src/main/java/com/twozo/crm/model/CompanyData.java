package com.twozo.crm.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompanyData {
    private String companyName;
    private String webSite;
    private String owner;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
