package com.nomi.basic;

import com.nomi.adapter.AuthenticationServiceAdapter;
import com.nomi.adapter.DataServiceAdapter;
import com.nomi.dto.CredentialsDto;
import com.nomi.dto.StudentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicServiceApplicationTests {

	@Autowired
	private DataServiceAdapter dataServiceAdapter;

	@Autowired
	private AuthenticationServiceAdapter authenticationServiceAdapter;

	@Test
	public void contextLoads() {
	}

	@Test
	public void basicServiceTest(){
		ResponseEntity<StudentDto> student = dataServiceAdapter.getStudent("user-has-A-grade");

		System.out.println(student.getBody());
	}

	@Test
	public void authServiceTest(){

		CredentialsDto credentialsDto = new CredentialsDto();
		credentialsDto.setPassword("noDB");
		credentialsDto.setUserName("user-not-in-db");

		authenticationServiceAdapter.authenticate(credentialsDto);


	}
}
