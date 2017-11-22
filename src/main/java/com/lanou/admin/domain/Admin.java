package com.lanou.admin.domain;

import com.lanou.role.domain.Role;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/11/20.
 */
public class Admin {

    private Integer admin_id;
    private String admin_code;
    private String password;
    private String name;
    private String telephone;
    private String email;
    private Timestamp enrolldate;

    private List<Role> roless = new ArrayList<Role>();

    public List<Role> getRoless() {
        return roless;
    }

    public void setRoless(List<Role> roless) {
        this.roless = roless;
    }

    public Admin() {
    }

    public Admin(String admin_code, String password) {
        this.admin_code = admin_code;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_code='" + admin_code + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrolldate +
                '}';
    }

    public Timestamp getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Timestamp enrolldate) {
        this.enrolldate = enrolldate;
    }

    public Admin(Integer admin_id, String admin_code, String password, String name, String telephone, String email, Timestamp enrolldate) {
        this.admin_id = admin_id;
        this.admin_code = admin_code;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_code() {
        return admin_code;
    }

    public void setAdmin_code(String admin_code) {
        this.admin_code = admin_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
