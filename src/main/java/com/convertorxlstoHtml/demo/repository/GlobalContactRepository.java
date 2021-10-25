package com.convertorxlstoHtml.demo.repository;

import com.convertorxlstoHtml.demo.model.GlobalContactsEntity;
import com.convertorxlstoHtml.demo.model.OTPEntity;
import com.convertorxlstoHtml.demo.model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalContactRepository extends JpaRepository<GlobalContactsEntity, Long> {

    @Query(value = "SELECT u FROM GlobalContactsEntity u WHERE u.phone = :phone",
            nativeQuery = true)
    GlobalContactsEntity findByPhone(@Param("phone") String phone);
}
