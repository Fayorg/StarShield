package me.fayorg.minecraft.starshield.datagen;


import me.fayorg.minecraft.starshield.Starshield;
import me.fayorg.minecraft.starshield.items.StarshieldItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Starshield.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(StarshieldItems.ANTENNA.get());
        basicItem(StarshieldItems.BATTERY.get());
        basicItem(StarshieldItems.SATELLITE_BUS.get());
        basicItem(StarshieldItems.SOLAR_PANELS.get());
        basicItem(StarshieldItems.THRUSTER.get());
        basicItem(StarshieldItems.SATELLITE.get());
    }
}
