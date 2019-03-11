package com.taotao.manage.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.taotao.manage.pojo.Content;

public interface ContentMapper extends Mapper<Content>{

	/**
	 * 根据categoryId查询内容列表并按更新时间排序
	 * @param categoryId
	 * @return
	 */
	public List<Content> queryContentList(Long categoryId);
}
