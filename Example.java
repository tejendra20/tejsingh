import java.sql.*;


public class Example {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
  static final String DB_URL = "jdbc:mysql://localhost/play_db";
  static final String USER = "root";
  static final String PASS = "root";

  static Connection connection = null;
  static Statement statement = null;
  static ResultSet result = null;

  // for connection to Mysql Server
  public static void connect(){

    try {
      Class.forName(JDBC_DRIVER);
      connection = DriverManager.getConnection(DB_URL,USER,PASS);
    }
    catch (Exception e) {
      System.out.println("On Mysql Server :" + e.getMessage());
    }

  }

  // Update Tables
  public static void  executeUpdate(String sql){

System.out.println("----"+sql);
    if(connection == null)
      connect();
System.out.println("----1"+sql);
    try {
      statement = connection.createStatement();
      System.out.println("----2"+sql);
      statement.executeUpdate(sql);
      System.out.println("----3"+sql);
    }
    catch (SQLException e) {
      e.printStackTrace();

    }
 
  }
  
  public static void main(String[] args){
  
 	executeUpdate("INSERT INTO emotionT values ('as','9.0','false')");
 	 	
  }


}  

