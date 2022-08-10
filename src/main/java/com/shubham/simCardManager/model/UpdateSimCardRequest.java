package com.shubham.simCardManager.model;

public class UpdateSimCardRequest {

    private String fullName;
    private String telecomProvider;
    private String status;
    private String stateOfRegistration;
    private boolean kyc;
    private long cardNumber;
    private long mobileNo;
    private long expireOn;

    public long getCardNumber() {
        return cardNumber;
    }

    public UpdateSimCardRequest setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public UpdateSimCardRequest setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UpdateSimCardRequest setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getTelecomProvider() {
        return telecomProvider;
    }

    public UpdateSimCardRequest setTelecomProvider(String telecomProvider) {
        this.telecomProvider = telecomProvider;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public UpdateSimCardRequest setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isKyc() {
        return kyc;
    }

    public UpdateSimCardRequest setKyc(boolean kyc) {
        this.kyc = kyc;
        return this;
    }

    public long getExpireOn() {
        return expireOn;
    }

    public UpdateSimCardRequest setExpireOn(long expireOn) {
        this.expireOn = expireOn;
        return this;
    }

    public String getStateOfRegistration() {
        return stateOfRegistration;
    }

    public UpdateSimCardRequest setStateOfRegistration(String stateOfRegistration) {
        this.stateOfRegistration = stateOfRegistration;
        return this;
    }
}
