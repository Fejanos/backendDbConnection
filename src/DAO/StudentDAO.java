/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DatabaseConn.DbConnection;
import Model.Student;
import Model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author János
 */
public class StudentDAO {
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>(); // Üres lista
        
        try{
            Connection conn = DbConnection.getConnection(); // Kapcsolat nyitás
            // SQL utasítás előkészítése
            String sql = "SELECT * FROM student INNER JOIN teacher t ON teacher_id = t.id";
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
                        results.getInt("t.id"),
                        results.getString("t.name"),
                        results.getString("t.subjects")
                );
                // Új diák objektum
                Student s = new Student(
                        // tábla mezői
                        results.getInt("id"),
                        results.getString("name"),
                        results.getDate("born"),
                        t
                );
                // Listához fűzom
                students.add(s);
            }
            conn.close(); // Kapcsolat bezárása
        }
        catch(Exception ex){
            System.err.println("Hiba: " + ex.getMessage());
            ex.printStackTrace();
        }
        return students;
    }
}
