package io.github.heathchen.translator.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import io.github.heathchen.translator.config.BaiduConfig;
import io.github.heathchen.translator.config.BingConfig;
import io.github.heathchen.translator.domain.baidu.BaiduTranslateRequestDto;
import io.github.heathchen.translator.domain.baidu.BaiduTranslateResponseDto;
import io.github.heathchen.translator.domain.bing.BingTranslateRequestDto;
import io.github.heathchen.translator.domain.gen.GeneralTranslateResponse;
import io.github.heathchen.translator.retrofit.BaiduTransApi;
import io.github.heathchen.translator.retrofit.BingTransApi;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class BingService {
    @Autowired
    BingConfig bingConfig;
    @Autowired
    BingTransApi bingTransApi;


    public GeneralTranslateResponse bingTranslate(BingTranslateRequestDto bingTranslateRequestDto) {
        GeneralTranslateResponse generalTranslateResponse = new GeneralTranslateResponse();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        Call<String> bingTrans = bingTransApi.bingTrans("3.0",
                bingTranslateRequestDto.getSourceLang(),
                bingTranslateRequestDto.getTargetLang(),
                bingConfig.getKey(),
                bingConfig.getLocation(), stringStringHashMap);

        try {
            Response<String> execute = bingTrans.execute();
            System.out.println(execute);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return generalTranslateResponse;
    }

}
