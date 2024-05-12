package com.Order.ApOrder.theModel.Entity;


import com.Order.ApOrder.theModel.Entity.interfac.Persent;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "user")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Persent {


   @Id
   private String cin;
   private String ferstName;
   private String lastName;
   private String password;
   private String address;
   private int age;
   private String email;
   private String phone;

   public User(String cin, String ferstName, String lastName, String address, String email, String phone) {

       this.cin = cin;
       this.ferstName = ferstName;
       this.lastName = lastName;
       this.address = address;
       this.email = email;
       this.phone = phone;
   }

}
