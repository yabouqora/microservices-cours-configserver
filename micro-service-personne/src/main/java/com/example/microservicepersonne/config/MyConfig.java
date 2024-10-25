package com.example.microservicepersonne.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;



@Data
@RefreshScope
public class MyConfig {
    @Value("${db-url}")
    private String db_url;
    @Value("${db-username}")
    private String db_username;
    @Value("${db-password}")
    private String db_password;
}
