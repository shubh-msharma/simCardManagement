package com.shubham.simCardManager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimCard {

    @Id
    private String id;
    @JsonProperty("Sim_card_no")
    private long cardNumber;
    @JsonProperty("Full_name")
    private String fullName;
    @JsonProperty("Mobile_no")
    private long mobileNo;
    @JsonProperty("Telecom_Provider")
    private String telecomProvider;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("KYC")
    private boolean kyc;
    @JsonProperty("Expiry_date")
    private long expireOn;
    @JsonProperty("State_of_registration")
    private String stateOfRegistration;
    private boolean deleted;

    public String getId() {
        return id;
    }

    public SimCard setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public SimCard setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getTelecomProvider() {
        return telecomProvider;
    }

    public SimCard setTelecomProvider(String telecomProvider) {
        this.telecomProvider = telecomProvider;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SimCard setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isKyc() {
        return kyc;
    }

    public SimCard setKyc(boolean kyc) {
        this.kyc = kyc;
        return this;
    }

    public long getExpireOn() {
        return expireOn;
    }

    public SimCard setExpireOn(long expireOn) {
        this.expireOn = expireOn;
        return this;
    }

    public String getStateOfRegistration() {
        return stateOfRegistration;
    }

    public SimCard setStateOfRegistration(String stateOfRegistration) {
        this.stateOfRegistration = stateOfRegistration;
        return this;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public SimCard setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public SimCard setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public SimCard setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }
}
