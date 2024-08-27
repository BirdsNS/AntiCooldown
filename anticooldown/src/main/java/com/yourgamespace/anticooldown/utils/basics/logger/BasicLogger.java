package com.yourgamespace.anticooldown.utils.basics.logger;

import com.yourgamespace.anticooldown.main.AntiCooldown;

public class BasicLogger implements Logger {
    @Override
    public void info(String message) {
        AntiCooldown.getInstance().getLogger().info(message);
    }

    @Override
    public void warn(String message) {
        AntiCooldown.getInstance().getLogger().warning(message);
    }

    @Override
    public void debug(Class<?> paramClass, String message) {
        AntiCooldown.getInstance().getLogger().fine("[DEBUG] [" + paramClass.getName() + "]§r " + message);
    }
}
