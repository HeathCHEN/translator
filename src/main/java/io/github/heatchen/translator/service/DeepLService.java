package io.github.heatchen.translator.service;

import com.deepl.api.Translator;
import io.github.heatchen.translator.config.DeepLConfig;
import io.github.heatchen.translator.domain.DeeplTranslateRequestDto;
import io.github.heatchen.translator.domain.DeeplTranslateResponseDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeepLService {

    @Autowired
    DeepLConfig deepLConfig;

    public DeeplTranslateResponseDto deepLTranslate(DeeplTranslateRequestDto requestDto) {
        DeeplTranslateResponseDto result = new DeeplTranslateResponseDto();


        Translator translator = new Translator(deepLConfig.getAuthKey());

        translator.translateText()

        return result;
    }

}
