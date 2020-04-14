package com.nikhil.springbootstarter.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TopicController {
	
	//autowiring will make spring inject the instance of topicService to TopicControllerinstance
	@Autowired
	private topicService topicService;
	
	
	//request for getting all topics
	@RequestMapping("/topics")
	public List<Topics> getAllTopics(){  
		
	return topicService.getAllTopics();
	}
	
	//request for a single resource...{} describes a variable value, so the value inside {} is passed to method as parameter.
	@RequestMapping("/topics/{id}")
	public Topics getTopic(@PathVariable String id) {
		
		return topicService.getTopic(id);
	}
	
	//post request
	@RequestMapping(method=RequestMethod.POST ,value= "/topics")
	public void addTopic(@RequestBody Topics topic) {
		topicService.addTopic(topic);
	}
	
	//update request
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topics topic , @PathVariable String id) {
		topicService.updateTopic( topic,  id);
	}
	
	//deleteRequest
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}
}
