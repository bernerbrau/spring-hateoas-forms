package com.github.hateoas.forms.spring.siren;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 * Created by Dietrich on 18.04.2016.
 */
@JsonInclude(NON_EMPTY)
@JsonPropertyOrder({"class", "name", "title", "type", "readOnly", "required", "value"})
public class SirenMultiField extends SirenField<List<SirenFieldValue>> {

	/**
	 * Siren field.
	 *
	 * @param sirenClasses Describes aspects of the field based on the current representation. Possible values are
	 * implementation-dependent and should be documented. MUST be an array of strings. Optional.
	 * @param name A name describing the control. Field names MUST be unique within the set of fields for an action. The
	 * behaviour of clients when parsing a Siren document that violates this constraint is undefined. Required.
	 * @param type The input type of the field. This may include any of the following input types specified in HTML5:
	 * <code>hidden, text, search, tel, url, email, password, datetime, date, month, week, time, datetime-local,
	 * number, range, color, checkbox, radio, file</code>
	 * When missing, the default value is text. Serialization of these fields will depend on the value of the
	 * action's type attribute. See type under Actions, above. Optional.
	 * @param value possible values for radio or checkbox, with actual values selected. Optional.
	 * @param title Textual annotation of a field. Clients may use this as a label. Optional.
	 */
	public SirenMultiField(String name, String type, List<SirenFieldValue> value, String title, boolean readOnly, boolean required, List<String> sirenClasses) {
		super(name, type, value, title, readOnly, required, sirenClasses);
	}

}
