package com.Order.ApOrder.theModel.DTO;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoSupplier {

    private String cin;
    private String ferstName;
    private String lastName;
    private String tel;
    private int age;
    private String email;
}
