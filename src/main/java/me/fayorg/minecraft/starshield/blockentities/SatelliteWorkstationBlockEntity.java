package me.fayorg.minecraft.starshield.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SatelliteWorkstationBlockEntity extends BlockEntity {
    public SatelliteWorkstationBlockEntity(BlockPos pos, BlockState blockState) {
        super(StarshieldBlockEntities.SATELLITE_WORKSTATION_BLOCK_ENTITY.get(), pos, blockState);
    }
}
