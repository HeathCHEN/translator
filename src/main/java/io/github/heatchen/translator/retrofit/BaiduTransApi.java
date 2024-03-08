package io.github.heatchen.translator.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.log.LogLevel;
import com.github.lianjiatech.retrofit.spring.boot.log.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.log.Logging;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@RetrofitClient(baseUrl = "http://api.fanyi.baidu.com")
@Logging(enable = true, logLevel = LogLevel.INFO, logStrategy = LogStrategy.BASIC)
public interface BaiduTransApi {

    @GetMapping("/api/trans/vip/translate")
    String baiduTrans(Map<String, String> params);

}
