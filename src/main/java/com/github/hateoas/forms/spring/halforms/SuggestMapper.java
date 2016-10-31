package com.github.hateoas.forms.spring.halforms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hateoas.forms.affordance.SuggestType;

public class SuggestMapper extends AbstractSuggest {

	private final ObjectMapper objectMapper;
	private List<Object> values;
	private String embeddedRel;
	private String href;

	public SuggestMapper(String textField, String valueField) {
		super(textField, valueField);
		this.objectMapper = new ObjectMapper();
	}

	public void setValues(List<Object> values) {
		this.values = values;
	}

	public SuggestType getType() {
		if (embeddedRel != null) {
			return SuggestType.EXTERNAL;
		} else if (href != null) {
			return SuggestType.REMOTE;
		} else {
			return SuggestType.INTERNAL;
		}
	}

	public void setEmbeddedRel(String embeddedRel) {
		this.embeddedRel = embeddedRel;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getEmbeddedRel() {
		return embeddedRel;
	}

	public String getHref() {
		return href;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getPossibleValues(ParameterizedTypeReference<T> parameterizedType) {
		JavaType javaType = objectMapper.getTypeFactory().constructType(parameterizedType.getType());

		List<T> list = new ArrayList<T>();
		for (Object o : values) {
			list.add((T) objectMapper.convertValue(o, javaType));
		}
		return list;
	}
}
