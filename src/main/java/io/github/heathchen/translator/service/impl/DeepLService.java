package io.github.heathchen.translator.service.impl;

import com.deepl.api.DeepLException;
import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import io.github.heathchen.translator.config.DeepLConfig;
import io.github.heathchen.translator.domain.deepl.DeeplTranslateRequestDto;
import io.github.heathchen.translator.domain.deepl.DeeplTranslateResponseDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class DeepLService {

    @Autowired
    DeepLConfig deepLConfig;

    public DeeplTranslateResponseDto deepLTranslate(DeeplTranslateRequestDto requestDto) throws DeepLException, InterruptedException {
        DeeplTranslateResponseDto result = new DeeplTranslateResponseDto();


        Translator translator = new Translator(deepLConfig.getAuthKey());

        TextResult textResult = translator.translateText(requestDto.getText(), requestDto.getSourceLang(), requestDto.getTargetLang());


        result.setText(textResult.getText());
        return result;
    }

}
