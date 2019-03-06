package com.taotao.manage.service;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.Property;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manage.pojo.BasePojo;

public abstract class BaseService<T extends BasePojo> {
	/**
	 * 1、 queryById 
	 * 2、 queryAll 
	 * 3、 queryOne
	 * 4、 queryListByWhere 
	 * 5、queryPageListByWhere 
	 * 6、 save 
	 * 7、 update 
	 * 8、 deleteById 
	 * 9、 deleteByIds 
	 * 10、deleteByWhere
	 * 
	 * 
	 */
	@Autowired
	private Mapper<T> mapper;
//	public abstract Mapper<T> getMapper();
	public T queryById(Long id) {
		return this.mapper.selectByPrimaryKey(id);
	}
	public List<T> queryAll(){
		return this.mapper.select(null);
	}
	
	public T queryOne(T record) {
		return this.mapper.selectOne(record);
	}
	
	public List<T> queryListByWhere(T record){
		return this.mapper.select(record);
	}
	public PageInfo<T> queryPageListByWhere(T record,Integer page,Integer rows){
		PageHelper.startPage(page,rows);
		List<T> list=this.mapper.select(record);
		return new PageInfo<T>(list);
	}
	public Integer save(T t) {
		t.setCreated(new Date());
		t.setUpdated(t.getCreated());
		return this.mapper.insert(t);
	}
	
	public Integer saveSelective(T t) {
		t.setCreated(new Date());
		t.setUpdated(t.getCreated());
		return this.mapper.insertSelective(t);
	}
	
	public Integer update(T t) {
		t.setUpdated(new Date());
		return this.mapper.updateByPrimaryKey(t);
	}
	
	public Integer updateSelective(T t) {
		t.setUpdated(new Date());
		t.setCreated(null);
		return this.mapper.updateByPrimaryKeySelective(t);
	}
	public Integer deleteById(Long id) {
		return this.mapper.deleteByPrimaryKey(id);
	}
	public Integer deleteByIds(List<Object> ids,Class clazz,String property) {
		Example example =new Example(clazz);
		example.createCriteria().andIn(property,ids);
		return this.mapper.deleteByExample(example);
	}
	public Integer deleteByWhere(T record) {
		return this.mapper.delete(record);
	}
}
