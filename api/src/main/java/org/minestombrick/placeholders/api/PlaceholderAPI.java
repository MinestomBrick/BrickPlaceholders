package org.minestombrick.placeholders.api;

public class PlaceholderAPI {

    private static PlaceholderManager placeholderManager;

    public static void registerManager(PlaceholderManager manager) {
        placeholderManager = manager;
    }

    //

    public static PlaceholderManager get() {
        return placeholderManager;
    }

}