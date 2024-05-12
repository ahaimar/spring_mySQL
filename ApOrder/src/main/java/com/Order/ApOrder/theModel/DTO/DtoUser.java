package com.Order.ApOrder.theModel.DTO;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DtoUser {

    private String cin;
    private String ferstName;
    private String lastName;
    private String password;
    private String address;
    private int age;
    private String email;
    private String phone;

}
