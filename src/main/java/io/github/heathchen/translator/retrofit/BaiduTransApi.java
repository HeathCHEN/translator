package io.github.heathchen.translator.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.log.LogLevel;
import com.github.lianjiatech.retrofit.spring.boot.log.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.log.Logging;
import io.github.heathchen.translator.domain.baidu.BaiduTranslateResponseDto;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

@RetrofitClient(baseUrl = "http://api.fanyi.baidu.com")
@Logging(enable = true, logLevel = LogLevel.INFO, logStrategy = LogStrategy.BASIC)
public interface BaiduTransApi {

    @POST("/api/trans/vip/translate")
    @FormUrlEncoded
    Call<BaiduTranslateResponseDto> baiduTrans(@FieldMap Map<String, String> params);

}
