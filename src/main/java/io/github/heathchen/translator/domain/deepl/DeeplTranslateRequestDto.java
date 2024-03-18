package io.github.heathchen.translator.domain.deepl;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeeplTranslateRequestDto {

    String text;
    String sourceLang;
    String targetLang;


}
