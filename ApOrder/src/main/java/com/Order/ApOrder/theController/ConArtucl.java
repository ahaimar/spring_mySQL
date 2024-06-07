package com.Order.ApOrder.theController;


import com.Order.ApOrder.theModel.Entity.Artucle;
import com.Order.ApOrder.theServerse.Service.SerArtucle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173/")
@RestController("/Artucl")
@RequestMapping
public class ConArtucl {

    @Autowired
    private SerArtucle serArtucle;

    @GetMapping("/getArtucles")
    public ResponseEntity<List<Artucle>> getAllArtucl() {

        return new ResponseEntity<List<Artucle>>(this.serArtucle.getAllArtucle().get(), HttpStatus.OK);
    }
    @GetMapping("/getArtucle")
    public ResponseEntity<Artucle> getArtucleById(@RequestParam Long id) {
        return new ResponseEntity<Artucle>(this.serArtucle.getArtucleById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/addArtucl")
    public void addArtucl(@RequestBody Artucle artucl) {

        this.serArtucle.addArtucle(artucl);
    }
    @PostMapping("/updateArtucl")
    public void updateArtucl(@RequestBody Artucle artucl) {
        this.serArtucle.updateArtucle(artucl);
    }
    @DeleteMapping("/deleteArtucl")
    public void deleteArtucl(@RequestParam Long id) {
        this.serArtucle.deleteArtucle(id);
    }
}
