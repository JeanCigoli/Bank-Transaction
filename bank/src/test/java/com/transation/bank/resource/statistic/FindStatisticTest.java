package com.transation.bank.resource.statistic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.transation.bank.BankApplicationTests;

public class FindStatisticTest extends BankApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private FindStatisticResource findStatisticResource; 
	
	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(findStatisticResource).build();
	}
	
	@Test
	public void FindStatisticSuccess() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/estatistica")
				.contentType(MediaType.APPLICATION_JSON)
				.param("seconds", "60"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	@Test
	public void FindStatisticFailured() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/estatistica")
				.contentType(MediaType.APPLICATION_JSON)
				.param("seconds", "abc"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}

}
