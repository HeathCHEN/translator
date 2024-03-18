package io.github.heathchen.translator.controller;

import com.deepl.api.DeepLException;
import io.github.heathchen.translator.domain.AjaxResult;
import io.github.heathchen.translator.domain.baidu.BaiduTranslateRequestDto;
import io.github.heathchen.translator.domain.deepl.DeeplTranslateRequestDto;
import io.github.heathchen.translator.service.BaiDuService;
import io.github.heathchen.translator.service.DeepLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translator")
@Slf4j
public class TranslatorController {

    @Autowired
    DeepLService deepLService;

    @Autowired
    BaiDuService baiDuService;

    /**
     * deepl翻译器
     * @param deeplTranslateRequestDto
     * @return {@link AjaxResult }
     * @throws DeepLException
     * @throws InterruptedException
     * @author HeathCHEN
     */
    @PostMapping("/deepl")
    public AjaxResult deepLTranslate(@RequestBody DeeplTranslateRequestDto deeplTranslateRequestDto) throws DeepLException, InterruptedException {
        return AjaxResult.success(deepLService.deepLTranslate(deeplTranslateRequestDto));
    }


    /**
     * baidu翻译器
     * @param baiduTranslateRequestDto
     * @return {@link AjaxResult }
     * @author HeathCHEN
     */
    @PostMapping("/baidu")
    public AjaxResult baiduTranslate(@RequestBody BaiduTranslateRequestDto baiduTranslateRequestDto) {
        return AjaxResult.success(baiDuService.baiduTranslate(baiduTranslateRequestDto));
    }





}
