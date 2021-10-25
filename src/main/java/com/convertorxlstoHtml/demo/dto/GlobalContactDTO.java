package com.convertorxlstoHtml.demo.dto;

public class GlobalContactDTO {
    private long pid;
    private String name;
    private String phone;
    private String email;

    public GlobalContactDTO(long pid, String name, String phone, String email) {
        this.pid = pid;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public GlobalContactDTO() {
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
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
        return "GlobalContactDTO{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
