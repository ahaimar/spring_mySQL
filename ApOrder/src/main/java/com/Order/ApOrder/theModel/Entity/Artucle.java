package com.Order.ApOrder.theModel.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "artucle")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Artucle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameArtucle;
    private float priceArtucle;
    private String descriptionArtucle = "(...)";

}
