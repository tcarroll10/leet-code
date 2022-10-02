package com.tcarroll10.leetCode.RomanToIntService;

import java.util.HashMap;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tcarroll10.leetCode.model.OutputTo;

/*
 * Constraints: 
 *     1 <= s.length <= 15 
 *     s contains only the characters ('I', 'V', 'X', 'L','C', 'D', 'M'). I
 *     t is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */

@Service
public class SimpleRomanToIntService implements RomanToIntService {

	private static final Logger Log = LoggerFactory.getLogger(SimpleRomanToIntService.class);

	@Override
	public OutputTo romanToInt(String s) {
		// TODO Auto-generated method stub

		s.toUpperCase();

		final Optional<OutputTo> outPutTo = validateServiceInputs(s);

		if (outPutTo.isPresent()) {
			// return immediately to the user without processing because inputs are invalid
			return outPutTo.get();
		}

		/*
		 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
		 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
		 * and M (1000) to make 400 and 900.
		 */

		// reverse the string and convert it to `char[]` array
		char[] chars = new StringBuilder(s).reverse().toString().toCharArray();

		Log.info("The input roman numeral is {}", s.toString());
		Log.info("The input roman numeral reversed is {}", chars.toString());
		Log.info("the length of roman numeral is: {}", chars.length);

		Integer sum = 0;
		int i = 0;

		while (i + 1 <= chars.length) {
			Log.info("i is {}", i);
			Log.info("i+1 is {}", i + 1);

			// if the last character just add it
			if (i == (chars.length - 1)) {

				sum += romanToIntMap.get(chars[i]);
				Log.info("Adding {} to the total", romanToIntMap.get(chars[i]));
				Log.info("the total is {}", sum);
				i++;

			} else {

				// add the value of the character to the sum
				sum += romanToIntMap.get(chars[i]);

				// add the value of the next character if it's equal to or greater than the else
				// subtract value of next char
				if (romanToIntMap.get(chars[i + 1]) >= romanToIntMap.get(chars[i])) {
					sum += romanToIntMap.get(chars[i + 1]);
					Log.info("Adding {} to the total", romanToIntMap.get(chars[i + 1]));
					Log.info("the total is {} ", sum);

				} else {

					sum -= romanToIntMap.get(chars[i + 1]);
					Log.info("Subtracting {} from the total", romanToIntMap.get(chars[i + 1]));
					Log.info("the total is {}", sum);

				}
				// move to the next two characters
				i += 2;

			}

		}

		return OutputTo.builder().msg("Success").rslt(sum).valid(true).build();

	}

	private static final HashMap<Character, Integer> romanToIntMap = new HashMap<Character, Integer>() {
		/**
		* 
		*/

		private static final long serialVersionUID = 1L;

		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);

		};
	};

	/*
	 * Constraints: 1 <= s.length <= 15 s contains only the characters ('I', 'V',
	 * 'X', 'L','C', 'D', 'M'). It is guaranteed that 's' is a valid roman numeral
	 * in the range [1, 3999].
	 */

	private Optional<OutputTo> validateServiceInputs(String s) {

		if (!(s.length() >= 1 && s.length() <= 15)) {

			return Optional.of(OutputTo.builder().msg("String must be greater than 1 and less that 15 characters")
					.valid(false).build());

		}

		/*
		 * char[] chars = s.toCharArray();
		 * 
		 * for (char c : chars) { if (!romanToIntMap.containsKey(c)) { return
		 * Optional.of(OutputTo.builder().msg("String contains " + c +
		 * "which is not a valid Roman Numeral") .valid(false).build()); } }
		 */

		// this route indicates that inputs are valid; congrats!
		return Optional.empty();

	}

}
