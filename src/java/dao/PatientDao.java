/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Patient;

/**
 *
 * @author sakib
 */
public class PatientDao {
    
    private Connection connection;

    public PatientDao() {
        connection = DatabaseDriver.connect();
    }
    
    public Patient getPatient(String username, String password){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Patient patient = null;
        try {
            String sql = "SELECT * FROM patient WHERE username=? AND password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                patient = new Patient();
                patient.setId(id);
                patient.setName(name);
                patient.setPhone(phone);
                patient.setUsername(user);
                patient.setPassword(pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }
    
    public Patient getPatient(String username){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Patient patient = null;
        try {
            String sql = "SELECT * FROM patient WHERE username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                int preg = resultSet.getInt("pregnancies");
                int glucose = resultSet.getInt("glucose");
                int bloodPressure = resultSet.getInt("bloodPressure");
                int skinThickness = resultSet.getInt("skinThickness");
                int insulin = resultSet.getInt("insulin");
                double pedigreeFunction = resultSet.getDouble("pedigreeFunction");
                int height = resultSet.getInt("height");
                int weight = resultSet.getInt("weight");
                int age = resultSet.getInt("age");
                patient = new Patient();
                patient.setId(id);
                patient.setName(name);
                patient.setPhone(phone);
                patient.setUsername(user);
                patient.setPassword(pass);
                patient.setPregnancies(preg);
                patient.setGlucose(glucose);
                patient.setBloodPressure(bloodPressure);
                patient.setSkinThickness(skinThickness);
                patient.setInsulin(insulin);
                patient.setPedigreeFunction(pedigreeFunction);
                patient.setHeight(height);
                patient.setWeight(weight);
                patient.setAge(age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }
    
    public int insert(String name, String phone, String username, String password){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int rows_affected = 0;
        try {
            String sql = "INSERT INTO patient(name,phone,username,password) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);
            rows_affected = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows_affected;
    }
    
    public int update(String name, String phone, String username, String password){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int rows_affected = 0;
        try {
            String sql = "UPDATE patient SET name=?,phone=?,password=? WHERE username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, username);
            rows_affected = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows_affected;
    }
    
    public int update(int preg, int glucose, int bp, int sk, int insulin, 
            double dpf, int height, int weight,int age,String username){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int rows_affected = 0;
        try {
            String sql = "UPDATE patient SET pregnancies=?,glucose=?,bloodPressure=?,skinThickness=?,insulin=?,pedigreeFunction=?,height=?,weight=?,age=? WHERE username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, preg);
            preparedStatement.setInt(2, glucose);
            preparedStatement.setInt(3, bp);
            preparedStatement.setInt(4, sk);
            preparedStatement.setInt(5, insulin);
            preparedStatement.setDouble(6, dpf);
            preparedStatement.setInt(7, height);
            preparedStatement.setInt(8, weight);
            preparedStatement.setInt(9, age);
            preparedStatement.setString(10, username);
            rows_affected = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows_affected;
    }
    
}
