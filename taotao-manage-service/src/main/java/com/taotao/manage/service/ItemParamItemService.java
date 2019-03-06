package com.taotao.manage.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.taotao.manage.mapper.ItemParamItemMapper;
import com.taotao.manage.pojo.ItemParamItem;

@Service
public class ItemParamItemService extends BaseService<ItemParamItem>{
	@Autowired
	private ItemParamItemMapper itemParamItemMapper;
	
	//更新数据
	public Integer updateItemParamItem(Long itemId,String itemParams) {
		ItemParamItem itemParamItem = new ItemParamItem();
		itemParamItem.setUpdated(new Date());
		itemParamItem.setParamData(itemParams);
		//更新的条件
		Example example=new Example(ItemParamItem.class);
		example.createCriteria().andEqualTo("itemId", itemId);
		
		return this.itemParamItemMapper.updateByExampleSelective(itemParamItem, example);
	}

	
}
