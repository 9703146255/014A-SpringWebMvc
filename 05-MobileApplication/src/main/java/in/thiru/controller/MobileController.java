package in.thiru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.thiru.entity.Mobile;
import in.thiru.service.MobileServicex;

@Controller
public class MobileController {

	@Autowired
	private MobileServicex mobileService;

	@GetMapping("/mobiles")
	public ModelAndView getAllMobiles() {
		ModelAndView mav = new ModelAndView();

		List<Mobile> allMobiles = mobileService.getAllMobiles();
		mav.addObject("mobiles", allMobiles);
		mav.setViewName("index");

		return mav;
	}

	@GetMapping("/addmobile")
	public ModelAndView showAddPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("mobiles", new Mobile());

		mav.setViewName("addmobile");

		return mav;
	}

	@PostMapping("/addmobile")
	public ModelAndView saveBook(Mobile mobiles) {

		ModelAndView mav = new ModelAndView();

		boolean saveMobiles = mobileService.saveMobiles(mobiles);
		
		if (saveMobiles) {
			mav.addObject("successMsg", "Record Inserted");
		} else {
			mav.addObject("errorMsg", "Record Not Inserted");
		}
		mav.addObject("mobiles", new Mobile());
		
		
		mav.setViewName("addmobile");
		return mav;
	}
	
	
	
	@GetMapping("/delete")
	public ModelAndView deleteMobile(Integer mobileId)
	{
		
		mobileService.deleteMobile(mobileId);
		
		
		ModelAndView mav=new ModelAndView();
		
		List<Mobile> allMobiles = mobileService.getAllMobiles();
		
		mav.addObject("mobiles",allMobiles);
		
		mav.setViewName("index");
		
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView editMobile(Mobile mobile)
	{
		ModelAndView mav=new ModelAndView();
		
		Mobile mobileId2 = mobileService.getMobile(mobile.getMobileId());
		
		
		
		mav.addObject("mobiles",mobileId2);
		mav.setViewName("addmobile");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
