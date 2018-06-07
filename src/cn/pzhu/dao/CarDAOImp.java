package cn.pzhu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.pzhu.pojo.Car;
import cn.pzhu.util.DBUtil;

public class CarDAOImp implements CarDAO {

	@Override
	public boolean add(Car data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Car> select() {
	ArrayList<Car> list=new ArrayList<>();
	String sql="select * from car";
	Connection con=DBUtil.getConnection();
	try {
		Statement sta=con.createStatement();
		ResultSet res=sta.executeQuery(sql);
		while(res.next()){
			Car car=new Car();
			car.setId(res.getInt(1));
			car.setName(res.getString(2));
			car.setType(res.getString(3));
			car.setPrice(res.getDouble(4));
			list.add(car);
			
		}
		return list;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
		
	}

	@Override
	public Car select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Car data) {
		// TODO Auto-generated method stub
		return false;
	}

}
