package com.twozo.crm.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public final class SignupData {

    private String username;
    private String emailId;
    private String password;
    private String phone;
}
