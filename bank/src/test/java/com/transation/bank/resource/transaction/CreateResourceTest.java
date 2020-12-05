package com.transation.bank.resource.transaction;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.transation.bank.BankApplicationTests;
import com.transation.bank.entity.dto.TransactionRequest;
import com.transation.bank.utils.JsonFormatted;

public class CreateResourceTest extends BankApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private CreateResource createResource; 
	
	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(createResource).build();
	}
	
	@Test
	public void createTransactionSuccess() throws Exception {
		
		TransactionRequest transaction = new TransactionRequest();
		
		transaction.setValor(350.0);
		transaction.setDataHora(new Date());
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/transacao")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonFormatted.stringify(transaction)))
		.andExpect(MockMvcResultMatchers.status().isCreated());
		
	}
	
	@Test
	public void createTransactionFailure() throws Exception {
		
		TransactionRequest transaction = new TransactionRequest();
		
		Date date = new Date();
		date.setTime(date.getTime() + (1000 * 1000));
		
		transaction.setValor(0.0);
		transaction.setDataHora(date);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/transacao")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonFormatted.stringify(transaction)))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}

}
