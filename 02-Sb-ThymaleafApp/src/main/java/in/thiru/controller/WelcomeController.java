package in.thiru.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/c2")
public class WelcomeController {

	public WelcomeController() {
		System.out.println("WelcomeController() ::Constructor");
	}

	@GetMapping(value = "/welcome")
	public ModelAndView getWelcomeMsg() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "welcome to ashokit");
		mav.setViewName("index");

		return mav;
	}

	@GetMapping(value = "/date")
	public ModelAndView getDate() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("date", new Date());
		mav.setViewName("index");

		return mav;

	}

}
