package me.fayorg.minecraft.starshield.blocks;

import com.mojang.serialization.MapCodec;
import me.fayorg.minecraft.starshield.blockentities.SatelliteWorkstationBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SatelliteWorkstationBlock extends BaseEntityBlock {
    public static final MapCodec<SatelliteWorkstationBlock> CODEC = simpleCodec(SatelliteWorkstationBlock::new);

    public SatelliteWorkstationBlock(BlockBehaviour.Properties properties) {
        super(properties);

    }

    @Override
    protected MapCodec<SatelliteWorkstationBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SatelliteWorkstationBlockEntity(blockPos, blockState);
    }
}
