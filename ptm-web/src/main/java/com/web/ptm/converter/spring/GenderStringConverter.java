package com.web.ptm.converter.spring;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.web.ptm.common.constant.Gender;

@Component
public class GenderStringConverter implements Formatter<Gender> {

	@Override
	public String print(Gender source, Locale locale) {
		if (source == null) {
			throw new IllegalArgumentException("source cannot be null");
		}
		return source.toString();
	}

	@Override
	public Gender parse(String source, Locale locale) throws ParseException {
		if (source == null) {
			throw new IllegalArgumentException("source cannot be null");
		}
		return Gender.valueOf(source.toUpperCase());
	}

}
