package com.gufli.brickplaceholders.app;

import com.gufli.brickplaceholders.api.PlaceholderManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class BrickPlaceholderManager implements PlaceholderManager {

    private final static Pattern PATTERN = Pattern.compile("(\\{[^}]+})");
    private final Map<String, BiFunction<Player, String, Component>> replacers = new HashMap<>();

    @Override
    public Component replace(@NotNull Player player, @NotNull String text) {
        return replace(player, Component.text(text));
    }

    @Override
    public Component replace(@NotNull Player player, @NotNull Component component) {
        return component
                .replaceText(builder -> builder.match(PATTERN)
                .replacement((matchResult, textbuilder) -> replace(player, matchResult, textbuilder)));
    }

    private ComponentLike replace(Player player, MatchResult match, TextComponent.Builder builder) {
        String group = match.group().toLowerCase();
        String placeholder = group.substring(1, group.length()-1); // remove surrounding brackets

        if ( !replacers.containsKey(placeholder) ) {
            return builder.append(Component.text(group));
        }

        Component replacement = replacers.get(placeholder).apply(player, placeholder);
        if ( replacement == null ) {
            replacement = Component.text("");
        }

        return replacement;
    }

    @Override
    public Collection<String> placeholders() {
        return Collections.unmodifiableSet(replacers.keySet());
    }

    @Override
    public void registerReplacer(@NotNull String key, @NotNull BiFunction<Player, String, Component> replacer) {
        replacers.put(key.toLowerCase(), replacer);
    }

    @Override
    public void registerReplacer(@NotNull String key, @NotNull Function<Player, Component> replacer) {
        replacers.put(key.toLowerCase(), (p, s) -> replacer.apply(p));
    }

    @Override
    public void unregisterReplacer(@NotNull String key) {
        replacers.remove(key.toLowerCase());
    }
}