package com.example.mobileproject;

public class DotaHeroes {
    private String name;
    private String localized_name;
    private String primary_attr;
    private String attack_type;
    private String roles[];


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalized_name() {
        return localized_name;
    }

    public void setLocalized_name(String localized_name) {
        this.localized_name = localized_name;
    }

    public String getPrimary_attr() {
        return primary_attr;
    }

    public void setPrimary_attr(String primary_attr) {
        this.primary_attr = primary_attr;
    }

    public String getAttack_type() {
        return attack_type;
    }

    public void setAttack_type(String attack_type) {
        this.attack_type = attack_type;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String roles[]) {
        this.roles = roles;
    }
}
