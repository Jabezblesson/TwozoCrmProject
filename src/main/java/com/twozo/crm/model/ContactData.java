package com.twozo.crm.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Builder
public class ContactData {

    private String firstName;
    private String lastName;
    private String email;
    private String emailType;
    private String phone;
    private String phoneType;
    private String company;
    private String designation;
    private String owner;
    private String lifeCycleStage;
    private String lifeCycleStatus;
    private String facebookProfile;
    private String linkedInProfile;
    private String subscriptionStatus;
    private List<String> subscriptionType;
}
