package com.example.mobileproject.model;

public class DotaHero {
    private int id;
    private String name;
    private String localized_name;
    private String primary_attr;
    private String attack_type;
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

    public String[] getRoles() {
        return roles;
    }

    public String getImg() {
        return "https://api.opendota.com" + img;
    }

    public String getIcon() {
        return "https://api.opendota.com" + icon;
    }
}
