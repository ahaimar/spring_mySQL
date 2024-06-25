package com.Order.ApOrder.theModel.Entity;

import com.Order.ApOrder.theModel.Entity.interfac.Persent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name="supplier")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supplier implements Persent {

    @Id
    private String cin;
    private String ferstName;
    private String lastName;
    private String Phone;
    private String email;
    private int nomberSupplier = 1;
}