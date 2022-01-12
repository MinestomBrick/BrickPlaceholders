package com.gufli.brickplaceholders.api;

import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface PlaceholderManager {

    Component replace(@NotNull Player player, @NotNull Component component);

    Component replace(@NotNull Player player, @NotNull String text);

    Collection<String> placeholders();

    // function of format (player, key, string)
    void registerReplacer(@NotNull String key, @NotNull BiFunction<Player, String, Component> replacer);

    // function of format (player, string)
    void registerReplacer(@NotNull String key, @NotNull Function<Player, Component> replacer);

    void unregisterReplacer(@NotNull String key);

}