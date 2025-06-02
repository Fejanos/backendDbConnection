/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package school;
import DAO.TeacherDAO;
import DatabaseConn.DbConnection;
import Model.Teacher;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author János
 */
public class School {

    /**
     * @param args the command line arguments
     */
    
    static List<Teacher> teachers;
    public static void main(String[] args) {
        // Tanárok lekérdezése a DB-ből
        TeacherDAO tdao = new TeacherDAO();
        teachers = tdao.getAllTeachers();
        // Kiírása konzolra
        System.out.println("Tanárok:");
        for(Teacher t : teachers){
            System.out.println(t.getId() + ";" + t.getName() + ";" + t.getSubject());
        }    
        /*
        try{
            Connection conn = DbConnection.getConnection();
            if(conn != null){
                System.out.println("Sikeres kapcsolat!");
                    
                conn.close();
            }
        }
        catch(SQLException e){
            System.out.println("Hiba az adatbázis kapcsolódása során!");
            e.printStackTrace();
        }
        */
    }
    
}
