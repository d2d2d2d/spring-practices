package com.douzone.guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestbookController {

	@ResponseBody
	@RequestMapping("")
	public String index(){
		return "guestbook list";
	}
}
