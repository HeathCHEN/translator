package io.github.heathchen.translator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.heathchen.translator.domain.gen.TranslateLanguage;
import io.github.heathchen.translator.mapper.TranslateLanguageMapper;
import io.github.heathchen.translator.service.TranslateLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【translate_language】的数据库操作Service实现
 * @createDate 2024-03-18 16:22:37
 */
@Service
public class TranslateLanguageServiceImpl extends ServiceImpl<TranslateLanguageMapper, TranslateLanguage>
        implements TranslateLanguageService {



    @Override
    public Boolean addTranslateLanguage(TranslateLanguage translateLanguage) {
        return save(translateLanguage);
    }
}




