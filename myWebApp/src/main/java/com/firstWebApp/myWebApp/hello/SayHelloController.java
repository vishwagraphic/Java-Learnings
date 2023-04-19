package com.firstWebApp.myWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
		
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hi, How are you doing?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer text = new StringBuffer();
		text.append("<html><head><title>My Title</title></head><body>My Web page is here</body></html>");
		return text.toString();
	}
	
	//src/main/java/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
