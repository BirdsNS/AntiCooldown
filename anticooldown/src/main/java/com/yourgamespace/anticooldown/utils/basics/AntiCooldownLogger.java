package com.yourgamespace.anticooldown.utils.basics;

import com.yourgamespace.anticooldown.main.AntiCooldown;
import com.yourgamespace.anticooldown.utils.basics.logger.AnsiLogger;
import com.yourgamespace.anticooldown.utils.basics.logger.BasicLogger;
import com.yourgamespace.anticooldown.utils.basics.logger.Logger;

public class AntiCooldownLogger {

    private final Logger logger = AntiCooldown.getVersionHandler().getVersionId() > 29 ? new AnsiLogger() : new BasicLogger();

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void debug(Class<?> paramClass, String message) {
        logger.debug(paramClass, message);
    }

}
