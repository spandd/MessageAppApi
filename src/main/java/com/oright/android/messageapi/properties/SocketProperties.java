package com.oright.android.messageapi.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "socket")
public class SocketProperties  {
    private Integer port;
    private Integer poolKeep;
    private Integer poolCore;
    private Integer poolMax;
    private Integer poolQueueInit;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPoolKeep() {
        return poolKeep;
    }

    public void setPoolKeep(Integer poolKeep) {
        this.poolKeep = poolKeep;
    }

    public Integer getPoolCore() {
        return poolCore;
    }

    public void setPoolCore(Integer poolCore) {
        this.poolCore = poolCore;
    }

    public Integer getPoolMax() {
        return poolMax;
    }

    public void setPoolMax(Integer poolMax) {
        this.poolMax = poolMax;
    }

    public Integer getPoolQueueInit() {
        return poolQueueInit;
    }

    public void setPoolQueueInit(Integer poolQueueInit) {
        this.poolQueueInit = poolQueueInit;
    }
}
