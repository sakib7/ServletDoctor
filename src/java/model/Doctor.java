/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sakib
 */
public class Doctor {
    private int id;
    private String name;
    private String speciality;
    private String hospital;
    private String designation;
    private String username;
    private String password;
    private String chamberAddress;
    private String visitingTime;
    private int patientPerDay;
    private double fee;

    public Doctor(int id, String name, String speciality, String hospital, String designation, String username, String password) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.hospital = hospital;
        this.designation = designation;
        this.username = username;
        this.password = password;
    }

    public Doctor(int id, String name, String speciality, String hospital, String designation, String username, String password, String chamberAddress, String visitingTime, int patientPerDay, double fee) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.hospital = hospital;
        this.designation = designation;
        this.username = username;
        this.password = password;
        this.chamberAddress = chamberAddress;
        this.visitingTime = visitingTime;
        this.patientPerDay = patientPerDay;
        this.fee = fee;
    }

    public Doctor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChamberAddress() {
        return chamberAddress;
    }

    public void setChamberAddress(String chamberAddress) {
        this.chamberAddress = chamberAddress;
    }

    public String getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(String visitingTime) {
        this.visitingTime = visitingTime;
    }

    public int getPatientPerDay() {
        return patientPerDay;
    }

    public void setPatientPerDay(int patientPerDay) {
        this.patientPerDay = patientPerDay;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
    
}
