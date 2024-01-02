package in.thiru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 
 in global exceptions
 ====================
 it will perform the component scanning to performing the global exception in webmvc.
 */
@Controller
public class ProductController {
	
	@GetMapping("/warn")
	public String getWarn(Model model) 
	{
		model.addAttribute("msg", "bad morning to thiru...");
		int a=10/0;
		return "index";
	}

}
