package com.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auto.entity.EventRecord;
import com.auto.service.EventRecordService;

@RestController
public class EventRecordController {
	
	@Autowired
	private EventRecordService userService;

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		return new ModelAndView("hello");
	}
	
	/**
	 * 测试地址 http://localhost:8080/addUser?userName=zhao
	 * @param user
	 * @return
	 */
	@RequestMapping("/addEventRecord")
	@ResponseBody
	public String adduser(EventRecord record) {
		userService.saveEventRecord(record);
		return "add success!";
	}
}
