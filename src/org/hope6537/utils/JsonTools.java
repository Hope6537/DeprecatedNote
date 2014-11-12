package org.hope6537.utils;

import net.sf.json.JSONObject;

/**
 * @Describe 将数据转化的Json类对象
 * @Author Hope6537(赵鹏)
 * @Signdate 2014-4-27下午01:30:03
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class JsonTools {
	
	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @Descirbe 创造一个Json对象
	 * @Author Hope6537(赵鹏)
	 * @Params @param objectName 键值对中用于表示的键
	 * @Params @param arg 一个对象参数,必须实现toString()方法
	 * @Params @return
	 * @SignDate 2014-4-27下午01:30:17
	 * @Version 0.9
	 */
	public String createJson(String objectName ,Object arg){
		//创建一个对象
		JSONObject j = new JSONObject();
		//将关键字和数据一起构造进去
		j.put(objectName,arg);
		//返回字符串形式用于传输
		return j.toString();
		
	}
	public String createJsons(String [] objectName ,Object [] arg){
		//创建一个对象
		JSONObject j = new JSONObject();
		//将关键字和数据一起构造进去
		for(int i = 0 ; i < objectName.length ; i ++){
			j.put(objectName[i],arg[i]);
		}
		//返回字符串形式用于传输
		return j.toString();
		
	}

}
