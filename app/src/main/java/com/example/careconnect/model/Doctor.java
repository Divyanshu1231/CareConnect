package com.example.careconnect.model;

import java.io.Serializable;

public class Doctor implements Serializable {

    private static final String DEFAULT_EXPERIENCE = "5 yrs";
    private static final String DEFAULT_RATING = "4.5";
    private static final int DEFAULT_IMAGE = 0;

    public String name;
    public String specialization;
    public String hospital;
    public String fee;

    // 🔥 New fields
    public String experience;
    public String rating;
    public int image;

    public Doctor(String name, String specialization, String hospital, String fee,
                  String experience, String rating, int image) {

        this.name = name;
        this.specialization = specialization;
        this.hospital = hospital;
        this.fee = fee;
        this.experience = experience;
        this.rating = rating;
        this.image = image;
    }

    public Doctor(String name, String specialization, String hospital, String fee) {
        this(name, specialization, hospital, fee,
                DEFAULT_EXPERIENCE, DEFAULT_RATING, DEFAULT_IMAGE);
    }
}
