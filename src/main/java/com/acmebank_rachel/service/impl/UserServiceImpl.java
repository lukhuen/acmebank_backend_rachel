package com.acmebank_rachel.service.impl;

import com.acmebank_rachel.domain.User;
import com.acmebank_rachel.domain.entity.UserEntity;
import com.acmebank_rachel.repository.UserRepository;
import com.acmebank_rachel.service.UserService;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByFirebaseUid(String firebaseUid) {
        UserEntity userEntity = userRepository.findFirstByFirebaseUid(firebaseUid);
        if (userEntity != null) {
            return new User(userEntity);
        }
        return null;
    }

    public User createUser(FirebaseToken firebaseToken){
        UserEntity entity = new UserEntity();
        entity.setName(firebaseToken.getName());
        entity.setEmail(firebaseToken.getEmail());
        entity.setFirebaseUid(firebaseToken.getUid());
        entity.setBalance(BigDecimal.valueOf(0));
        entity = userRepository.save(entity);
        return new User(entity);
    }

    @Override
    public UserEntity getUserEntityByUid(Long uid){
        Optional<UserEntity> userEntity = userRepository.findById(uid);
        if (userEntity.isPresent()){
            return userEntity.get();
        }
        return null;
    }

    @Override
    public User transferBetweenUsers(Long payerUid, Long payeeUid, BigDecimal amount){
        UserEntity payerUserEntity = getUserEntityByUid(payerUid);
        UserEntity payeeUserEntity = getUserEntityByUid(payeeUid);

        if (payeeUserEntity == null | payerUserEntity == null || amount.doubleValue() < 0) {
            return null;
        }
        payerUserEntity.setBalance(payerUserEntity.getBalance().subtract(amount));
        payeeUserEntity.setBalance(payeeUserEntity.getBalance().add(amount));
        userRepository.save(payerUserEntity);
        userRepository.save(payeeUserEntity);
        return new User(payerUserEntity);
    };

}
