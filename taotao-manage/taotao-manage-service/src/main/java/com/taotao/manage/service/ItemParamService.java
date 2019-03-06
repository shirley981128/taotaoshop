package com.taotao.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.bean.EasyUIResult;
import com.taotao.manage.mapper.ItemParamMapper;
import com.taotao.manage.pojo.ItemParam;

@Service
public class ItemParamService extends BaseService<ItemParam>{

	@Autowired
	private ItemParamMapper itemParamMapper;
	
	public EasyUIResult queryItemParamList(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		Example example = new Example(ItemParam.class);
		example.setOrderByClause("created DESC");
		List<ItemParam> itemParams=this.itemParamMapper.selectByExample(example);
		PageInfo<ItemParam> pageInfo=new PageInfo<ItemParam>(itemParams);
		return new EasyUIResult(pageInfo.getTotal(),pageInfo.getList());
	}
}
