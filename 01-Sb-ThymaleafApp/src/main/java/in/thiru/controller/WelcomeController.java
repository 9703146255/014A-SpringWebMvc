package in.thiru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String getMessage(Model model) 
	{
		
		model.addAttribute("message","Welcome to india");
		
		return "welcome"; // Thymeleaf template name (HTML file without the extension)
		
	}

}
