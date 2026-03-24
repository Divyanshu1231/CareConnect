package com.example.careconnect.model;

public class Doctor {

    public String name;
    public String specialization;
    public String hospital;
    public String fee;

    public Doctor(String name, String specialization, String hospital, String fee) {
        this.name = name;
        this.specialization = specialization;
        this.hospital = hospital;
        this.fee = fee;
    }
}