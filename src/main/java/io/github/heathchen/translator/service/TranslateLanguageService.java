package io.github.heathchen.translator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.heathchen.translator.domain.gen.TranslateLanguage;

/**
 * @author Administrator
 * @description 针对表【translate_language】的数据库操作Service
 * @createDate 2024-03-18 16:22:37
 */
public interface TranslateLanguageService extends IService<TranslateLanguage> {

    Boolean addTranslateLanguage(TranslateLanguage translateLanguage);
}
