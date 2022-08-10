package com.shubham.simCardManager.service;

import com.shubham.simCardManager.model.AddSimCardRequest;
import com.shubham.simCardManager.model.SimCard;
import com.shubham.simCardManager.model.UpdateSimCardRequest;
import com.shubham.simCardManager.repository.SimCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class SimCardService {

    @Autowired
    private SimCardRepo simCardRepo;

    public ResponseEntity<?> addSimCard(AddSimCardRequest request) {
        if(request == null){
            return ResponseEntity.status(400).body("invalid request");
        }if(request.getCardNumber() == 0){
            return ResponseEntity.status(400).body("sim card number is required");
        }if(request.getMobileNo() == 0){
            return ResponseEntity.status(400).body("mobile number is required");
        }if(request.getStateOfRegistration() == null || request.getStateOfRegistration().isEmpty()){
            return ResponseEntity.status(400).body("state of registration is required");
        }if(request.getTelecomProvider() == null || request.getTelecomProvider().isEmpty()){
            return ResponseEntity.status(400).body("state of registration is required");
        }

        SimCard simCard = new SimCard()
                .setId(UUID.randomUUID().toString())
                .setMobileNo(request.getMobileNo())
                .setCardNumber(request.getCardNumber())
                .setStatus(request.getStatus())
                .setExpireOn(Instant.now().plus(365, ChronoUnit.DAYS).toEpochMilli())
                .setFullName(request.getFullName())
                .setStateOfRegistration(request.getStateOfRegistration())
                .setTelecomProvider(request.getTelecomProvider());
        simCardRepo.save(simCard);
        return ResponseEntity.status(200).body("sim card saved");
    }

    public ResponseEntity<?> getAllSimCards() {
        List<SimCard> simCardList = simCardRepo.findAll();
        return ResponseEntity.status(200).body(simCardList);
    }

    public ResponseEntity<?> updateSimCard(String simCardId, UpdateSimCardRequest updateSimCardRequest) {
        SimCard simCard = simCardRepo.findById(simCardId).orElse(null);
        if(simCard == null){
            return ResponseEntity.status(404).body("no sim card found for given id");
        }
        if(updateSimCardRequest.getCardNumber() != 0 && updateSimCardRequest.getCardNumber() != simCard.getCardNumber()){
            simCard.setCardNumber(updateSimCardRequest.getCardNumber());
        }if(updateSimCardRequest.getMobileNo() != 0 && updateSimCardRequest.getMobileNo() != simCard.getMobileNo()){
            simCard.setMobileNo(updateSimCardRequest.getMobileNo());
        }if(updateSimCardRequest.getStatus() != null && updateSimCardRequest.getStatus().equals(simCard.getStatus()) == false){
            simCard.setStatus(updateSimCardRequest.getStatus());
        }if(updateSimCardRequest.getFullName() != null && updateSimCardRequest.getFullName().equals(simCard.getFullName()) == false){
            simCard.setFullName(updateSimCardRequest.getFullName());
        }if(updateSimCardRequest.getTelecomProvider() != null && updateSimCardRequest.getTelecomProvider().equals(simCard.getTelecomProvider()) == false){
            simCard.setTelecomProvider(updateSimCardRequest.getTelecomProvider());
        }if(updateSimCardRequest.getStateOfRegistration() != null && updateSimCardRequest.getStateOfRegistration().equals(simCard.getStateOfRegistration()) == false){
            simCard.setStateOfRegistration(updateSimCardRequest.getStateOfRegistration());
        }
        simCardRepo.save(simCard);
        return ResponseEntity.status(200).body("updated sim card");
    }

    public ResponseEntity<?> deleteSimCard(String simCardId) {
        SimCard simCard = simCardRepo.findById(simCardId).orElse(null);
        if(simCard == null){
            return ResponseEntity.status(404).body("no sim card found for given id");
        }
        simCard.setDeleted(true);
        simCardRepo.save(simCard);
        return ResponseEntity.status(200).body("record deleted");
    }

    public ResponseEntity<?> getSimCardsToReNew() {
        List<SimCard> simCardList = simCardRepo.findByExpireOnLessThanEqual(Instant.now().plus(30,ChronoUnit.DAYS).toEpochMilli());
        return ResponseEntity.status(200).body(simCardList);
    }

    public ResponseEntity<?> renewSimCard(String simCardId) {
        SimCard simCard = simCardRepo.findById(simCardId).orElse(null);
        if(simCard == null){
            return ResponseEntity.status(404).body("no sim card found for given id");
        }
        simCard.setExpireOn(Instant.ofEpochMilli(simCard.getExpireOn()).plus(30,ChronoUnit.DAYS).toEpochMilli());
        simCardRepo.save(simCard);

        return ResponseEntity.status(200).body("sim card renewed");
    }
}
