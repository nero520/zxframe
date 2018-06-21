package zxframe.jpa.util;

import java.util.Iterator;
import java.util.Map;

import zxframe.cache.mgr.CacheModelManager;
import zxframe.jpa.annotation.Model;

public class SQLParsing {
	/**
	 * 获取数据源名
	 * 1.如果有dsClass则优先取此数据源
	 * 2.如果有resultClass则取此数据源
	 * 3.解析sql获取数据源
	 * 4.解析sql没有获得数据源则返回默认数据源
	 * @param dsClass
	 * @param resultClass
	 * @param sql
	 * @return
	 */
	public static String getDSName(Class dsClass,Class resultClass,String sql) {
		Model model = null;
		if(dsClass!=null) {
			model = CacheModelManager.cacheModelAnnotation.get(dsClass.getName());
		}
		if(model==null&&resultClass!=null) {
			model = CacheModelManager.cacheModelAnnotation.get(resultClass.getName());
		}
		if(model==null) {
			//增删改查语句解析
			if(sql.indexOf("where")!=-1) {
				sql=sql.substring(sql.indexOf("from ")+5, sql.indexOf(" where"));
			}else {
				sql=sql.substring(sql.indexOf("from ")+5, sql.length());
			}
			String modelName=sql.trim().toLowerCase();
			model = CacheModelManager.cacheModelJAnnotation.get(modelName);
		}
		if(model==null) {
			return "default";
		}else {
			return model.dsname();
		}
	}
	//sql参数部分增强
	public static String replaceSQL(String sql, Map<String, String> map) {
		if(map!=null) {
			Iterator<String> iterator = map.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				sql=sql.replaceAll("@"+key+"@",map.get(key));
			}
		}
		return sql;
	}
}
