package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "oracle.db")
public class OracleDBConfig {
    private String userName;
    private String password;
    private String driverName;
    private String port;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "OracleDBConfig{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", driverName='" + driverName + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}

