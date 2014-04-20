package com.reg.ex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSample {

	public static String extractQuotationText(String quotation) {
		// question format 1 -> how much is pish tegj glob glob ?
		// question format 2 -> how many Credits is glob prok silver ?
		final Pattern questionFormat1 = Pattern
				.compile("(how much is|how many Credits is)(.+?)\\?");
		String questionValue = getQuestionValue(questionFormat1, quotation,
				new Integer[] { 0, 1, 2 }, 2);
		return questionValue;
	}

	
	public static String regExPatternExecutor(String text,String pattern) {
		final Pattern format = Pattern
				.compile(pattern);
		String questionValue = getQuestionValue(format, text,
				new Integer[] {0}, 0);
		return questionValue;
	}
	
	private static String getQuestionValue(final Pattern ptn, final String str,
			Integer[] fetch, Integer grp) {
		String questionValue = null;
		final Matcher matcher = ptn.matcher(str);
		while (matcher.find()) {
			questionValue = matcher.group(grp);
			System.out.println(" matcher.start(grp)  "
					+ matcher.start(grp));
			System.out.println(" matcher.end(grp)  "
					+ matcher.end(grp));
			matcher.end(grp);
			for (int index : fetch) {
				System.out.println(" matcher.group() " + index + " "
						+ matcher.group(index));
			}
		}
		return questionValue;
	}

	public static String readFile(final String filePath) {
		final StringBuffer buffer = new StringBuffer();
		try {
			final FileInputStream fis = new FileInputStream(filePath);
			final InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			final Reader reader = new BufferedReader(isr);
			int character;
			while ((character = reader.read()) > -1) {
				buffer.append((char) character);
			}
			reader.close();
			isr.close();
			fis.close();

		} catch (final IOException e) {
			System.out.println(" e " + e);
		}
		return buffer.toString();
	}
}
