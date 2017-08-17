package com.mycomp.shapes;

import com.mycomp.dao.JDBCDaoImpl;
import com.mycomp.model.Circle;

public class JDBCDemo {

	public static void main (String args[]){
		
		Circle circle = new JDBCDaoImpl().getCircle(1);
		System.out.println("circle name = " + circle.getName());
	}
}
