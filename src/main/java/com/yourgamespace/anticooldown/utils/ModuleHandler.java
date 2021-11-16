package com.yourgamespace.anticooldown.utils;

import com.yourgamespace.anticooldown.data.Data;
import com.yourgamespace.anticooldown.main.AntiCooldown;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("unused")
public class ModuleHandler {

    private final LoggingHandler loggingHandler = AntiCooldown.getLoggingHandler();
    private final Data data = AntiCooldown.getData();
    private final ArrayList<AntiCooldownModule> enabledModules = new ArrayList<>();

    public ModuleHandler() {
    }

    public ArrayList<AntiCooldownModule> getEnabledModules() {
        return enabledModules;
    }

    public void registerModule(AntiCooldownModule antiCooldownModule) {
        // If ProtocolLib is required: Check if installed
        if (antiCooldownModule.isProtocolLibRequired() && !data.isProtocolLibInstalled()) {
            loggingHandler.warn("§cModule §e" + antiCooldownModule.getModuleName() + " §crequires §eProtocolLib §cto be installed!");
            return;
        }

        // If compatibility test failed: Do not enable module
        if (!antiCooldownModule.compatibilityTest()) {
            loggingHandler.warn("§cCompatibility-Test failed! Module §e" + antiCooldownModule.getModuleName() + " §cwill not be enabled!");
            return;
        }

        antiCooldownModule.enableModule();
        enabledModules.add(antiCooldownModule);
    }

    public void unregisterModule(String moduleName) {
        for (Iterator<AntiCooldownModule> antiCooldownModuleIterator = enabledModules.iterator(); antiCooldownModuleIterator.hasNext(); ) {
            AntiCooldownModule antiCooldownModule = antiCooldownModuleIterator.next();

            if (!antiCooldownModule.getModuleName().equals(moduleName)) continue;
            enabledModules.remove(antiCooldownModule);
            antiCooldownModule.disableModule();
        }
    }

    public void unregisterModule(String moduleName, String reason) {
        for (Iterator<AntiCooldownModule> antiCooldownModuleIterator = enabledModules.iterator(); antiCooldownModuleIterator.hasNext(); ) {
            AntiCooldownModule antiCooldownModule = antiCooldownModuleIterator.next();

            if (!antiCooldownModule.getModuleName().equals(moduleName)) continue;
            enabledModules.remove(antiCooldownModule);
            antiCooldownModule.disableModule(reason);
        }
    }

    public void unregisterAllModules() {
        for (Iterator<AntiCooldownModule> antiCooldownModuleIterator = enabledModules.iterator(); antiCooldownModuleIterator.hasNext(); ) {
            AntiCooldownModule antiCooldownModule = antiCooldownModuleIterator.next();

            antiCooldownModule.disableModule();
            antiCooldownModuleIterator.remove();
        }
    }
}
