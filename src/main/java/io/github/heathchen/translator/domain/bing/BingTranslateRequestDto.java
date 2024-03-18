package io.github.heathchen.translator.domain.bing;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BingTranslateRequestDto {

    String text;
    String sourceLang;
    String targetLang;


}
