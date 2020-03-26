package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.hellospring.vo.UserVo;

@Controller
public class UserController {
	
	/*
	 * RequestMapping
	 * Class + Method
	 * 
	 */

	@RequestMapping(value= {"/join", "/j"}, method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@GetMapping(value= {"/join", "/j"})
	public String join_() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVo uservo) {
		System.out.println(uservo);
		//userRepository.insert(uservo);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value="/update")
	public String update(@RequestParam("n") String name) {
		/**
		 * 만일 n이라는 이름으로 파라미터가 없는 경우 400 Bad Request 오류 발생
		 */
		System.out.println(name);
		return "UserController:update";
	}
	
	@ResponseBody
	@RequestMapping(value="/update2")
	public String update2(
			@RequestParam(value="n", required=true, defaultValue="") String name,
			@RequestParam(value="a", required=true, defaultValue="0") int age) {
		System.out.println("--" + name + "--" + age + "--");
		return "UserController:update2";
	}
	
	@ResponseBody
	@RequestMapping(value="/board/view/{no}")
	public String view(@PathVariable("no") Long no) {
		System.out.println("no: "+no);
		return "UserController:view";
	}


}
