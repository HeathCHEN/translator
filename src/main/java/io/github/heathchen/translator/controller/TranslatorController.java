package io.github.heathchen.translator.controller;

import com.deepl.api.DeepLException;
import io.github.heathchen.mybatisplus.util.utils.MyBatisPlusUtil;
import io.github.heathchen.translator.domain.AjaxResult;
import io.github.heathchen.translator.domain.baidu.BaiduTranslateRequestDto;
import io.github.heathchen.translator.domain.bing.BingTranslateRequestDto;
import io.github.heathchen.translator.domain.deepl.DeeplTranslateRequestDto;
import io.github.heathchen.translator.domain.gen.TranslateLanguage;
import io.github.heathchen.translator.service.impl.BaiDuService;
import io.github.heathchen.translator.service.impl.BingService;
import io.github.heathchen.translator.service.impl.DeepLService;
import io.github.heathchen.translator.service.TranslateLanguageService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translator")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TranslatorController {

    @Autowired
    DeepLService deepLService;

    @Autowired
    BaiDuService baiDuService;

    @Autowired
    BingService bingService;
    @Autowired
    TranslateLanguageService translateLanguageService;

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

    /**
     * bing翻译器
     * @param bingTranslateRequestDto
     * @return {@link AjaxResult }
     * @author HeathCHEN
     */
    @PostMapping("/bing")
    public AjaxResult bingTranslate(@RequestBody BingTranslateRequestDto bingTranslateRequestDto) {
        return AjaxResult.success(bingService.bingTranslate(bingTranslateRequestDto));
    }


    /**
     * 增加翻译语言
     * @param translateLanguage
     * @return {@link AjaxResult }
     * @author HeathCHEN
     */
    @PostMapping("/gen/addTranslateLanguage")
    public AjaxResult addTranslateLanguage(@RequestBody TranslateLanguage translateLanguage) {
        return AjaxResult.success(translateLanguageService.addTranslateLanguage(translateLanguage));
    }

    /**
     * 查询翻译语言
     * @param translateLanguage
     * @return {@link AjaxResult }
     * @author HeathCHEN
     */
    @PostMapping("/gen/getTranslateLanguage")
    public AjaxResult getTranslateLanguage(@RequestBody TranslateLanguage translateLanguage) {
        return AjaxResult.success(MyBatisPlusUtil.queryByReflect(translateLanguage));
    }


}
