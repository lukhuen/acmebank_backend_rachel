package com.acmebank_rachel.domain;

import com.acmebank_rachel.domain.entity.UserEntity;

import java.math.BigDecimal;

public class User {
    private Long uid;
    private String email;
    private String name;
    private String firebaseUid;
    private BigDecimal balance;

    public User(UserEntity userEntity){
        this.uid = userEntity.getUid();
        this.email = userEntity.getEmail();
        this.name = userEntity.getName();
        this.firebaseUid = userEntity.getFirebaseUid();
        this.balance = userEntity.getBalance();
    }

    public UserEntity toEntity(){
        UserEntity entity = new UserEntity();
        entity.setUid(uid);
        entity.setEmail(email);
        entity.setName(name);
        entity.setFirebaseUid(firebaseUid);
        entity.setBalance(balance);
        return entity;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }
}
