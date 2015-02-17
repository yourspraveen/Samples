package com.example.numberguess;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumberGuessTest {

	NumberGuess ng = null;

	@Before
	public void init() {
		ng = new NumberGuess();
		ng.setHigher(5);
		ng.setLower(3);
	}

	@After
	public void tearDown() {
		ng = null;
	}

	@Test
	public void testIncreaseGuess() {
		assertTrue(4 == ng.increaseGuess(3));
	}

	@Test
	public void testDecreaseGuess() {
		assertTrue(4 == ng.decreaseGuess(5));
	}

}
