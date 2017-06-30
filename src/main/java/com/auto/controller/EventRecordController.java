package com.auto.controller;

import com.auto.dto.DeviceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auto.entity.EventRecord;
import com.auto.service.EventRecordService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class EventRecordController {
	
	@Autowired
	private EventRecordService userService;

	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest request) {

		List<DeviceData> list = userService.eventRecordByGroup();

		request.setAttribute("device",list.get(0));
		return new ModelAndView("hello");
	}
	
	/**
	 * 测试地址 http://localhost:8080/addUser?userName=zhao
	 * @return
	 */
	@RequestMapping("/addEventRecord")
	@ResponseBody
	public String adduser(EventRecord record) {
		userService.saveEventRecord(record);
		return "add success!";
	}
}
