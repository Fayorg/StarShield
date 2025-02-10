package me.fayorg.minecraft.starshield.items;

import net.minecraft.world.item.Item;

public class SatelliteComponent extends Item {
    private final int modulesDelta;
    private final SatelliteComponentType type;

    public SatelliteComponent(Properties properties, SatelliteComponentType type, int modulesDelta) {
        super(properties);

        this.type = type;
        this.modulesDelta = modulesDelta;
    }

    public int getModulesDelta() {
        return modulesDelta;
    }

    public SatelliteComponentType getType() {
        return type;
    }
}

