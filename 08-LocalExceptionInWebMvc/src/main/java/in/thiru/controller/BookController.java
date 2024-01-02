package in.thiru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/*
 In web mvc exceptions are two types
 ===================================
 1)local exceptions[these is specific to one controller]
 2)global exceptions
 
  1)local exceptions[these is specific to one controller]
  ========================================================
 
 */
@Controller
public class BookController {

	@GetMapping("/welcome")
	public String getWelcomeMsg(Model model) {

		model.addAttribute("msg", "welcome to ashok it.....");

		int result = 10 / 0;

		return "index";
	}

	@GetMapping("/greet")
	public String getGreetMessage(Model model) {
		model.addAttribute("msg", "good morning ra thiru....");

		String s = null;
		s.length();
		return "errorView";
	}

	@GetMapping("/warn")
	public String getWarningMsg(Model model) {
		model.addAttribute("msg", "bad morning ra thiru....");

		String[] s = new String[] {"thiru","charan"};
		System.out.println(s[2]);
		
		return "errorView";
	}
	
	
	
	//IT IS APPLICABLE FOR ALL EXCEPTIONS[EXCEPTION CLASS IS A SUPER CLASS]
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandling(Exception e) {
		e.printStackTrace();

		return "errorView";
	}
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

}
