package com.yourgamespace.anticooldown.utils.basics;

import com.yourgamespace.anticooldown.main.AntiCooldown;
import org.bukkit.ChatColor;
import org.fusesource.jansi.Ansi;

import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AntiCooldownLogger {

    private static final char ANSI_ESC_CHAR = '\u001b';
    private static final String RGB_STRING = String.valueOf('\u001b') + "[38;2;%d;%d;%dm";
    private static final Pattern RBG_TRANSLATE = Pattern.compile(String.valueOf('§') + "x(" + '§' + "[A-F0-9]){6}", 2);
    private final Map<ChatColor, String> replacements = new EnumMap(ChatColor.class);
    private final ChatColor[] colors = ChatColor.values();
    private final boolean jansiPassthrough = Boolean.getBoolean("jansi.passthrough");

    public AntiCooldownLogger() {
        this.replacements.put(ChatColor.BLACK, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).boldOff().toString());
        this.replacements.put(ChatColor.DARK_BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).boldOff().toString());
        this.replacements.put(ChatColor.DARK_GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).boldOff().toString());
        this.replacements.put(ChatColor.DARK_AQUA, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).boldOff().toString());
        this.replacements.put(ChatColor.DARK_RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).boldOff().toString());
        this.replacements.put(ChatColor.DARK_PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).boldOff().toString());
        this.replacements.put(ChatColor.GOLD, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).boldOff().toString());
        this.replacements.put(ChatColor.GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).boldOff().toString());
        this.replacements.put(ChatColor.DARK_GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).bold().toString());
        this.replacements.put(ChatColor.BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).bold().toString());
        this.replacements.put(ChatColor.GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).bold().toString());
        this.replacements.put(ChatColor.AQUA, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).bold().toString());
        this.replacements.put(ChatColor.RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).bold().toString());
        this.replacements.put(ChatColor.LIGHT_PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).bold().toString());
        this.replacements.put(ChatColor.YELLOW, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).bold().toString());
        this.replacements.put(ChatColor.WHITE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).bold().toString());
        this.replacements.put(ChatColor.MAGIC, Ansi.ansi().a(Ansi.Attribute.BLINK_SLOW).toString());
        this.replacements.put(ChatColor.BOLD, Ansi.ansi().a(Ansi.Attribute.UNDERLINE_DOUBLE).toString());
        this.replacements.put(ChatColor.STRIKETHROUGH, Ansi.ansi().a(Ansi.Attribute.STRIKETHROUGH_ON).toString());
        this.replacements.put(ChatColor.UNDERLINE, Ansi.ansi().a(Ansi.Attribute.UNDERLINE).toString());
        this.replacements.put(ChatColor.ITALIC, Ansi.ansi().a(Ansi.Attribute.ITALIC).toString());
        this.replacements.put(ChatColor.RESET, Ansi.ansi().a(Ansi.Attribute.RESET).toString());
    }

    private static String convertRgbColors(String input) {
        Matcher matcher = RBG_TRANSLATE.matcher(input);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String s = matcher.group().replace("§", "").replace('x', '#');
            java.awt.Color color = java.awt.Color.decode(s);
            int red = color.getRed();
            int blue = color.getBlue();
            int green = color.getGreen();
            String replacement = String.format(RGB_STRING, red, green, blue);
            matcher.appendReplacement(buffer, replacement);
        }

        matcher.appendTail(buffer);
        return buffer.toString();
    }

    public void info(String message) {
        if (AntiCooldown.getVersionHandler().getVersionId() > 29) message = getMessage(message);
        AntiCooldown.getInstance().getLogger().info(message);
    }

    public void warn(String message) {
        if (AntiCooldown.getVersionHandler().getVersionId() > 29) message = getMessage(message);
        AntiCooldown.getInstance().getLogger().warning(message);
    }

    public void debug(Class<?> paramClass, String message) {
        AntiCooldown.getInstance().getLogger().fine("[DEBUG] [" + paramClass.getName() + "]§r " + message);
    }

    private String getMessage(String message) {

        String result = convertRgbColors(message);
        ChatColor[] var6;
        int var5 = (var6 = this.colors).length;

        for (int var4 = 0; var4 < var5; ++var4) {
            ChatColor color = var6[var4];
            if (this.replacements.containsKey(color)) {
                result = result.replaceAll("(?i)" + color.toString(), (String) this.replacements.get(color));
            } else {
                result = result.replaceAll("(?i)" + color.toString(), "");
            }
        }

        return result + Ansi.ansi().reset().toString();


    }
}
