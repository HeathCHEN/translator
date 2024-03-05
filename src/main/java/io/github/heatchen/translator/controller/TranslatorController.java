package io.github.heatchen.translator.controller;

import com.deepl.api.Translator;
import io.github.heatchen.translator.domain.AjaxResult;
import io.github.heatchen.translator.domain.DeeplTranslateRequestDto;
import io.github.heatchen.translator.service.DeepLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translator")
public class TranslatorController {

    @Autowired
    DeepLService deepLService;

    @PostMapping("/deepl")
    public AjaxResult deepLTranslate(@RequestBody DeeplTranslateRequestDto deeplTranslateRequestDto) {
        return AjaxResult.success(deepLService.deepLTranslate(deeplTranslateRequestDto));
    }

}
