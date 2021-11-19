package com.acmebank_rachel.repository;

import com.acmebank_rachel.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findFirstByFirebaseUid(String firebaseUid);
}
