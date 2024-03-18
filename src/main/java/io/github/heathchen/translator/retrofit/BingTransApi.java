package io.github.heathchen.translator.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.log.LogLevel;
import com.github.lianjiatech.retrofit.spring.boot.log.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.log.Logging;
import io.github.heathchen.translator.domain.baidu.BaiduTranslateResponseDto;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

    @RetrofitClient(baseUrl = "https://api.cognitive.microsofttranslator.com/")
@Logging(enable = true, logLevel = LogLevel.INFO, logStrategy = LogStrategy.BASIC)
public interface BingTransApi {

    @POST("/api/trans/vip/translate")
    @Headers({"Content-type: application/json"})
    @FormUrlEncoded
    Call<String> bingTrans(
            @Query("api-version") String apiVersion,
            @Query("from") String from,
            @Query("to") String to,
            @Header("Ocp-Apim-Subscription-Key") String key,
            @Header("Ocp-Apim-Subscription-Region") String location,
            @FieldMap Map<String, String> params);
}
