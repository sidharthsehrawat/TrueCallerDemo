package com.convertorxlstoHtml.demo.model;

import javax.persistence.*;

@Entity(name = "user_profile")
@Table(name = "user_profile")
public class UserProfileEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phone", nullable = false, length = 100, unique = true)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "token", length = 50)
    private String token;

    public UserProfileEntity(long id, String name, String phone, String email, String token) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserProfileEntity(String name, String phone, String email, String token) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.token = token;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public UserProfileEntity(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public UserProfileEntity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public UserProfileEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserProfileEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
