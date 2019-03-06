package com.taotao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("index")
public class IndexController {

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv= new ModelAndView("index");
		return mv;
	}
}
