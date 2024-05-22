package Connection;

import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    
    public static DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public DatabaseConnection(){
        
    }
    
    public void connectToDatabase() throws SQLException{
        final String url = "jdbc:oracle:thin:@localhost:1521:oracle";
        final String username = "MYDAtABASE";
        final String password = "123";
        
        connection = (Connection) java.sql.DriverManager.getConnection(url, username, password);
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void getConnection(Connection connection){
        this.connection = connection;
    }
}
