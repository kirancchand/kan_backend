package com.kan.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/state")
public class StateController {
	@Autowired
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

}
