package in.thiru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import in.thiru.service.BookService;

/*
 GLOABAL EXCEPTION
 ================
 GLOBAL EXCEPTION MEANS, THESE EXCEPTION IS APPLICABLE TO THE WHOLE  APPLICATION
 
 it is used to handle the all the layers
 */

@Controller
@ControllerAdvice
public class BookController 
{
	
	
	@Autowired
	private BookService bService;
	
	@GetMapping("/getnull")
	public String getNullMessage(Model model)
	{
		int msg = bService.getNullPointerMessage();
		
		System.out.println(msg);
		
		model.addAttribute("msg",msg);
		
		return "index";
	}
	
	

	@GetMapping("/welcome")
	public String getMessage(Model model) 
	{
		model.addAttribute("msg", "welcome to ashok it..");
		return "index";
	}
	
	@GetMapping("/greet")
	public String getGreet(Model model) 
	{
		model.addAttribute("msg", "welcome to ashok it..");
		int a=10/0;
		return "index";
	}

	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Exception e) 
	{
		e.printStackTrace();

		return "errorView";
	}

}
