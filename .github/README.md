# BrickPlaceholders

An extension for [Minestom](https://github.com/Minestom/Minestom) with an api for placeholders.

## Install

Get the latest jar file from [Github actions](https://github.com/MinestomBrick/BrickPermissions/actions) 
and place it in the extension folder of your minestom server.

## Usage

```
repositories {
    maven { url "https://repo.jorisg.com/snapshots" }
}

dependencies {
    implementation 'com.gufli.brickplaceholders:api:1.0-SNAPSHOT'
}
```

```java
PlaceholderAPI.registerReplacer("level", (player) -> {
    return Component.text(player.getLevel());
});

Component result = PlaceholderAPI.replace(player, text);
```

## Credits

* The [Minestom](https://github.com/Minestom/Minestom) project

## Contributing

Check our [contributing info](CONTRIBUTING.md)

