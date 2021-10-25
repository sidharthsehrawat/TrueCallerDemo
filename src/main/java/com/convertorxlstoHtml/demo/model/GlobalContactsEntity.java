package com.convertorxlstoHtml.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "global_contacts")
@Table(name = "global_contacts")
public class GlobalContactsEntity {

    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phone", nullable = false, length = 100, unique = true)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<UserToPersonalContactsEntity> userToPersonalContactsEntities;

    public GlobalContactsEntity(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public GlobalContactsEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "GlobalContacts{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
