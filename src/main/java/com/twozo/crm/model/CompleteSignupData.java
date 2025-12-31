package com.twozo.crm.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompleteSignupData {

    private String companyName;
    private String jobRole;
    private String currency;
    private String timezone;
}
