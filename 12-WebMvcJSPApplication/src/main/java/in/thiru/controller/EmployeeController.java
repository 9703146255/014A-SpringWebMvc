package in.thiru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class EmployeeController {
	
	@GetMapping(value = "/welcome")
	public String getWelcomeMsg(Model model) 
	{
		
		model.addAttribute("msg", "welcome to ashokit....");
		return "index";
	}

}
