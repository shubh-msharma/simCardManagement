package com.shubham.simCardManager.repository;

import com.shubham.simCardManager.model.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimCardRepo extends JpaRepository<SimCard,String> {
    List<SimCard> findByExpireOnLessThanEqual(long expireOn);
}
