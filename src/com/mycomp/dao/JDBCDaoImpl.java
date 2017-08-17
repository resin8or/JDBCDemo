package com.mycomp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycomp.model.Circle;

public class JDBCDaoImpl {

	public Circle getCircle(int circleId){
		//return new Circle(circleId);
		Connection conn = null;
		Circle circle = null;
		String driver = "org,apache.derby.jdbc.ClientDriver";
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
			ps.setInt(1,  circleId);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				
				circle = new Circle(circleId, rs.getString("name"));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
		return circle;
		
	}
	
	
}
