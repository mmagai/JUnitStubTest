package com.stubMethod.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.stubMethod.data.api.TodoService;
import com.stubMethod.data.api.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void test() {
		
		
		TodoService todoService  =  new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		
		
		List<String> checkResult = todoBusinessImpl.retrieveToDoList("dummy");
		
		
		assertEquals(4, checkResult.size());
	}

}
