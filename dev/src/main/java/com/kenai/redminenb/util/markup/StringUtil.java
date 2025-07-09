package com.kenai.redminenb.util.markup;

public class StringUtil {

	public static String escapeHTML(String input) {
		return input == null ? "" : input.replace(
				"&", "&amp;"
		).replace(
				"<", "&lt;"
		).replace(
				">", "&gt;"
		).replace(
				"\"", "&quot;"
		).replace(
				"'", "&#x27"
		);
	}

	private StringUtil() {
	}
}
