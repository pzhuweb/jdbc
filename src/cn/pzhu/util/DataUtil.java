package cn.pzhu.util;

import java.util.ArrayList;

import cn.pzhu.pojo.Car;

public class DataUtil {
	public static ArrayList<Car> split(ArrayList<Car> list, int number,int page){
		ArrayList<Car> newlist = null;
		
		//52	10	6
		//50 	10	5
		//49	10	5
		//1		10	1
		int pages = 0;
		if (list.size()% number==0) {
			pages = list.size()/number;
		} else {
			pages = list.size()/number + 1;
		}
		
		
		if (page<=0 || page > pages) {
			page=1;
		}
		//52	10    1    0-9
		//52	10	5	40-49
		//52	10	6	50-51
		//52	10	0	...  -1 ... 10  ...
		//list.size()	
		
		//1	0-9
		//2	10-19
		newlist = new ArrayList<>();
		for (int i = (page-1)*number ; i < page*number && i<list.size(); i++) {
			newlist.add(list.get(i));
		}		
		return newlist;
	}

	public static StringBuffer createBar(ArrayList<Car> list, int number,int page){
		int pages = 0;
		if (list.size()% number==0) {
			pages = list.size()/number;
		} else {
			pages = list.size()/number + 1;
		}
		
		StringBuffer bar = new StringBuffer();
		if (page>1) {
			bar.append("<a href=SelectCarServlet?page="+(page-1)+">上一页</a>");
		}
		bar.append("  ");
		for(int i=1;i<=pages;i++){
			if (i==page) {
				bar.append("["+i+"]");
			}else{
				bar.append("<a href=SelectCarServlet?page="+i+">"+i+"</a>");
			}
			bar.append("  ");
		}
		
		
		if(page<pages){
			bar.append("<a href=SelectCarServlet?page="+(page+1)+">下一页</a>");
		}
		
		return bar;
	}

}
