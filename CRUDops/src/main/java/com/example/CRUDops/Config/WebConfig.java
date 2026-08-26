package com.example.CRUDops.Config;

import com.example.CRUDops.Interceptor.LoggingInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public LoggingInterceptors LoggingInterceptor;

    public WebConfig(LoggingInterceptors loggingInterceptor) {
        this.LoggingInterceptor = loggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(LoggingInterceptor);
    }

}
