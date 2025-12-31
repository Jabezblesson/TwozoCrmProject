package com.twozo.crm.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DealsData {

    private String title;
    private String pipeline;
    private String Stage;
    private String primaryContact;
    private String relatedContact;
    private String company;
    private String dealsValue;
    private String salesOwner;
}
