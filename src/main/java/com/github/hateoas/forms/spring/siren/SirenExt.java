package com.github.hateoas.forms.spring.siren;

import org.springframework.http.MediaType;

public final class SirenExt {
    private SirenExt() {}

    public static final String MEDIA_TYPE_VALUE = "application/prs.lanlext+siren+json";
    public static final MediaType MEDIA_TYPE = MediaType.parseMediaType(MEDIA_TYPE_VALUE);
}
