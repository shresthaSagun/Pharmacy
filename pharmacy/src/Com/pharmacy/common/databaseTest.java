package Com.pharmacy.common;

import Com.pharmacy.view.adminUI;
import java.sql.*;


public class databaseTest {
	final static String db_name="hbk";
	final static String DATABASE_URL = "jdbc:mysql://localhost:3306/";
    static Connection connection = null;
    static Connection connection1 = null;
    static Statement statement = null;
    public static void createTable() throws SQLException{
    	String bill="CREATE TABLE `bill` (\r\n" + 
    			" `billno` int(11) NOT NULL,\r\n" + 
    			" `item` varchar(30) NOT NULL,\r\n" + 
    			" `qtysold` int(11) NOT NULL,\r\n" + 
    			" `exp_month` varchar(30) NOT NULL,\r\n" + 
    			" `exp_year` varchar(30) NOT NULL,\r\n" + 
    			" `rate` double NOT NULL,\r\n" + 
    			" `amount` double NOT NULL,\r\n" + 
    			" `date` date NOT NULL\r\n" + 
    			")";
    	String drug="CREATE TABLE `drug` (\r\n" + 
    			" `id` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
    			" `name` varchar(30) NOT NULL,\r\n" + 
    			" `rate` double NOT NULL,\r\n" + 
    			" `qty` int(11) NOT NULL,\r\n" + 
    			" `exp_month` varchar(30) NOT NULL,\r\n" + 
    			" `exp_year` varchar(30) NOT NULL,\r\n" + 
    			" `sample_month` int(11) NOT NULL,\r\n" + 
    			" PRIMARY KEY (`id`)\r\n" + 
    			") ";
    	String login="CREATE TABLE `login` (\r\n" + 
    			" `id` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
    			" `username` varchar(30) NOT NULL,\r\n" + 
    			" `password` varchar(30) NOT NULL,\r\n" + 
    			" PRIMARY KEY (`id`)\r\n" + 
    			")";
    	String sales="CREATE TABLE `sales` (\r\n" + 
    			" `billno` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
    			" `sn` int(11) NOT NULL,\r\n" + 
    			" `item` varchar(30) NOT NULL,\r\n" + 
    			" `qtysold` int(11) NOT NULL,\r\n" + 
    			" `exp_month` varchar(30) NOT NULL,\r\n" + 
    			" `exp_year` varchar(30) NOT NULL,\r\n" + 
    			" `rate` double NOT NULL,\r\n" + 
    			" `amount` double NOT NULL,\r\n" + 
    			" `date` date NOT NULL,\r\n" + 
    			" PRIMARY KEY (`billno`)\r\n" + 
    			") ";
    	Statement stm1= connection1.createStatement();
    	stm1.executeUpdate(bill);
    	stm1.executeUpdate(drug);
    	stm1.executeUpdate(login);
    	stm1.executeUpdate(sales);
    	
    }
    public static boolean createDatabase() throws SQLException{
    	String query="create database if not exists "+db_name;
    	Statement stm= connection.createStatement();
    	int p=stm.executeUpdate(query);
//    	System.out.println(p);
    	if(p==0) {
    	//	System.out.println("database exits");
                
                return true;
    	}else {
    	  // 	System.out.println("Database created");   
    	   	connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hbk", "root", "");
    	   	createTable();
                new adminUI();
            return false;
    	}
 
    }
 
    public boolean checkForDb(){
        
	boolean a=false;
		 try {
	            DriverManager.setLoginTimeout(23);
	            connection = DriverManager.getConnection(DATABASE_URL, "root", "");

	            a= createDatabase();//true if db exists else returns false
	        } catch (SQLException ex) {
	            System.out.println("The following exception has occured: " + ex.getMessage());
	        } finally {

	            try {
	                if (connection != null) {
	                    connection.close();
	                }
	                if (connection1 != null) {
	                    connection1.close();
	                }
	                if (statement != null) {
	                    statement.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println("The following exception has occured: " + ex.getMessage());
	            }
	        }
		
		return a;
	
    }
    public databaseTest(){
        
    	
	}
	
}
