package com.sist.web;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@RequestMapping("main/list.do")
	public String main_list(Model model)
	{
		model.addAttribute("msg", "Redirect를 이용해서 데이터 전송하기");
		
		return "main/list";
	}
	
	@RequestMapping("main/insert.do")
	public String main_insert()
	{
		return "redirect:result.do?id=admin";
	}
	
	@RequestMapping("main/update.do")
	public String main_update(RedirectAttributes r)
	{
		// (key,value)의 형식 (=Model,Request), flash가있어야 감춰진다
		r.addFlashAttribute("id", "admin");
		
		return "redirect:result.do";
	}
	
	@RequestMapping("main/result.do")
	public String main_result(String id,Model model)
	{
		// 위에서 redirect로 보내주기때문에, model이 있으면 안된다
		//model.addAttribute("id", id);
		
		return "main/result";
	}
}
