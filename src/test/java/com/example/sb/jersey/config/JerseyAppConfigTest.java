package com.example.sb.jersey.config;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sb.jersey.config.JerseyAppConfig;
import com.example.sb.jersey.controller.ExampleController;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Set;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
public class JerseyAppConfigTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private JerseyAppConfig jerseyAppConfig = new JerseyAppConfig();
	
	@Before
	public void setUp() {
	}

	@Test
	public void createJerseyAppConfigWithValidArgumentsShouldReturnASetOfRegisteredClasses() {
		Set<Class<?>> result = jerseyAppConfig.getClasses();
		assertThat(result, notNullValue());
		assertThat(result.size(), equalTo(1));
		assertThat(result.contains(ExampleController.class), equalTo(true));
	}

}
