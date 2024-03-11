package io.github.heatchen.translator.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.log.LogLevel;
import com.github.lianjiatech.retrofit.spring.boot.log.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.log.Logging;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.Map;

@RetrofitClient(baseUrl = "http://api.fanyi.baidu.com")
@Logging(enable = true, logLevel = LogLevel.INFO, logStrategy = LogStrategy.BASIC)
public interface BaiduTransApi {

    @POST("/api/trans/vip/translate")
    @FormUrlEncoded
    Call<String> baiduTrans(@FieldMap Map<String, String> params);

}
