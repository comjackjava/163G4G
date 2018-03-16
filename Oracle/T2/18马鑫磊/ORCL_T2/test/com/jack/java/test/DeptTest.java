package com.jack.java.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.jack.java.bean.Dept;
import com.jack.java.utils.DBUtils;

public class DeptTest {
	private Connection con;
@Test
public void getDept() throws SQLException {
	con=DBUtils.getConnection();
	String sql ="select * from dept";
	PreparedStatement ps =con.prepareStatement(sql);
	ResultSet rs =ps.executeQuery();
	
	while(rs.next()) {
		Dept dept =new Dept(
				rs.getInt("DEPTNO"),
				rs.getString("DNAME"),
				rs.getString("LOC")
				);
		System.out.println("输出");
		System.out.println(dept.toString());
		
	}
}
}
