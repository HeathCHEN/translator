package io.github.heatchen.translator.domain.baidu;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaiduTranslateResponseDto {

    String text;



}
