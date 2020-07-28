import java.sql.*; 

public class Main {

	public static void main(String[] args) {
		System.out.println("Right now I am connecting my database."); 
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/our_notes?useSSL=false&serverTimezone=UTC#","root","Torrez11%");
			//PreparedStatement ps = conn.prepareStatement("SELECT * FROM users;");
			//boolean x = ps.execute(); 
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users;"); 
			
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
//			if(x) {
//				System.out.println("Registration done successfully..."); 
//			}else {
//				System.out.println("Registration Failed..."); 
//			}
			
		}catch(Exception e1) {
			System.out.println(e1); 
		}
		
	}

}
