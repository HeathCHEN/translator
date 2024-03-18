package io.github.heathchen.translator.service;

import cn.hutool.core.collection.CollectionUtil;
import io.github.heathchen.translator.config.BaiduConfig;
import io.github.heathchen.translator.domain.baidu.BaiduTranslateRequestDto;
import io.github.heathchen.translator.domain.baidu.BaiduTranslateResponseDto;
import io.github.heathchen.translator.domain.gen.GeneralTranslateResponse;
import io.github.heathchen.translator.retrofit.BaiduTransApi;
import io.github.heathchen.translator.util.baidu.MD5;
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
public class BaiDuService {

    @Autowired
    BaiduConfig baiduConfig;
    @Autowired
    BaiduTransApi baiduTransApi;


    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("appid", baiduConfig.getAppId());
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);
        String src = baiduConfig.getAppId() + query + salt + baiduConfig.getSecurityKey();
        params.put("sign", MD5.md5(src));
        return params;
    }


    public GeneralTranslateResponse baiduTranslate(BaiduTranslateRequestDto baiduTranslateRequestDto) {
        Map<String, String> params = buildParams(baiduTranslateRequestDto.getText(), baiduTranslateRequestDto.getSourceLang(), baiduTranslateRequestDto.getTargetLang());
        Call<BaiduTranslateResponseDto> call = baiduTransApi.baiduTrans(params);
        Response<BaiduTranslateResponseDto> execute = null;
        try {
            execute = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            log.error(execute.message());
//            log.error(execute.body().);
            log.error(execute.errorBody().toString());
        }
        BaiduTranslateResponseDto translateResponseDto = execute.body();
        List<BaiduTranslateResponseDto.Result> transResult = translateResponseDto.getTransResult();
        GeneralTranslateResponse generalTranslateResponse = new GeneralTranslateResponse();

        if (CollectionUtil.isNotEmpty(transResult)) {
            generalTranslateResponse.setText(transResult.get(0).getDst());
        }

        return generalTranslateResponse;
    }

}
