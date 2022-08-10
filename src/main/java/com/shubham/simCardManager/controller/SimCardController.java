package com.shubham.simCardManager.controller;

import com.shubham.simCardManager.model.AddSimCardRequest;
import com.shubham.simCardManager.model.UpdateSimCardRequest;
import com.shubham.simCardManager.service.SimCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimCardController {

    @Autowired
    private SimCardService simCardService;

    @GetMapping("/")
    public ResponseEntity<?> health() {
        return ResponseEntity.status(200).body("ok");
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSimCard(
            @RequestBody AddSimCardRequest request
    ) {
        return simCardService.addSimCard(request);
    }

    @GetMapping("/listall")
    public ResponseEntity<?> getAllSimCards() {
        return simCardService.getAllSimCards();
    }

    @PutMapping("/{simCardId}")
    public ResponseEntity<?> updateSimCard(
            @RequestBody UpdateSimCardRequest updateSimCardRequest,
            @PathVariable("simCardId") String simCardId
    ) {
        return simCardService.updateSimCard(simCardId,updateSimCardRequest);
    }

    @DeleteMapping("/{simCardId}")
    public ResponseEntity<?> deleteSimCard(
            @PathVariable("simCardId") String simCardId
    ) {
        return simCardService.deleteSimCard(simCardId);
    }

    @GetMapping("/to-renew")
    public ResponseEntity<?> getSimCardsToReNew(){
        return simCardService.getSimCardsToReNew();
    }

    @PutMapping("/renew/{simCardId}")
    public ResponseEntity<?> renewSimCard(
            @PathVariable("simCardId")String simCardId
    ){
        return simCardService.renewSimCard(simCardId);
    }
}
