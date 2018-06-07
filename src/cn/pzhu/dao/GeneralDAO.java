package cn.pzhu.dao;

import java.io.Serializable;
import java.util.ArrayList;

public interface GeneralDAO<E,PK extends Serializable> {
	public boolean add(E data);
	public boolean delete(PK id);
	public ArrayList<E> select();
	public E select(PK id);
	public boolean update(E data);
	
}
