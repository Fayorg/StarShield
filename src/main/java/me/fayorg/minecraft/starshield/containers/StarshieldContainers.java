package me.fayorg.minecraft.starshield.containers;

import me.fayorg.minecraft.starshield.Starshield;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class StarshieldContainers {

    public static DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(Registries.MENU, Starshield.MODID);

    public static final Supplier<MenuType<SatelliteWorkstationContainer>> SATELLITE_WORKSTATION_CONTAINER = CONTAINERS.register("satellite_workstation", () -> new MenuType<>(SatelliteWorkstationContainer::new, FeatureFlags.DEFAULT_FLAGS));
}
