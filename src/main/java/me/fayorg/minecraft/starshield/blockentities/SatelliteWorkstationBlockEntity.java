package me.fayorg.minecraft.starshield.blockentities;

import me.fayorg.minecraft.starshield.containers.SatelliteWorkstationContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class SatelliteWorkstationBlockEntity extends BlockEntity implements MenuProvider {
    public SatelliteWorkstationBlockEntity(BlockPos pos, BlockState blockState) {
        super(StarshieldBlockEntities.SATELLITE_WORKSTATION_BLOCK_ENTITY.get(), pos, blockState);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.starshield.satellite_workstation");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SatelliteWorkstationContainer(i, inventory);
    }
}
