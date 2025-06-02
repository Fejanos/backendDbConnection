/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package school;
import DAO.StudentDAO;
import DAO.TeacherDAO;
import DatabaseConn.DbConnection;
import Model.Student;
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
    static List<Student> students;
    public static void main(String[] args) {
        // Tanárok lekérdezése a DB-ből
        TeacherDAO tdao = new TeacherDAO();
        teachers = tdao.getAllTeachers();
        // Kiírása konzolra
        System.out.println("Tanárok:");
        for(Teacher t : teachers){
            System.out.println(t.getId() + ";" + t.getName() + ";" + t.getSubject());
        }    
        
        // Diákok lekérdezése DB-ből
        StudentDAO sdao = new StudentDAO();
        students = sdao.getAllStudents();
        // Kiírás konzolra
        System.out.println("Diákok és hozzájuk tartozó tanárok neve:");
        for(Student s : students){
            System.out.println(s.getId() + ";" + s.getName() + ";" + s.getBorn() + ";" 
                    + s.getTeacher().getName());
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
