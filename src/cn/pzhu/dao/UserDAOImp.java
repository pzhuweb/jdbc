package cn.pzhu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.pzhu.pojo.User;
import cn.pzhu.util.DBUtil;

public class UserDAOImp implements UserDAO{

	@Override
	public boolean add(User data) {
		boolean flag = false;
		String sql = "INSERT INTO USER (NAME, PASSWORD) VALUES (?,?)";
		Connection con = null;
		PreparedStatement sta = null;
		
		con = DBUtil.getConnection();
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, data.getName());
			sta.setString(2, data.getPassword());			
			int i = sta.executeUpdate();
			if (i>0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User select(String id) {
		User user = null;
		Connection con =  DBUtil.getConnection();
		String sql = "SELECT * FROM USER WHERE NAME = ?"; 
		PreparedStatement psta =null;
		try {
			psta = con.prepareStatement(sql);
			psta.setString(1, id);
			ResultSet res = psta.executeQuery();
			if (res.next()) {
				user = new User(id,res.getString(2));
			}
			DBUtil.close(con, psta, res);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return user;
	}

	@Override
	public boolean update(User data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(User user) {
		boolean flag  = false;
		Connection con =  DBUtil.getConnection();
		String sql = "SELECT * FROM USER WHERE NAME ='"+user.getName()+"' AND PASSWORD = '"+user.getPassword()+"'"; 
		Statement psta =null;
		try {
			psta = con.createStatement();			
			ResultSet res = psta.executeQuery(sql);
			if (res.next()) {
				flag = true;
			} else {
				flag = false;
			}
			DBUtil.close(con, psta, res);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return flag;
	}

}
