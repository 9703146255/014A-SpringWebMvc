package in.thiru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/c1")
public class UserController {

	@GetMapping(value = "/getuser")
	public ModelAndView getUserData() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("ID", 1001);
		mav.addObject("NAME", "THIRUMALESH");
		mav.addObject("EMAIL", "FINDMETHIRU@GMAIL.COM");
		mav.setViewName("user");

		return mav;
	}

}
