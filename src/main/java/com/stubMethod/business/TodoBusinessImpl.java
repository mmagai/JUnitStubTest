package com.stubMethod.business;

import java.util.ArrayList;
import java.util.List;

import com.stubMethod.data.api.TodoService;

public class TodoBusinessImpl {
	
	
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	
	public List<String> retrieveToDoList(String user){
		
		List<String> filterTodos = new ArrayList<String>();
		
		List<String> allToDoList = todoService.retrieveTodos(user);
		
		for(String todoList: allToDoList) {
			
			
			if(todoList.contains("Spring")) {
				
				
				
				filterTodos.add(todoList);
				
				
			}
			
			
		}
		
		return filterTodos;
	}
	
	

}
