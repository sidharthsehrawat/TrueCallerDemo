package com.convertorxlstoHtml.demo.service;

import com.convertorxlstoHtml.demo.exception.TrueCallerBaseException;
import com.convertorxlstoHtml.demo.model.GlobalContactsEntity;
import com.convertorxlstoHtml.demo.model.OTPEntity;
import com.convertorxlstoHtml.demo.model.UserProfileEntity;
import com.convertorxlstoHtml.demo.repository.GlobalContactRepository;
import com.convertorxlstoHtml.demo.repository.OtpRepository;
import com.convertorxlstoHtml.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    OtpRepository otpRepository;

    @Autowired
    GlobalContactRepository globalContactRepository;

    @Autowired
    UserProfileRepository userProfileRepository;
    @Override
    public UserProfileEntity registerNewAccount(UserProfileEntity userProfileEntity, int otp, LocalDateTime expiryTime) {
        // TODO: This call is not required. Blindly use saveOrUpdate Call
        //Optional<UserProfileEntity> optonaluserProfileEntity = userProfileRepository.findByPhone(userProfileEntity.getPhone());
        String token = null;
        if (userProfileEntity != null) {
            UserProfileEntity userProfileEntityByPhone = userProfileRepository.findByPhone(userProfileEntity.getPhone());
            if (userProfileEntityByPhone == null) {
                //means phone number not present in user DB
                //so make OTP call and save...
                OTPEntity otpEntity = otpRepository.findByPhone(userProfileEntity.getPhone());
                if (otpEntity == null) {
                    saveOTP(userProfileEntity.getPhone(), otp, expiryTime);
                    token = generateToken(otpEntity.getOtp().toString());
                } else if (LocalDateTime.now().isBefore(otpEntity.getExpiredIn())) {
                    // when user request Otp within expiry timeframe.. so on case return old Otp present in Otp Db table...
                    token = generateToken(otpEntity.getOtp().toString());
                } else {
                    //make new token..
                    token = generateToken(String.valueOf(generateOTP()));
                }
            }
        }
        userProfileEntity.setToken(token);
        userProfileEntity = userProfileRepository.saveAndFlush(userProfileEntity);
        return userProfileEntity;
    }

    private int generateOTP() {
        Random rand = new Random();
        return rand.nextInt((9999 - 100) + 1) + 10;
    }

    public static String generateToken(String otp) {
        return UUID.fromString(otp).toString();
        //return UUID.randomUUID().toString();
    }

    @Override
    public void saveOTP(String phone, int otp, LocalDateTime expiry) {
        OTPEntity otpEntity;
        if (expiry != null && phone != null) {
            otpEntity = new OTPEntity();
            otpEntity.setPhone(phone);
            otpEntity.setOtp(otp);
            otpEntity.setExpiredIn(expiry);
            otpRepository.saveAndFlush(otpEntity);
        }
    }

    @Override
    public void uploadContacts(List<GlobalContactsEntity> globalContactsEntities) {
        if (globalContactsEntities != null) {
            globalContactRepository.saveAll(globalContactsEntities);
        }
    }

    @Override
    public GlobalContactsEntity searchContact(String phone, String token) throws TrueCallerBaseException {
        if (userProfileRepository.findByToken(token) != null) {
            //now find phone from Global Contact Table...
           return globalContactRepository.findByPhone(phone);

        } else {
            throw new TrueCallerBaseException("Contact Not Registered");
        }
    }





}

