package io.github.heatchen.translator.service;

import io.github.heatchen.translator.config.BaiduConfig;
import io.github.heatchen.translator.domain.baidu.BaiduTranslateRequestDto;
import io.github.heatchen.translator.domain.baidu.BaiduTranslateResponseDto;
import io.github.heatchen.translator.retrofit.BaiduTransApi;
import io.github.heatchen.translator.util.baidu.MD5;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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


    public BaiduTranslateResponseDto baiduTranslate(BaiduTranslateRequestDto baiduTranslateRequestDto){
        Map<String, String> params = buildParams(baiduTranslateRequestDto.getText(),baiduTranslateRequestDto.getSourceLang(),baiduTranslateRequestDto.getTargetLang());
        String result = baiduTransApi.baiduTrans(params);
        BaiduTranslateResponseDto baiduTranslateResponseDto = new BaiduTranslateResponseDto();
        baiduTranslateResponseDto.setText(result);
        return baiduTranslateResponseDto;
    }
}
