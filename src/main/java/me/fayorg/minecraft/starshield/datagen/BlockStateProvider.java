package me.fayorg.minecraft.starshield.datagen;

import me.fayorg.minecraft.starshield.Starshield;
import me.fayorg.minecraft.starshield.blocks.StarshieldBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockStateProvider extends net.neoforged.neoforge.client.model.generators.BlockStateProvider {

    public BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Starshield.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(StarshieldBlocks.SATELLITE_WORKSTATION_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
