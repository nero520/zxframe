package zxframe.properties.service;




import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zxframe.jpa.dao.MysqlTemplate;
import zxframe.properties.mapper.PropertiesMapper;
import zxframe.properties.model.Properties;

@Service
public class PropertiesService{
	@Resource
	private MysqlTemplate baseDao;
	
	public List<Properties> getList() {
		return baseDao.getList(PropertiesMapper.propertiesAll);
	}
	
	public String getListVersion() {
		return (String) baseDao.get(PropertiesMapper.propertiesByKey,"system-version");
	}
	
	public void updateProperties(String key,String value){
		baseDao.execute(PropertiesMapper.propertiesUpdateValue,value,key);
		baseDao.execute(PropertiesMapper.propertiesVersionAdd);
	}
	public void initPropertiesTable() {
		baseDao.execute(PropertiesMapper.initPropertiesTable);
		try {
			baseDao.execute(PropertiesMapper.initPropertiesTableInfo);
		} catch (Exception e) {
		}
	}
}
