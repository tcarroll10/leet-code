package com.tcarroll10.leetCode.RomanToIntService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tcarroll10.leetCode.RomanToIntService.SimpleRomanToIntService;

@RunWith(MockitoJUnitRunner.class)
public class SimpleRomanToIntServiceTest {

	@InjectMocks
	private SimpleRomanToIntService service;

	private static final Logger Log = LoggerFactory.getLogger(SimpleRomanToIntServiceTest.class);

	/*
	 * test cases: Input: num = 3 Output: "III" Explanation: 3 is represented as 3
	 * ones. Example 2:
	 * 
	 * Input: num = 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3. Example
	 * 3:
	 * 
	 * Input: num = 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90
	 * and IV = 4.
	 */

	@Test
	public void RomanToIntTest() {

		assertEquals(1, service.romanToInt("I").getRslt());
		assertEquals(2, service.romanToInt("II").getRslt());
		assertEquals(3, service.romanToInt("III").getRslt());
		assertEquals(1994, service.romanToInt("MCMXCIV").getRslt());
		assertEquals(19, service.romanToInt("XIX").getRslt());
		assertEquals(6, service.romanToInt("VI").getRslt());
		assertEquals(4, service.romanToInt("IV").getRslt());

	}

}
