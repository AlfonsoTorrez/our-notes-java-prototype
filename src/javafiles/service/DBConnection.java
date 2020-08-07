package javafiles.service;
import java.sql.*;


public class DBConnection {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String currUser = "hacker";

    //Connecting to our SQLdb
    public DBConnection(){
        //Will attempt to connect to our MySQL DB
        //Needs to be in a Try-Catch
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/our_notes?useSSL=false&serverTimezone=UTC#","root","Torrez11%");
            stmt = conn.createStatement();
        }catch(Exception e1) {
            System.out.println(e1);
        }

    }

    //Obtain user name
    public String getCurrUser(){
        return currUser;
    }

    //Displays all rows of the table
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

    //Checking if the user exists
    //TODO:: pop-up for incorrect info
    //TODO:: Email verification (random number) (2-auth)
    public boolean authenticate(String username, String password){
        String query = "SELECT * FROM users WHERE username = '"+username+"' AND password = '"+password+"';";
        try{
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                System.out.println("Welcome!");
                currUser = rs.getString("first_name");
                return true;
            }
            System.out.println("NOPE!");
            return false;

        }catch(Exception e1) {
            System.out.println(e1);
        }
        return false;
    }

}
