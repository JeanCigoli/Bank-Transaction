package com.transation.bank.resource.transaction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.transation.bank.BankApplicationTests;

public class DeleteResourceTest extends BankApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private DeleteResource deleteResource; 
	
	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(deleteResource).build();
	}
	
	@Test
	public void deleteTransactionSuccess() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/transacao")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
	}

}
