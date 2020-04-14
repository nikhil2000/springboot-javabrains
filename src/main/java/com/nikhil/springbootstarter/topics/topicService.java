package com.nikhil.springbootstarter.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class topicService {
	
	@Autowired
     private TopicRepository topicrepository;

	public List<Topics> getAllTopics(){
		//return topics;
		List <Topics>topics=new ArrayList<>();
		topicrepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	
	public Topics	getTopic(String id) {
		return topicrepository.findOne(id);
	}
	
	public void addTopic(Topics topic) {
		topicrepository.save(topic);
	}


	public void updateTopic(Topics topic, String id) {
		// TODO Auto-generated method stub
		topicrepository.save(topic);
	}


	public void deleteTopic(String id) {
		topicrepository.delete(id);
	}
	
		
}
