package in.thiru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.thiru.entity.Course;
import in.thiru.service.CourseServiceImpl;

@Controller
public class CourseController {

	@Autowired
	private CourseServiceImpl courseService;

	@GetMapping("/courses")
	public ModelAndView getAllCourses() {
		ModelAndView mav = new ModelAndView();

		List<Course> allCourses = courseService.getAllCourses();

		mav.addObject("courses", allCourses);

		mav.setViewName("index");

		return mav;
	}

	@GetMapping("/addcourses")
	public ModelAndView showPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("courses", new Course());
		mav.setViewName("addcourses");
		return mav;
	}

	@PostMapping("/addcourses")
	public ModelAndView add(Course course) {
		ModelAndView mav = new ModelAndView();
		boolean addCourse = courseService.addCourse(course);

		if (addCourse) {
			mav.addObject("successMsg", "Record Inserted");
		} else {
			mav.addObject("errorMsg", "Record not Inserted");
		}

		mav.addObject("courses", new Course());

		mav.setViewName("addcourses");
		return mav;
	}

	@GetMapping("/delete")
	public ModelAndView deleteCourse(Integer courseId) {
		ModelAndView mav = new ModelAndView();

		courseService.deleteCourse(courseId);

		List<Course> allCourses = courseService.getAllCourses();

		mav.addObject("courses", allCourses);

		mav.setViewName("redirect:/courses");
		return mav;
	}

	@GetMapping("/edit")
	public ModelAndView editCourse(Course courseObj) {
		Course cource = courseService.getCource(courseObj.getCourseId());

		ModelAndView mav = new ModelAndView();

		mav.addObject("course", cource);

		
		
		return mav;
	}
	
	
	
	

}
