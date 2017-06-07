package com.example.sb.jersey.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sb.jersey.service.ExampleService;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
public class ResourceServiceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private ExampleService exampleService = new ExampleService();
	
	private Map<String, String> configuredResources;
	
	@Before
	public void setUp() {
		configuredResources = new HashMap<>();
		configuredResources.put("1", "resource #1");
		configuredResources.put("2", "resource #2");
		configuredResources.put("3", "resource #3");
	}
	
	@Test
	public void getConfiguredResourcesWithValidArgumentsShouldReturnAResponseEntityWithListOfConfiguredResources() {
		Map<String,String> result = exampleService.getConfiguredResources();
		
		assertThat(result, notNullValue());
		assertThat(result.size(), equalTo(configuredResources.size()));
	}
}
