package com.ibm.lab.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@Value("${application.message:Hello World}")
	private String helloMessage;
	
    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        
        System.out.println("hello:"+name);
        return "hello";
    }
	
	@GetMapping("/hello2")
	public String welcome(Map<String, Object> model) {
		
		model.put("message", helloMessage);
		
		return "welcome";
	}
}
