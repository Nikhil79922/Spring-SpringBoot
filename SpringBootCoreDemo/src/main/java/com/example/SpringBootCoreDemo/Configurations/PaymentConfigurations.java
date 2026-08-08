package com.example.SpringBootCoreDemo.Configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("com.example.SprinBootCoreDemo")
@ConfigurationProperties("payment-gateway")
public class PaymentConfigurations {
    private String type;
    private int retry_count;
    private boolean enable;

    public void setTime_out(int time_out) {
        this.time_out = time_out;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRetry_count(int retry_count) {
        this.retry_count = retry_count;
    }

    private int time_out;

    public String getType() {
        return type;
    }

    public int getRetry_count() {
        return retry_count;
    }

    public boolean isEnabled() {
        return enable;
    }

    public int getTime_out() {
        return time_out;
    }
}
