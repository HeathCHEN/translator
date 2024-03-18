package io.github.heathchen.translator.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "deepl")
@Data
@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeepLConfig {

    @Value("${appid:}")
    String baiduAppId;

    @Value("${securityKey:}")
    String authKey;


}
