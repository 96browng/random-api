package uk.nhs.nhsbsa.example.sampleapi.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomServiceSimpleImplTest {
	
	private RandomService service;
	
	@Before
	public void setUp() {
		this.service = new RandomServiceSimpleImpl();
	}

	@Test
	public void testRandomServiceConstructor_Success() {
	}

	@Test
	public void testGetNextRandom_Success() {
		long next = this.service.getNextRandom();
		assertTrue(next != 0);
	}
}
