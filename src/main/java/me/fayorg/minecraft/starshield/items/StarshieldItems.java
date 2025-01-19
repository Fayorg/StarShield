package me.fayorg.minecraft.starshield.items;

import me.fayorg.minecraft.starshield.Starshield;
import me.fayorg.minecraft.starshield.blocks.StarshieldBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class StarshieldItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Starshield.MODID);

    public static final DeferredHolder<Item, Item> SATELLITE_BUS = ITEMS.register("satellite_bus", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> ANTENNA = ITEMS.register("antenna", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SOLAR_PANELS = ITEMS.register("solar_panels", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> BATTERY = ITEMS.register("battery", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> THRUSTER = ITEMS.register("thruster", () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> SATELLITE = ITEMS.register("satellite", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, BlockItem> SATELLITE_WORKSTATION = ITEMS.register("satellite_workstation", () -> new BlockItem(StarshieldBlocks.SATELLITE_WORKSTATION_BLOCK.get(), new Item.Properties()));
}
