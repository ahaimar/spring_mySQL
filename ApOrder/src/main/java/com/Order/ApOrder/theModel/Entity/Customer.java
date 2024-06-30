package com.Order.ApOrder.theModel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private int age;
    private String email;
    private String phone;
    
    @OneToMany
    @JoinColumn
    @Column(insertable = false , updatable = false)
    private List<Order> orderList;

    public Customer(String firstName,String password,String email) {

        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }

    public Customer(String phone, String email, int age, String password, String lastName, String firstName, String address) {
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
    }
}
