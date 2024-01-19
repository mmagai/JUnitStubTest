package com.stubMethod.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.stubMethod.data.api.TodoService;


public class TodoBusinessImplMockitoTestWithAnnotation {
	
	@Rule
	public MockitoRule mocktorule = MockitoJUnit.rule();

	@Mock
	TodoService todoService;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Test
	public void testWithMockito() {

		List<String> allToDoList = Arrays.asList("Spring MVC", "Spring JDBC", "Spring LDAP", "Spring Mockito", "EJB");

		when(todoService.retrieveTodos("dummy")).thenReturn(allToDoList);
		// given(todoService.retrieveTodos("dummy")).willReturn(allToDoList);

		List<String> result = todoBusinessImpl.retrieveToDoList("dummy");

		assertEquals(4, result.size());

	}

	@Test
	public void testWithMockitoListClass() {

		List list = mock(List.class);

		when(list.size()).thenReturn(2);

		assertEquals(2, list.size());

	}

	@Test
	public void testWithMockitoList_ArgumentMatchers() {

		List list = mock(List.class);

		when(list.get(0)).thenReturn("Mahesh");

		assertEquals("Mahesh", list.get(0));

	}

	@Test
	public void testWithMockito_ToVarifyCalls() {

		List<String> allToDoList = Arrays.asList("Spring MVC", "Spring JDBC", "Spring LDAP", "Spring Mockito", "EJB",
				"EJB1");
		when(todoService.retrieveTodos("dummy")).thenReturn(allToDoList);

		todoBusinessImpl.deleteToDoList("dummy");

		verify(todoService, times(1)).delete("EJB");

	}

	@Test
	public void testWithMockito_ToCaptureArguments() {

		List<String> allToDoList = Arrays.asList("Spring MVC", "Spring JDBC", "Spring LDAP", "Spring Mockito", "EJB");
		when(todoService.retrieveTodos("dummy")).thenReturn(allToDoList);

		todoBusinessImpl.deleteToDoList("dummy");

		// Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		// Define Argument CApture on specific method call
		verify(todoService).delete(stringArgumentCaptor.capture());

		assertEquals("EJB", stringArgumentCaptor.getValue());

	}

}
