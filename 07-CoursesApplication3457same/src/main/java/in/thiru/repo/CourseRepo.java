package in.thiru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.thiru.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
