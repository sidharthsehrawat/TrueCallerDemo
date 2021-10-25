package com.convertorxlstoHtml.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity(name = "otp_table")
@Table(name = "otp_table")
public class OTPEntity {

    @Column(name = "phone", nullable = false, length = 100)
    private String phone;

    @Column(name = "otp", nullable = false, length = 100, unique = true)
    private Integer otp;

    @Column(name = "expiredIn", length = 50)
    private LocalDateTime expiredIn;

    public OTPEntity(String phone, Integer otp, LocalDateTime expiredIn) {
        this.phone = phone;
        this.otp = otp;
        this.expiredIn = expiredIn;
    }

    public OTPEntity() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public LocalDateTime getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(LocalDateTime expiredIn) {
        this.expiredIn = expiredIn;
    }
}
