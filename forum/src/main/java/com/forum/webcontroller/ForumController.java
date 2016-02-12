package com.forum.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ForumController
{

	@RequestMapping(value = {"", "/", "/forum", "/home"})
	public String forum()
	{
		return "forum";
	}
	
}
