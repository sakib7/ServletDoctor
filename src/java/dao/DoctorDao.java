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
import java.util.ArrayList;
import java.util.List;
import model.Doctor;
import model.Patient;

/**
 *
 * @author sakib
 */
public class DoctorDao {

    private Connection connection;

    public DoctorDao() {
        connection = DatabaseDriver.connect();
    }

    public int insert(String name,String speciality,String hospital,String designation,String username,String password) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int rows_affected = 0;
        try {
            String sql = "INSERT INTO doctor(name,speciality,hospital,designation,username,password) VALUES(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, speciality);
            preparedStatement.setString(3, hospital);
            preparedStatement.setString(4, designation);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);
            rows_affected = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows_affected;
    }
    
    public Doctor getDoctor(String username, String password){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Doctor doctor = null;
        try {
            String sql = "SELECT * FROM doctor WHERE username=? AND password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String speciality = resultSet.getString("speciality");
                String hospital = resultSet.getString("hospital");
                String designation = resultSet.getString("designation");
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String chamber_address = resultSet.getString("chamber_address");
                String visiting_time = resultSet.getString("visiting_time");
                int patient_per_day = resultSet.getInt("patient_per_day");
                double fee = resultSet.getDouble("fee");
                doctor = new Doctor(id, name, speciality, hospital, designation, username, password, chamber_address, visiting_time,patient_per_day,fee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }
    
    public Doctor getDoctor(String username){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Doctor doctor = null;
        try {
            String sql = "SELECT * FROM doctor WHERE username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String speciality = resultSet.getString("speciality");
                String hospital = resultSet.getString("hospital");
                String designation = resultSet.getString("designation");
                String user = resultSet.getString("username");
                String password = resultSet.getString("password");
                String chamber_address = resultSet.getString("chamber_address");
                String visiting_time = resultSet.getString("visiting_time");
                int patient_per_day = resultSet.getInt("patient_per_day");
                double fee = resultSet.getDouble("fee");
                doctor = new Doctor(id, name, speciality, hospital, designation, username, password, chamber_address, visiting_time,patient_per_day,fee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }
    public Doctor getDoctor(int id){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Doctor doctor = null;
        try {
            String sql = "SELECT * FROM doctor WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {     
                String name = resultSet.getString("name");
                String speciality = resultSet.getString("speciality");
                String hospital = resultSet.getString("hospital");
                String designation = resultSet.getString("designation");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String chamber_address = resultSet.getString("chamber_address");
                String visiting_time = resultSet.getString("visiting_time");
                int patient_per_day = resultSet.getInt("patient_per_day");
                double fee = resultSet.getDouble("fee");
                doctor = new Doctor(id, name, speciality, hospital, designation, username, password, chamber_address, visiting_time,patient_per_day,fee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }
    
    public List<Doctor> getDoctorList(){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Doctor> doctorList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM doctor";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String speciality = resultSet.getString("speciality");
                String hospital = resultSet.getString("hospital");
                String designation = resultSet.getString("designation");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String chamber_address = resultSet.getString("chamber_address");
                String visiting_time = resultSet.getString("visiting_time");
                int patient_per_day = resultSet.getInt("patient_per_day");
                double fee = resultSet.getDouble("fee");
                Doctor doctor = new Doctor(id, name, speciality, hospital, designation, username, password, chamber_address, visiting_time,patient_per_day,fee);
                doctorList.add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;
    }
    
    public int update(String name,String speciality,String hospital,String designation,String username,String password,
                        String chamberAddress, String visitingTime,int patientsPerDay,double fee){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int rows_affected = 0;
        try {
            String sql = "UPDATE doctor SET name=?,speciality=?,hospital=?,designation=?,password=?,chamber_address=?,visiting_time=?,patient_per_day=?,fee=? WHERE username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, speciality);
            preparedStatement.setString(3, hospital);
            preparedStatement.setString(4, designation);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, chamberAddress);
            preparedStatement.setString(7, visitingTime);
            preparedStatement.setInt(8, patientsPerDay);
            preparedStatement.setDouble(9, fee);
            preparedStatement.setString(10, username);
            rows_affected = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows_affected;
    }
}
