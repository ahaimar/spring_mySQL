package com.Order.ApOrder.theServerse.Service;

import com.Order.ApOrder.theModel.Entity.Artucle;
import com.Order.ApOrder.theModel.theRepository.RepArtucle;
import com.Order.ApOrder.theServerse.Interface.ArtucleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerArtucle implements ArtucleInterface {

    @Autowired
    private RepArtucle repArtucle;


    @Override
    public Optional<Artucle> addArtucle(Artucle artucle) {

        try{

            return Optional.of(repArtucle.save(artucle));

        }catch (DataAccessException  ex){

            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Artucle> updateArtucle(Artucle artucle) {

        try {
            Optional<Artucle> existingArtucle = repArtucle.findById(artucle.getId());
            if(existingArtucle.isPresent()){
                Artucle art = existingArtucle.get();
                art.setNameArtucle(artucle.getNameArtucle());
                art.setPriceArtucle(artucle.getPriceArtucle());
                art.setDescriptionArtucle(artucle.getDescriptionArtucle());

                // save this updatee object
                Artucle upDated = repArtucle.save(art);
                return Optional.of(repArtucle.save(upDated));
            }else {

                return Optional.empty();
            }
        }catch (DataAccessException ex){

            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void deleteArtucle(Long id){

        this.repArtucle.deleteById(id);
    }

    @Override
    public Optional<List<Artucle>> getAllArtucle() {

        try {

            List<Artucle> artucle = this.repArtucle.findAll();
            return Optional.of(artucle);
        }catch (DataAccessException  ex){
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Artucle> getArtucleById(Long id) {

        try {
            Optional<Artucle> artucle = this.repArtucle.findById(id);
            return artucle;
        }catch (DataAccessException  ex){

            ex.printStackTrace();
            return Optional.empty();
        }
    }
}
