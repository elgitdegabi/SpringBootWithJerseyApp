package com.example.sb.jersey.service.oldmockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.example.sb.jersey.service.ExampleService;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

public class ResourceServiceTest {

	private ExampleService exampleService = new ExampleService();
	
	private Map<String, String> configuredResources;
	
	@Before
	public void setUp() {
		configuredResources = new HashMap<>();
		configuredResources.put("1", "resource #1");
		configuredResources.put("2", "resource #2");
		configuredResources.put("3", "resource #3");
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithListOfConfiguredResources() {
		Map<String,String> result = exampleService.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.size(), equalTo(configuredResources.size()));
	}
}
