package io.github.heatchen.translator.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "deepl")
public class DeepLConfig {

    String authKey;

}
