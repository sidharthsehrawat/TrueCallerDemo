package com.convertorxlstoHtml.demo.repository;

import com.convertorxlstoHtml.demo.model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    @Query(value = "SELECT u FROM UserProfileEntity u WHERE u.phone = :phone", nativeQuery = true)
    UserProfileEntity findByPhone(@Param("phone") String phone);

    @Query(value = "SELECT u FROM U UserProfileEntity u WHERE u.token = :token", nativeQuery = true)
    UserProfileEntity findByToken(@Param("token") String token);

}
