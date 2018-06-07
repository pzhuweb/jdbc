package cn.pzhu.dao;

import cn.pzhu.pojo.User;

public interface UserDAO extends GeneralDAO<User, String> {
	public boolean login(User user);
}
