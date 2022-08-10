package com.shubham.simCardManager.model;

public class AddSimCardRequest {

    private String fullName;
    private String telecomProvider;
    private String status;
    private String stateOfRegistration;
    private boolean kyc;
    private long cardNumber;
    private long mobileNo;

    public String getFullName() {
        return fullName;
    }

    public AddSimCardRequest setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getTelecomProvider() {
        return telecomProvider;
    }

    public AddSimCardRequest setTelecomProvider(String telecomProvider) {
        this.telecomProvider = telecomProvider;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public AddSimCardRequest setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isKyc() {
        return kyc;
    }

    public AddSimCardRequest setKyc(boolean kyc) {
        this.kyc = kyc;
        return this;
    }

    public String getStateOfRegistration() {
        return stateOfRegistration;
    }

    public AddSimCardRequest setStateOfRegistration(String stateOfRegistration) {
        this.stateOfRegistration = stateOfRegistration;
        return this;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public AddSimCardRequest setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public AddSimCardRequest setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }
}
