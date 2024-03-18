package io.github.heathchen.translator.domain.gen;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeneralTranslateResponse {

    String text;



}
