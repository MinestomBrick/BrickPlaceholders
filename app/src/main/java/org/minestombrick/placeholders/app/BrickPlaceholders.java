package org.minestombrick.placeholders.app;

import org.minestombrick.placeholders.api.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.extensions.Extension;

public class BrickPlaceholders extends Extension {

    @Override
    public void initialize() {
        getLogger().info("Enabling " + nameAndVersion() + ".");

        PlaceholderAPI.registerManager(new BrickPlaceholderManager());

        // default placeholders
        PlaceholderAPI.get().registerReplacer("username", p -> Component.text(p.getUsername()));
        PlaceholderAPI.get().registerReplacer("playername", Player::getName);

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
