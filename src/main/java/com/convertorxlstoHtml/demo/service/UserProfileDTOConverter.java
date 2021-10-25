package com.convertorxlstoHtml.demo.service;

import com.convertorxlstoHtml.demo.dto.GlobalContactDTO;
import com.convertorxlstoHtml.demo.dto.UserSignUpRequestDTO;
import com.convertorxlstoHtml.demo.exception.TrueCallerBaseException;
import com.convertorxlstoHtml.demo.model.GlobalContactsEntity;
import com.convertorxlstoHtml.demo.model.UserProfileEntity;

import java.util.ArrayList;
import java.util.List;

public class UserProfileDTOConverter {

    public static UserProfileEntity convertUserSignUpRequestDtoToUserEntity(UserSignUpRequestDTO userDTO) throws TrueCallerBaseException {
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        return userProfileEntity;

    }

    public static List<GlobalContactsEntity> convertGlobalContactDtoToUserEntities(List<GlobalContactDTO> globalContactDTOS) throws TrueCallerBaseException {
        return new ArrayList<>();
    }
}
