package com.yourgamespace.anticooldown.data;

@SuppressWarnings("ALL")
public class Data {

    public Data() {}

    private final Integer currentConfigVersion = 8;
    private boolean protocollib = true;

    public int getCurrentConfigVersion() {
        return currentConfigVersion;
    }

    public boolean isProtocollibInstalled() {
        return protocollib;
    }

    public void setProtocollib(boolean protocollib) {
        this.protocollib = protocollib;
    }
}
