package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringTestApplicationTests {

	@Autowired
	MockMvc mockMvc;
	 
	@SpyBean
	RestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws Exception {
		System.out.println("test "+ restTemplate);
		//RestTemplate spyRest = Mockito.spy(restTemplate);
		Mockito.doThrow(Exception.class).when(restTemplate).getForEntity(Mockito.anyString(), Mockito.eq(String.class));
		mockMvc.perform(MockMvcRequestBuilders.get("/check"))
		//.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
