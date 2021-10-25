package com.convertorxlstoHtml.demo.service;

import com.convertorxlstoHtml.demo.exception.TrueCallerBaseException;
import com.convertorxlstoHtml.demo.model.GlobalContactsEntity;
import com.convertorxlstoHtml.demo.model.UserProfileEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface AppService {

    UserProfileEntity registerNewAccount(UserProfileEntity userProfileEntity,int otp, LocalDateTime expireTime);

    void saveOTP(String phone, int otp, LocalDateTime expiry);

    void uploadContacts(List<GlobalContactsEntity> convertUserSignUpRequestDtoToUserEntities);

    GlobalContactsEntity searchContact(String phone, String token) throws TrueCallerBaseException;
}
