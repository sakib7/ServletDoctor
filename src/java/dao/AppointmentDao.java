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
import model.Appointment;

/**
 *
 * @author sakib
 */
public class AppointmentDao {
    private Connection connection;

    public AppointmentDao() {
        connection = DatabaseDriver.connect();
    }
    
    public int insert(String visiting_date, int serial, String name, String contact_number, int patient_id, int doctor_id) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int rows_affected = 0;
        try {
            String sql = "INSERT INTO appointment(visiting_date,serial,name,contact_num,patient_id,doctor_id) VALUES(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, visiting_date);
            preparedStatement.setInt(2, serial);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, contact_number);
            preparedStatement.setInt(5, patient_id);
            preparedStatement.setInt(6, doctor_id);
            rows_affected = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows_affected;
    }
    
    public int getBookedSlot(int doctor_id,String visiting_date){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int remaining = 0;
        try {
            String sql = "SELECT count(id) FROM appointment WHERE visiting_date=? AND doctor_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, visiting_date);
            preparedStatement.setInt(2, doctor_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                remaining = resultSet.getInt("count(id)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remaining;
    }
    
    public List<Appointment> getPatientBookings(int doctor_id){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Appointment> appointments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM appointment WHERE doctor_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, doctor_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                String visitingDate = resultSet.getString("visiting_date");
                int serial = resultSet.getInt("serial");
                String name = resultSet.getString("name");
                String contactNumber = resultSet.getString("contact_num");
                Appointment appointment = new Appointment();
                appointment.setSerial(serial);
                appointment.setName(name);
                appointment.setVisitingDate(visitingDate);
                appointment.setContactNumber(contactNumber);
                appointments.add(appointment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointments;
    }
    
    public List<Appointment> getDoctorAppointments(int patient_id){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Appointment> appointments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM appointment INNER JOIN doctor ON doctor_id=doctor.id WHERE patient_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patient_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                String visitingDate = resultSet.getString("visiting_date");
                int serial = resultSet.getInt("serial");
                String name = resultSet.getString("doctor.name");
                Appointment appointment = new Appointment();
                appointment.setSerial(serial);
                appointment.setDoctorName(name);
                appointment.setVisitingDate(visitingDate);
                appointments.add(appointment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
