/*/
a CrudRepository is a interface which contains inbuilt methods such as get,Post,update,Delete
*/
package com.nikhil.springbootstarter.topics;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topics, String>{

	
}
