package com.Order.ApOrder.theModel.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "Orders")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime eventDateTime;
    @ManyToOne
    private User client;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private Artucle artucle;
}














