package com.appjishu.site.controller;

import com.appjishu.site.biz.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @author  Frank Liu
* @version 创建时间：2017年3月6日 下午1:42:17 
* 类说明 
*/
@RequestMapping("")
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private DemoService demoService;
	
//	@Autowired
//	private CleanService cleanService;
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping("hello")
	public String hello() {
		return "Welcome!";
	}
	
	@RequestMapping("panel")
	public String panel() {
		return "panel";
	}
}
