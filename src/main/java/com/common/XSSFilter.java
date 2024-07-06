package com.common;

import org.apache.commons.text.StringEscapeUtils;

public class XSSFilter {
	public static String filter(String input) {
        if (input != null) {
            return StringEscapeUtils.escapeHtml4(input);
        }
        return input;
    }
}
