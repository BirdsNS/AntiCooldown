package com.yourgamespace.anticooldown.utils.basics;

import org.bukkit.Bukkit;

@SuppressWarnings("unused")
public class VersionHandler {

    private final String minecraftVersion;
    private final int versionId;

    public VersionHandler() {
        this.minecraftVersion = Bukkit.getBukkitVersion().split("-")[0];

        switch (minecraftVersion) {
            //1.9
            case "1.9":
                versionId = 1;
                break;
            case "1.9.2":
                versionId = 2;
                break;
            case "1.9.4":
                versionId = 3;
                break;
            //1.10
            case "1.10":
                versionId = 4;
                break;
            case "1.10.2":
                versionId = 5;
                break;
            //1.11
            case "1.11":
                versionId = 6;
                break;
            case "1.11.1":
                versionId = 7;
                break;
            case "1.11.2":
                versionId = 8;
                break;
            //1.12
            case "1.12":
                versionId = 9;
                break;
            case "1.12.1":
                versionId = 10;
                break;
            case "1.12.2":
                versionId = 11;
                break;
            //1.13
            case "1.13":
                versionId = 12;
                break;
            case "1.13.1":
                versionId = 13;
                break;
            case "1.13.2":
                versionId = 14;
                break;
            //1.14
            case "1.14":
                versionId = 15;
                break;
            case "1.14.1":
                versionId = 16;
                break;
            case "1.14.2":
                versionId = 17;
                break;
            case "1.14.3":
                versionId = 18;
                break;
            case "1.14.4":
                versionId = 19;
                break;
            //1.15
            case "1.15":
                versionId = 20;
                break;
            case "1.15.1":
                versionId = 21;
                break;
            case "1.15.2":
                versionId = 22;
                break;
            //1.16
            case "1.16.1":
                versionId = 23;
                break;
            case "1.16.2":
                versionId = 24;
                break;
            case "1.16.3":
                versionId = 25;
                break;
            case "1.16.4":
                versionId = 26;
                break;
            case "1.16.5":
                versionId = 27;
                break;
            //1.17
            case "1.17":
                versionId = 28;
                break;
            case "1.17.1":
                versionId = 29;
                break;
            case "1.18":
                versionId = 30;
                break;
            case "1.18.1":
                versionId = 31;
                break;
            case "1.18.2":
                versionId = 32;
                break;
            case "1.19":
                versionId = 33;
                break;
            case "1.19.1":
                versionId = 34;
                break;
            case "1.19.2":
                versionId = 35;
                break;
            case "1.19.3":
                versionId = 36;
                break;
            case "1.19.4":
                versionId = 37;
                break;
            case "1.20":
                versionId = 38;
                break;
            case "1.20.1":
                versionId = 39;
                break;
            case "1.20.2":
                versionId = 39;
                break;
            case "1.20.3":
                versionId = 40;
                break;
            case "1.20.4":
                versionId = 41;
                break;
            case "1.20.5":
                versionId = 42;
                break;
            case "1.20.6":
                versionId = 43;
                break;
            case "1.22":
                versionId = 44;
                break;
            case "1.21.1":
                versionId = 45;
                break;
            //Unsupported
            default:
                versionId = -1;
        }
    }

    public String getMinecraftVersion() {
        return minecraftVersion;
    }

    public int getVersionId() {
        return versionId;
    }
}
