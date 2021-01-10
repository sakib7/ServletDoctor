/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classifier;

import dao.DatabaseDriver;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import model.Patient;

/**
 *
 * @author sakib
 */
public class KNN {

    public static void main(String[] args) {
        KNN knn = new KNN();
        System.out.println(knn.getCategory(4,99,68,38,0,32.8,0.145,33));
    }

    private double[] preg, glucose, bp, skin, insulin, bmi, pedi, age, dist;
    private int[] category, sequence;
    private int i, j, neighbors, category_1, category_0, output_label, temp_int;
    private double temp_double;

    public int getCategory(double test_preg, double test_glucose, double test_bp, double test_skin,
            double test_insulin, double test_bmi, double test_pedi, double test_age) {
        preg = new double[2000];
        glucose = new double[2000];
        bp = new double[2000];
        skin = new double[2000];
        insulin = new double[2000];
        bmi = new double[2000];
        pedi = new double[2000];
        age = new double[2000];
        dist = new double[2000];
        category = new int[2000];
        sequence = new int[2000];
        readData();
        neighbors = 9;
        for (i = 0; i < 2000; i++) {
            dist[i] = Math.sqrt((preg[i] - test_preg) * (preg[i] - test_preg)
                    + (glucose[i] - test_glucose) * (glucose[i] - test_glucose)
                    + (bp[i] - test_bp) * (bp[i] - test_bp)
                    + (skin[i] - test_skin) * (skin[i] - test_skin)
                    + (insulin[i] - test_insulin) * (insulin[i] - test_insulin)
                    + (bmi[i] - test_bmi) * (bmi[i] - test_bmi)
                    + (pedi[i] - test_pedi) * (pedi[i] - test_pedi)
                    + (age[i] - test_age) * (age[i] - test_age)
            );
        }
        for (i = 0; i < 2000 - 1; i++) {
            for (j = i + 1; j < 2000; j++) {
                if (dist[i] > dist[j]) {
                    temp_double = dist[i];
                    dist[i] = dist[j];
                    dist[j] = temp_double;
                    temp_int = sequence[i];
                    sequence[i] = sequence[j];
                    sequence[j] = temp_int;
                }
            }
        }

        category_1 = 0;
        category_0 = 0;
        for (i = 0; i < neighbors; i++) {
            if (category[sequence[i]] == 1) {
                category_1++;
            } else {
                category_0++;
            }
        }
        if (category_1 > category_0) {
            output_label = 1;
        } else {
            output_label = 0;
        }

        return output_label;
    }

    public void readData() {
        Connection connection = DatabaseDriver.connect();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Patient patient = null;
        try {
            String sql = "SELECT * FROM dataset";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                sequence[i] = i;
                preg[i] = Double.valueOf(resultSet.getString("Pregnancies"));
                glucose[i] = resultSet.getDouble("Glucose");
                bp[i] = resultSet.getDouble("BloodPressure");
                skin[i] = resultSet.getDouble("SkinThickness");
                insulin[i] = resultSet.getDouble("Insulin");
                bmi[i] = resultSet.getDouble("BMI");
                pedi[i] = resultSet.getDouble("DiabetesPedigreeFunction");
                age[i] = resultSet.getDouble("Age");
                category[i] = resultSet.getInt("Outcome");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
