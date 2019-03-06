package com.taotao.manage.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.bean.EasyUIResult;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemDesc;
import com.taotao.manage.service.ItemDescService;
import com.taotao.manage.service.ItemParamItemService;
import com.taotao.manage.service.ItemService;

@RequestMapping("item")
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDescService itemDescService;
	
	@Autowired
	private ItemParamItemService itemParamItemService;
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveItem(Item item, @RequestParam("desc") String desc,@RequestParam("itemParams") String itemParams) {
		// 初始值
		try {
			if (StringUtils.isEmpty(item.getTitle())) {
				// 参数有误，400
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			// 保存商品
			Boolean bool = this.itemService.saveItem(item,desc,itemParams);
			if (!bool) {
				// 保存失败
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@RequestMapping(method = RequestMethod.GET)

	public ResponseEntity<EasyUIResult> queryItemList(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "30") Integer rows) {

		try {
			return ResponseEntity.ok(this.itemService.queryItemList(page, rows));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateItem(Item item,@RequestParam("desc") String desc,@RequestParam("itemParams") String itemParams) {
		try {
			if (StringUtils.isEmpty(item.getTitle())) {
				// 参数有误，400
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			// 保存商品
			Boolean bool = this.itemService.updateItem(item,desc,itemParams);
			if (!bool) {
				// 保存失败
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	
	}
}
