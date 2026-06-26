package com.example.showmilhao.config;

import java.util.prefs.Preferences;

public class ConfigManager {

    private static final Preferences prefs =
            Preferences.userRoot().node("show_milhao_config");

    private static final String KEY_VOLUME = "volume";

    public static void salvarVolume(double volume) {
        prefs.putDouble(KEY_VOLUME, volume);
    }

    public static double carregarVolume() {
        return prefs.getDouble(KEY_VOLUME, 0.5);
    }
}