package com.nikhil.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CourseService {
	
	@Autowired
     private CourseRepository courseRepository;

	// added an arrayList , as arrays are immutable
		/*
		 * private List<Course> courses = new ArrayList<>(Arrays.asList( new
		 * Course("java","java","language"), new Course("eclipse","eclipse","IDE"), new
		 * Course("js","javascript","frontend") ));
		 */
	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		List <Course>courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	
	public Course getCourse(String id) {
		//courseRepository.findByName(id);
		return courseRepository.findOne(id);
				}
	
	public void addCourse(Course course) {
		courseRepository.save(course);
	}


	public void updateCourse(Course course) {
		courseRepository.save(course);
	}   


	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
	
		
}
