package me.fayorg.minecraft.starshield;

import me.fayorg.minecraft.starshield.containers.StarshieldContainers;
import me.fayorg.minecraft.starshield.screens.SatelliteWorkstationScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = Starshield.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientHandler {

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(StarshieldContainers.SATELLITE_WORKSTATION_CONTAINER.get(), SatelliteWorkstationScreen::new);
    }

}
