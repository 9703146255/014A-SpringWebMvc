package in.thiru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.thiru.entity.Course;
import in.thiru.repo.CourseRepo;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseRepo courseRepo;

	public List<Course> getAllCourses() {
		return courseRepo.findAll();

	}

	@Override
	public boolean addCourse(Course course) {

		Course save = courseRepo.save(course);

		if (save.getCourseId() != null) {
			return true;
		}

		return false;
	}

	@Override
	public void deleteCourse(Integer courseId) {

		courseRepo.deleteById(courseId);

	}

	@Override
	public Course getCource(Integer courseId) {

		Optional<Course> findById = courseRepo.findById(courseId);

		if (findById.get() != null) {
			Course course = findById.get();

			return course;
		}

		return null;
	}

}
