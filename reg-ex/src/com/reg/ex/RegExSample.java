package com.reg.ex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSample {

	/**
	 * use regular expression to extract quotation text out of question.
	 * 
	 * @param quotation
	 * @return
	 */
	public static String extractQuotationText(String quotation) {
		// question format 1 -> how much is pish tegj glob glob ?
		// question format 2 -> how many Credits is glob prok silver ?
		final Pattern questionFormat1 = Pattern
				.compile("(how much is|how many Credits is)(.+?)\\?");
		String questionValue = getQuestionValue(questionFormat1, quotation,
				new Integer[] { 0, 1, 2 }, 2);
    	return questionValue;
	}

	/**
	 * fetch and return matched expression
	 * 
	 * @param ptn
	 * @param str
	 * @return
	 */
	private static String getQuestionValue(final Pattern ptn, final String str,
			Integer[] fetch, Integer grp) {
		String questionValue = null;
		final Matcher matcher = ptn.matcher(str);
		if (matcher.find()) {
			questionValue = matcher.group(grp);
			for (int index : fetch) {
				System.out.println(" matcher.group() " + index + " "
						+ matcher.group(index));
			}
    	}
		return questionValue;
     }
}
