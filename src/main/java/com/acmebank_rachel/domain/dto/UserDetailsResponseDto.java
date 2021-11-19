package com.acmebank_rachel.domain.dto;

import com.acmebank_rachel.domain.User;

import java.math.BigDecimal;

public class UserDetailsResponseDto {
    private Long uid;
    private String name;
    private String email;
    private BigDecimal balance;

    public UserDetailsResponseDto(User user) {
        this.uid = user.getUid();
        this.name = user.getName();
        this.email = user.getEmail();
        this.balance = user.getBalance();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
