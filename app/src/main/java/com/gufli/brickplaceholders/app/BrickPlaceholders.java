package com.gufli.brickplaceholders.app;

import com.gufli.brickplaceholders.api.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.extensions.Extension;

public class BrickPlaceholders extends Extension {

    @Override
    public void initialize() {
        getLogger().info("Enabling " + nameAndVersion() + ".");

        PlaceholderAPI.registerManager(new BrickPlaceholderManager());

        // default placeholders
        PlaceholderAPI.registerReplacer("username", p -> Component.text(p.getUsername()));
        PlaceholderAPI.registerReplacer("playername", Player::getName);

        getLogger().info("Enabled " + nameAndVersion() + ".");
    }

    @Override
    public void terminate() {
        getLogger().info("Disabled " + nameAndVersion() + ".");
    }

    private String nameAndVersion() {
        return getOrigin().getName() + " v" + getOrigin().getVersion();
    }

}
