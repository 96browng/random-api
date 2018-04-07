package uk.nhs.nhsbsa.example.sampleapi.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import uk.nhs.nhsbsa.example.sampleapi.service.RandomService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
public class RandomControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RandomService serviceMock;

	@Test
	public void testRandom_Success() throws Exception {
		long expected = 123L;
		when(serviceMock.getNextRandom()).thenReturn(expected);
		
		mockMvc.perform(get("/"))
		    .andExpect(status().isOk())
		    .andExpect(content().string("Next random: " + expected));
	}

}
