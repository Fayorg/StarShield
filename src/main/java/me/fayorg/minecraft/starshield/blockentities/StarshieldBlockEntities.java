package me.fayorg.minecraft.starshield.blockentities;

import me.fayorg.minecraft.starshield.Starshield;
import me.fayorg.minecraft.starshield.blocks.StarshieldBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class StarshieldBlockEntities {

    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Starshield.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SatelliteWorkstationBlockEntity>> SATELLITE_WORKSTATION_BLOCK_ENTITY = register("satellite_workstation", SatelliteWorkstationBlockEntity::new, () -> new Block[]{StarshieldBlocks.SATELLITE_WORKSTATION_BLOCK.get()});

    private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String id, BlockEntityType.BlockEntitySupplier<T> factoryIn, Supplier<Block[]> validBlocksSupplier)
    {
        return BLOCK_ENTITIES.register(id, () -> BlockEntityType.Builder.of(factoryIn, validBlocksSupplier.get()).build(null));
    }
}
