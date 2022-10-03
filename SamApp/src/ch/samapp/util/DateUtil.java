package ch.samapp.util;


import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

/**
 *  Helper functions for handling dates
 *
 * @author Juanes Cardona
 *
 */

public class DateUtil {

	/** The date pattern that is used for conversion. Change as you wish.  */

	private static final String DATE_PATTERN = "dd.MM.yyyy";


	/** The data formatter. */

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);


	/**
	 *
	 * Return the given date as a well formatted String. The above defined
	 * {@link DateUtil#DATE_PATTERN} is used.
	 *
	 * @param date the date to be returned as a string.
	 * @return formatted string.
	 */

	public static String format(LocalDate date){

		if (date == null){

			return null;
		}

		return DATE_FORMATTER.format(date);
	}


	/**
	 *
	 * Converts a String in the format of the defined {@link DateUtil#DATE_PATTERN}
	 * to a {@link LocalDate} object.
	 *
	 * Returns null if the string could not be converted.
	 *
	 * @param dateString the date as String
	 * @return the date object or null if it could not be converted
	 */
	public static LocalDate parse(String dateString){

		try {

			return DATE_FORMATTER.parse(dateString, LocalDate::from);

		} catch (Exception e) {

			return null;
		}

	}

	/**
	 * Checks the String whether it is a valid date.
	 *
	 * @param dateString
	 * @return true if the String is a valid date
	 */

	public static boolean validDate(String dateString){

		//Try to parse the String.

		return DateUtil.parse(dateString) != null;
	}
}
