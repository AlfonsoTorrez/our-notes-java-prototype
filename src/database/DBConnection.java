package database;
import java.sql.*;


public class DBConnection {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public DBConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/our_notes?useSSL=false&serverTimezone=UTC#","root","Torrez11%");
            stmt = conn.createStatement();
        }catch(Exception e1) {
            System.out.println(e1);
        }

    }
    //Take query to display
    public void getRows() {
        String query = "SELECT * FROM users;";
        try {
            rs = stmt.executeQuery(query);
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("user_id");
                String uName = rs.getString("username");
                String pass = rs.getString("password");
                String fName = rs.getString("first_name");
                String email = rs.getString("email");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Username: " + uName);
                System.out.print(", Password: " + pass);
                System.out.print(", First Name: " + fName);
                System.out.println(", Email: " + email);
            }
            rs.close();
        }catch(Exception e1) {
            System.out.println(e1);
        }
    }

}
