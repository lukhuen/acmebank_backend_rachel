package com.acmebank_rachel.service;

import com.acmebank_rachel.domain.User;
import com.acmebank_rachel.domain.entity.UserEntity;
import com.google.firebase.auth.FirebaseToken;

import java.math.BigDecimal;

public interface UserService {
    User getUserByFirebaseUid(String firebaseUid);
    User createUser(FirebaseToken firebaseToken);
    UserEntity getUserEntityByUid(Long uid);
    User transferBetweenUsers(Long payerUid, Long payeeUid, BigDecimal amount);
}
