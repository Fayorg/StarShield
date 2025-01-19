package me.fayorg.minecraft.starshield.blocks;

import me.fayorg.minecraft.starshield.Starshield;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class StarshieldBlocks {
    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Starshield.MODID);

    public static final DeferredBlock<SatelliteWorkstationBlock> SATELLITE_WORKSTATION_BLOCK = BLOCKS.registerBlock("satellite_workstation", SatelliteWorkstationBlock::new, BlockBehaviour.Properties.of());
}
