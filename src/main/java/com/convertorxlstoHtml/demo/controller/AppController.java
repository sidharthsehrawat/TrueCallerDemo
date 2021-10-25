package com.convertorxlstoHtml.demo.controller;

import com.convertorxlstoHtml.demo.service.AppService;
import com.convertorxlstoHtml.demo.service.UserProfileDTOConverter;
import com.convertorxlstoHtml.demo.dto.GlobalContactDTO;
import com.convertorxlstoHtml.demo.dto.UserSignUpRequestDTO;
import com.convertorxlstoHtml.demo.exception.TrueCallerBaseException;
import com.convertorxlstoHtml.demo.model.GlobalContactsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    AppService appService;

  @PostMapping(value = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerUSer(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) throws TrueCallerBaseException {
        if (userSignUpRequestDTO != null) {
            // Apply mandatory check for name and phone
            if (userSignUpRequestDTO.getName() != null && userSignUpRequestDTO.getPhone() != null) {
                int otp = generateOTP();
                LocalDateTime expireTime;
                int expireIn = 600;
                expireTime = LocalDateTime.now().plusSeconds(expireIn);
                //save phone,otp,and expiry to otp_table
                //appService.saveOTP(userSignUpRequestDTO.getPhone(),otp,expireTime);
                appService.registerNewAccount(UserProfileDTOConverter.convertUserSignUpRequestDtoToUserEntity(userSignUpRequestDTO), otp, expireTime);
            }
            //userSignUpRequestDTO.persist(userSignUpRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @PostMapping(value = "/uploadContacts")
    public ResponseEntity<String> uploadContacts(@RequestBody List<GlobalContactDTO> globalContactDTOS) throws TrueCallerBaseException {
        if (globalContactDTOS != null) {
            appService.uploadContacts(UserProfileDTOConverter.convertGlobalContactDtoToUserEntities(globalContactDTOS));
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/search/{phone}/{token}")
    public ResponseEntity<GlobalContactsEntity> searchContact(@PathVariable("phone") String phone, @PathVariable("token") String token) throws TrueCallerBaseException {
        if (token != null && phone != null) {
            appService.searchContact(phone, token);
            // search token from UserSignUp table
        }
        return null;
    }

    private int generateOTP() {
        Random rand = new Random();
        return rand.nextInt((9999 - 100) + 1) + 10;
    }

    /* @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> registerUser(
            @ApiParam(value = "User profile details", required = true) @RequestBody UserSignUpRequestDTO userDTO) throws Exception {
        String token = generateToken();
        UserProfileEntity userProfileEntity = appService.registerNewAccount(userProfileDTOConverterService.convertUserSignUpRequestDtoToUserEntity(userDTO));
        return null;
    }*/

    /* public static String generateToken() {
         return UUID.randomUUID().toString();
     }*/

    @GetMapping("/getSheet")
    public ResponseEntity<String> gethmtlSheet() {
        // appService.convert(file);
        return new ResponseEntity<String>("Response generated successfully...", HttpStatus.OK);
    }


}
