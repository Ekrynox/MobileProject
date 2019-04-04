package com.example.mobileproject;

import androidx.room.TypeConverter;

public class rolesConverter {
    @TypeConverter
    public static String[] toArray(String roles) {
        return roles.split(";");
    }

    @TypeConverter
    public static String toString(String roles[]) {
        return String.join(";", roles);
    }
}
