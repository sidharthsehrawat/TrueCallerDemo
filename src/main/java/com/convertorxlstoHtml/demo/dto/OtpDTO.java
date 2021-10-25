package com.convertorxlstoHtml.demo.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OtpDTO {
    private String phone;
    private String otp;
    private LocalDateTime expiry;

    public OtpDTO(String phone, String otp, LocalDateTime expiry) {
        this.phone = phone;
        this.otp = otp;
        this.expiry = expiry;
    }

    public OtpDTO() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "OtpDTO{" +
                "phone='" + phone + '\'' +
                ", otp='" + otp + '\'' +
                ", expiry=" + expiry +
                '}';
    }
}
