package com.convertorxlstoHtml.demo.model;

import javax.persistence.*;
import java.util.Set;

public class UserToPersonalContactsEntity {

    @Id
    @Column(name = "rid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rid;
    @Column(name = "name", nullable = false, length = 100)
    private String name;


    @ManyToMany(targetEntity = GlobalContactsEntity.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "user_contacts", joinColumns = {@JoinColumn(name = "rid")}, inverseJoinColumns = {@JoinColumn(name = "pid")})
    private Set<GlobalContactsEntity> globalContactsEntities;

    public UserToPersonalContactsEntity(long rid, String name, Set<GlobalContactsEntity> globalContactsEntities) {
        this.rid = rid;
        this.name = name;
        this.globalContactsEntities = globalContactsEntities;
    }

    public UserToPersonalContactsEntity() {
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GlobalContactsEntity> getPersonalContacts() {
        return globalContactsEntities;
    }

    public void setPersonalContacts(Set<GlobalContactsEntity> personalContacts) {
        this.globalContactsEntities = personalContacts;
    }

    @Override
    public String toString() {
        return "UserToPersonalContactsEntity{" +
                "rid=" + rid +
                ", name='" + name + '\'' +
                ", personalContacts=" + globalContactsEntities +
                '}';
    }
}
