/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import classifier.KNN;

/**
 *
 * @author sakib
 */
public class Patient {
    private int id;
    private String name;
    private String phone;
    private String username;
    private String password;
    private int pregnancies;
    private int glucose;
    private int bloodPressure;
    private int skinThickness;
    private int insulin;
    private double pedigreeFunction;
    private int height;
    private int weight;
    private int age;
    

    public Patient() {
    }

    public Patient(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getPregnancies() {
        return pregnancies;
    }

    public void setPregnancies(int pregnancies) {
        this.pregnancies = pregnancies;
    }

    public int getGlucose() {
        return glucose;
    }

    public void setGlucose(int glucose) {
        this.glucose = glucose;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getSkinThickness() {
        return skinThickness;
    }

    public void setSkinThickness(int skinThickness) {
        this.skinThickness = skinThickness;
    }

    public int getInsulin() {
        return insulin;
    }

    public void setInsulin(int insulin) {
        this.insulin = insulin;
    }

    public double getPedigreeFunction() {
        return pedigreeFunction;
    }

    public void setPedigreeFunction(double pedigreeFunction) {
        this.pedigreeFunction = pedigreeFunction;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getOutcome(){
        String output = "";
        KNN knn = new KNN();
        int category = knn.getCategory(pregnancies, glucose, bloodPressure, skinThickness, insulin, height*weight, pedigreeFunction, age);
        if(category == 1){
            output = "True";
        } else{
            output = "False";
        }
        return output;
    }
}
