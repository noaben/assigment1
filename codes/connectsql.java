package matalaMunche;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Statement;

public class connectSQL {

	  private String ip;
	  private String url;
	  private String user;
	  private String password;
	  private String tavla;

	  
	  connectSQL (String ip,String url,String user,String password,String tavla){
		  this.ip=ip;
		  this.url="jdbc:mysql://"+ip+":"+url;
		  this.user=user;
		  this.password=password;
		  this.tavla=tavla;
	  }
	  
     
          public LinkedList<Wifi> getData() throws SQLException{
	         Statement st = null;
                 ResultSet rs = null;
	         Connection _con = null;
	         LinkedList<Wifi> list=new  LinkedList<Wifi> ();
	         try{
	            _con = DriverManager.getConnection(url, user, password);
                    st = _con.createStatement();
                    String query="SELECT * FROM "+tavla;
                    rs = st.executeQuery(query);
    
	            while (rs.next()){
		         int wifis_number=Integer.parseInt(rs.getString(7));
		         for (int i=0;i<wifis_number;i++){
		         Wifi w=new Wifi(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),null,rs.getString(8+i*2),null,rs.getString(9+i*2));
		         list.add(w);
		        }
	           }
                 }
	         catch (SQLException el){
		         System.out.println("no connection");
	                }
	         return list;
     
                 }
	
         public String lastModified() throws SQLException{
	         try{
	             Connection _con = null;
	             _con = DriverManager.getConnection(url,user,password);
	             Statement st = null;
	             ResultSet rs = null;
                     st = _con.createStatement();
                     rs = st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
                     if (rs.next()) return rs.getString(1);
	             }
	         catch (SQLException el){
		     System.out.println("no connection");
	             }
	         return null;
                }

//public static void main(String[] args) throws SQLException {
	//connectSQL a=new connectSQL("5.29.193.52","3306/oop_course_ariel","oop1","Lambda1();","ex4_db");
        //LinkedList <Wifi>w1=a.getData();
        //System.out.println(w1.size());
        //a.lastModified();
        //}
}

   




