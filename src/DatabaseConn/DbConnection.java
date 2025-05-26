/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author János
 */
public class DbConnection {
    // url = protokoll/driver + sajátgép localhost + mysql port + db neve
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // MAMP esetén
    
    public static Connection getConnection() throws SQLException{
        // DriverManager felelős kapcsolatért
        // 3 paraméter: url, felhasználó és a jelszava
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
