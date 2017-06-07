package com.example.sb.jersey.controller;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sb.jersey.controller.ExampleController;
import com.example.sb.jersey.service.ExampleService;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
public class ExampleControllerTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@MockBean
	ExampleService exampleServiceMock;
	
	@SpyBean // use inject mocks with spring boot versions lower than 1.4
	private ExampleController exampleController;
	
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
		Mockito.doReturn(configuredResources).when(exampleServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(configuredResources.size()));
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithNullListOfConfiguredResources() {
		Mockito.doReturn(null).when(exampleServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), nullValue());
	}

	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithEmptyListOfConfiguredResources() {
		Mockito.doReturn(new HashMap<>()).when(exampleServiceMock).getConfiguredResources();
		
		ResponseEntity<Map<String,String>> result = exampleController.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(result.getBody(), notNullValue());
		assertThat(result.getBody().size(), equalTo(0));
	}	
}
