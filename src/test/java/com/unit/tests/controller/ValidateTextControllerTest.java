package com.unit.tests.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.unit.tests.service.HandleTextService;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidateTextControllerTest {

	@MockBean
	private HandleTextService handleTextService;

	@Autowired
	public MockMvc mockMvc;

	final String BASE_PATH = "/game";

	@Test
	public void calcCharNumbersText() {
		try {
			when(handleTextService.numberOfChars("Java")).thenReturn("Seu texto tem 4 letras");
			mockMvc.perform(get(BASE_PATH + "/number/name/chars").param("text", "Java")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getRandomNumberTest() {
		try {
			when(handleTextService.getRandomNumber("John")).thenReturn(anyString());
			mockMvc.perform(get(BASE_PATH + "/random/number").param("name", "Java")).andExpect(status().isOk());
		} catch (Exception e) {
		}
	}
}
