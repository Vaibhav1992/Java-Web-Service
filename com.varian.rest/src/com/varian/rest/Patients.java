package com.varian.rest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.lang.String;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.omg.CORBA.Request;

import javax.servlet.http.HttpServletRequestWrapper;

import java.util.List;

@Path("/patients")

public class Patients {
	@GET
	@Produces(MediaType.TEXT_PLAIN) 
	public String returnName() {
		List<String> myList = new ArrayList<String>();
		try {
			JSONObject obj = new JSONObject();
			
			Class.forName("com.mysql.jdbc.Driver"); 
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/varian","root","Vai@1234"); 
			Statement st= con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from usernames");
			while(rs.next()) 
			{  
				  obj.put("name", rs.getString("name"));
				  myList.add(obj.toString());
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage() );
		}
		return myList.toString();	
	}
	
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public void savename(String incomingData) {
		try {	
			JSONObject json = new JSONObject(incomingData);
			
			Class.forName("com.mysql.jdbc.Driver"); 

			/*A connection (session) with a specific database. SQL statements are executed and results are returned within the context of a connection*/
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/varian","root","Vai@1234"); 

			/*The object ST is used for executing a static SQL statement and returning the results it produces.*/
			Statement st= con.createStatement();
		

			st.executeUpdate("insert into usernames value ('"+json.getString("message")+"')");
			st.close();
			con.close();
			

		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
}
