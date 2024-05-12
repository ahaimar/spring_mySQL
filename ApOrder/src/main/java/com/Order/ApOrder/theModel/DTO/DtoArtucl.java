package com.Order.ApOrder.theModel.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoArtucl {

    private Integer idArtucle;
    private String nameArtucle;
    private float priceArtucle;
    private String descriptionArtucle;
}
