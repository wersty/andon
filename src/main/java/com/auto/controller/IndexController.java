package com.auto.controller;

import com.auto.dto.DeviceData;
import com.auto.service.EventRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pangjian on 7/1/17.
 */
@Controller
public class IndexController {

    @Autowired
    private EventRecordService userService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {

        List<DeviceData> list = userService.eventRecordByGroup();

        request.setAttribute("device",list.get(0));
        return "index";
    }
}
