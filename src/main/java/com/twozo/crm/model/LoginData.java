package com.twozo.crm.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginData {

    private String username;
    private String password;
}
