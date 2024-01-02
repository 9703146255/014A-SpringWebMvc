package in.thiru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EmployeeController {

	@GetMapping("/demo1")
	public ModelAndView getMessage1() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("msg1", "WELCOME TO ASHOK IT...............");

		mav.setViewName("index");

		return mav;
	}

	/*
	 * @PathParam ;; path param is used to send the data in the url directly ==>for
	 * capturing the pathparam value we will use pathvariable ==>it will present any
	 * where in the url
	 */

	@GetMapping("/demo2/{name}")
	public ModelAndView getMessage2(@PathVariable("name") String name) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", "WELCOME TO ASHOK IT..............." + name);

		mav.setViewName("index");

		return mav;
	}

	//http://localhost:1111/demo3/chandu/10/demo3
	@GetMapping("/demo3/{name}/demo4/{age}")
	public ModelAndView getMessage3(@PathVariable("name") String name, @PathVariable("age") int age) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Welcome to india your name is :: " + name + " and your age is " + age);

		mav.setViewName("index");

		return mav;

	}
	
	
	
	
	/*
	 Query param :: query param is used to send the data to the server
	 			
	 Request param :; it is used to capture teh data from the client(qp)
	 */
	//http://localhost:1111/demo4?name=charan
	
	@GetMapping("/demo4")
   public ModelAndView getMessage4(@RequestParam("name") String name)
   {
	 
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "hell welcome to hyderabad..."+name);
		mav.setViewName("index");
		return mav;
   }
	
	//http://localhost:1111/demo5?courseName=springboot&courseTrainer=thirumalesh
		@GetMapping("/demo5")
	   public ModelAndView getMessage4(@RequestParam("courseName") String courseName,@RequestParam("courseTrainer") String courseTrainer)
	   {
		 
			
			ModelAndView mav=new ModelAndView();
			mav.addObject("msg", "hell welcome to hyderabad... Course name :: "+courseName+ " and course trainer is :: "+courseTrainer);
			mav.setViewName("index");
			return mav;
	   }
		
		
		
		
		/*
		 It will directly send the model data to the server 
		 */
		@GetMapping("/demo6")
		//@ResponseBody
		public String getMessage5(Model model)
		{
			return "show";
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
