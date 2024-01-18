package com.stubMethod.data.api.stub;

import java.util.Arrays;
import java.util.List;

import com.stubMethod.data.api.TodoService;

public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Spring MVC","Spring JDBC","Spring LDAP","Spring Mockito","EJB");
	}

	public void delete(String todoList) {
		// TODO Auto-generated method stub
		
	}

}
