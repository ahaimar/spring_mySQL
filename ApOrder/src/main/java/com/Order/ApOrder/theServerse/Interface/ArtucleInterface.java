package com.Order.ApOrder.theServerse.Interface;

import com.Order.ApOrder.theModel.Entity.Artucle;

import java.util.List;
import java.util.Optional;

public interface ArtucleInterface {

    Optional<Artucle> addArtucle(Artucle artucle);

    Optional<Artucle> updateArtucle(Artucle artucle);

    void deleteArtucle(Long id);

    Optional<List<Artucle>> getAllArtucle();

    Optional<Artucle> getArtucleById(Long id);
}
