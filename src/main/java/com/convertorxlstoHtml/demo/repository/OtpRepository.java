package com.convertorxlstoHtml.demo.repository;

import com.convertorxlstoHtml.demo.model.OTPEntity;
import com.convertorxlstoHtml.demo.model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<OTPEntity,Long> {

    @Query(value = "SELECT * FROM UserProfileEntity u WHERE u.phone = :phone",
            nativeQuery = true)
    OTPEntity findByPhone(@Param("phone") String phone);
}
