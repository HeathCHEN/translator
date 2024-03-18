package io.github.heathchen.translator.domain.baidu;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaiduTranslateResponseDto {

    String from;
    String to;

    @JsonProperty(value = "trans_result")
    List<Result> transResult;


    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Result {
        String src;
        String dst;
    }

}
