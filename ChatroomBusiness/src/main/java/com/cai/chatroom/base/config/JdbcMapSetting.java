package com.cai.chatroom.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "")
public class JdbcMapSetting{
    private Map<String,JdbcSetting> datasources = new LinkedHashMap<>();

    public Map<String, JdbcSetting> getDatasources() {
        return datasources;
    }

    public void setDatasources(Map<String, JdbcSetting> datasources) {
        this.datasources = datasources;
    }

    static class JdbcSetting{
        String url;
        String username;
        String password;
        String driverClassName;
        Integer initialSize;
        Integer maxActive;
        Integer maxIdle;
        Integer minIdle;
        String type;
        String isDefault;
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        public Integer getInitialSize() {
            return initialSize;
        }

        public void setInitialSize(Integer initialSize) {
            this.initialSize = initialSize;
        }

        public Integer getMaxActive() {
            return maxActive;
        }

        public void setMaxActive(Integer maxActive) {
            this.maxActive = maxActive;
        }

        public Integer getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(Integer maxIdle) {
            this.maxIdle = maxIdle;
        }

        public Integer getMinIdle() {
            return minIdle;
        }

        public void setMinIdle(Integer minIdle) {
            this.minIdle = minIdle;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(String isDefault) {
            this.isDefault = isDefault;
        }
    }
}
