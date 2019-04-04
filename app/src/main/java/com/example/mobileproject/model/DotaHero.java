package com.example.mobileproject.model;

import com.example.mobileproject.rolesConverter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
public class DotaHero {
    @PrimaryKey
    private int id;
    private String name;
    private String localized_name;
    private String primary_attr;
    private String attack_type;
    @TypeConverters(rolesConverter.class)
    private String roles[];
    private String img;
    private String icon;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public String getPrimary_attr() {
        return primary_attr;
    }

    public String getAttack_type() {
        return attack_type;
    }


    public String getImg() {
        return "https://api.opendota.com" + img;
    }

    public String getIcon() {
        return "https://api.opendota.com" + icon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocalized_name(String localized_name) {
        this.localized_name = localized_name;
    }

    public void setPrimary_attr(String primary_attr) {
        this.primary_attr = primary_attr;
    }

    public void setAttack_type(String attack_type) {
        this.attack_type = attack_type;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String[] getRoles() {
        return roles;
    }
}
