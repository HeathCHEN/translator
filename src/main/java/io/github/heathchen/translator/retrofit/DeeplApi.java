package io.github.heathchen.translator.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.log.LogLevel;
import com.github.lianjiatech.retrofit.spring.boot.log.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.log.Logging;

@RetrofitClient(baseUrl = "https://api-be.ele.me")
@Logging(enable = true, logLevel = LogLevel.INFO, logStrategy = LogStrategy.BASIC)
public interface DeeplApi {
}
