package com.yourgamespace.anticooldown.utils.basics.logger;

public interface Logger {

    void info(String message);

    void warn(String message);

    void debug(Class<?> paramClass, String message);
}
