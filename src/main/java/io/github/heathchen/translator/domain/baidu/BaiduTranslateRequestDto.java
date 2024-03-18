package io.github.heathchen.translator.domain.baidu;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaiduTranslateRequestDto {

    String text;
    String sourceLang;
    String targetLang;


}
