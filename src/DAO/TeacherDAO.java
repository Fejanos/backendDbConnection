/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DatabaseConn.DbConnection;
import Model.Teacher;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author János
 */
public class TeacherDAO {
    public List<Teacher> getAllTeachers(){
        List<Teacher> teachers = new ArrayList<>(); // Üres lista
        
        try{
            Connection conn = DbConnection.getConnection(); // Kapcsolat nyitás
            // SQL utasítás előkészítése
            String sql = "SELECT * FROM teacher";
            // "Előkészítés" - biztonságos lekérdezés
            //var prepared = conn.prepareStatement(sql);
            PreparedStatement prepared = conn.prepareStatement(sql);
            // Végrehajt
            ResultSet results = prepared.executeQuery();
            
            // Lista feltöltése a kapott eredményekkel
            while(results.next()){
                // Új teacher objektum
                Teacher t = new Teacher(
                        // tábla mezőinek neve alapján
                        results.getInt("id"),
                        results.getString("name"),
                        results.getString("subjects")
                );
                // Listához fűzom
                teachers.add(t);
            }
            conn.close(); // Kapcsolat bezárása
        }
        catch(Exception ex){
            System.err.println("Hiba: " + ex.getMessage());
            ex.printStackTrace();
        }
        return teachers;
    }
}
