package com.unit.tests.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class HandleTextServiceTest {

	@InjectMocks
	private HandleTextService handleTextService;
	
	@Test
	public void calcCharNumbersTest() {
		String result = handleTextService.numberOfChars("java");
		assertEquals("Seu texto tem 4 letras!",result);
	}
	
	@Test
	public void getRandomNumberTest() {
		String result = handleTextService.getRandomNumber("Jhon");
		assertTrue(verifyContainsPartOfText(result));
	}
	
	private boolean verifyContainsPartOfText(String result) {
		return result.contains("Olá Jhon o número aleatório pra você foi:") ? true : false;
	}
	
}
