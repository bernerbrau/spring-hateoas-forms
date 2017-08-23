package com.github.hateoas.forms.spring.siren;

import java.util.List;

/**
 * Created by Dietrich on 18.04.2016.
 */
public abstract class SirenField<V> extends AbstractSirenEntity {

	private String name;
	private String type;
	private V value;
	private boolean readOnly;
	private boolean required;

	protected SirenField(String name, String type, V value, String title, boolean readOnly, boolean required, List<String> sirenClasses) {
		super(title, sirenClasses);
		this.name = name;
		this.type = type;
		this.value = value;
		this.readOnly = readOnly;
		this.required = required;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public V getValue() {
		return value;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public boolean isRequired() {
		return required;
	}

}
