package uk.nhs.nhsbsa.example.sampleapi.service;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RandomServiceSimpleImpl implements RandomService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomServiceSimpleImpl.class);

	private Random rand;
	
	public RandomServiceSimpleImpl() {
		rand = new Random();
		rand.setSeed(new Date().getTime());
		
		LOGGER.info("Initialised new randomiser");
	}
	
	/* (non-Javadoc)
	 * @see uk.nhs.nhsbsa.example.sampleapi.service.RandomService#getNextRandom()
	 */
	@Override
	public long getNextRandom() {
		long next = rand.nextLong();
		LOGGER.info("Generated: {}", next);
		return next;
	}
}
