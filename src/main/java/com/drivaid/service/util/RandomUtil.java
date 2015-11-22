package com.drivaid.service.util;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * Utility class for generating random Strings.
 */
public final class RandomUtil {

	private static final int DEF_COUNT = 20;

	private RandomUtil() {
	}

	/**
	 * Generates a password.
	 *
	 * @return the generated password
	 */
	public static String generatePassword() {
		return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
	}

	/**
	 * Generates an activation key.
	 *
	 * @return the generated activation key
	 */
	public static String generateActivationKey() {
		return RandomStringUtils.randomNumeric(DEF_COUNT);
	}

	/**
	 * Generates a reset key.
	 *
	 * @return the generated reset key
	 */
	public static String generateResetKey() {
		return RandomStringUtils.randomNumeric(DEF_COUNT);
	}

	public static long generateRandomNumber(long upperBound) {
		return RandomUtils.nextLong(1, upperBound);
	}
}
