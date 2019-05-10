package com.mynotes.example;


import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;



import javax.annotation.PostConstruct;

import org.assertj.core.error.ShouldBeAfterOrEqualsTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MyControllerTest {

	@LocalServerPort
	private int port;

	private String uri;

	@PostConstruct
	public void init()
	{
		uri = "http://localhost:" + port;
	}

	@Test
	public void whenCallingHello_thenReturnGreeting()
	{

		get(uri + "/hello/" + "test")
				.then()
				.assertThat().statusCode(HttpStatus.OK.value())
				.body( containsString("Hi test"));
	}

	@Test
	public void whenCallingAdd_thenReturnResult()
	{
		given()
				.queryParam("num1",3)
				.queryParam("num2",4)
		.when().get(uri + "/add")

				.then()
				.assertThat().statusCode(HttpStatus.OK.value())
				.body( containsString("7"));
	}

}

