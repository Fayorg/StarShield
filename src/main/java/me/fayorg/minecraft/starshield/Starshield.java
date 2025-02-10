package me.fayorg.minecraft.starshield;

import com.mojang.logging.LogUtils;
import me.fayorg.minecraft.starshield.blockentities.StarshieldBlockEntities;
import me.fayorg.minecraft.starshield.blocks.StarshieldBlocks;
import me.fayorg.minecraft.starshield.containers.StarshieldContainers;
import me.fayorg.minecraft.starshield.items.StarshieldItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(Starshield.MODID)
public class Starshield {
    public static final String MODID = "starshield";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Starshield(IEventBus modEventBus, ModContainer modContainer) {

        StarshieldItems.ITEMS.register(modEventBus);
        StarshieldBlocks.BLOCKS.register(modEventBus);
        StarshieldBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        StarshieldContainers.CONTAINERS.register(modEventBus);

        // Config will be used later
        // modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
