package com.rakesh.capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
   @RequestMapping("/hello")
   public String HelloWord() {
	   return "hello";
   }
}
