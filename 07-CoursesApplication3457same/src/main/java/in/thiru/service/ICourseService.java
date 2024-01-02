package in.thiru.service;

import java.util.List;

import in.thiru.entity.Course;

public interface ICourseService {
	

	
	public List<Course> getAllCourses(); 
	
	public boolean addCourse(Course course);
	
	public void deleteCourse(Integer courseId);
	
	public Course getCource(Integer courseId);


}
