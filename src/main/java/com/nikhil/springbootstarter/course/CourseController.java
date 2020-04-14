package com.nikhil.springbootstarter.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.springbootstarter.topics.Topics;


@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id){  
		
	return courseService.getAllCourses(id);
	}
	
	//request for a single resource
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		
		return courseService.getCourse(id);
	}
	
	//post request
	@RequestMapping(method=RequestMethod.POST ,value= "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topics(topicId,"",""));
		courseService.addCourse(course);
	}
	
	//update request
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course ,@PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topics(topicId,"",""));
		courseService.updateCourse( course);
	}
	
	//deleteRequest
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		 courseService.deleteCourse(id);
	}
}
