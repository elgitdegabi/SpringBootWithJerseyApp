package com.example.sb.jersey.controller.easymock;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.sb.jersey.controller.ExampleController;
import com.example.sb.jersey.service.ExampleService;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(EasyMockRunner.class)
public class ExampleControllerTest {

	@Mock
	ExampleService exampleServiceMock;

	@TestSubject
	private ExampleController exampleController = new ExampleController();
	
	private Map<String, String> configuredResources;
	
	@Before
	public void setUp() {
		configuredResources = new HashMap<>();
		configuredResources.put("1", "resource #1");
		configuredResources.put("2", "resource #2");
		configuredResources.put("3", "resource #3");
		configuredResources.put("4", "resource #4");
		configuredResources.put("5", "resource #5");
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithListOfConfiguredResources() {
		EasyMock.expect(exampleServiceMock.getConfiguredResources()).andReturn(configuredResources);
		EasyMock.replay(exampleServiceMock);
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(configuredResources.size()));
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithNullListOfConfiguredResources() {
		EasyMock.expect(exampleServiceMock.getConfiguredResources()).andReturn(null);
		EasyMock.replay(exampleServiceMock);
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), nullValue());
	}

	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithEmptyListOfConfiguredResources() {
		EasyMock.expect(exampleServiceMock.getConfiguredResources()).andReturn(new HashMap<>());
		EasyMock.replay(exampleServiceMock);
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(0));
	}	
}
