/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package school;
import DatabaseConn.DbConnection;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author János
 */
public class School {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    }
    
}
