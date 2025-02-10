package me.fayorg.minecraft.starshield.screens;

import me.fayorg.minecraft.starshield.Starshield;
import me.fayorg.minecraft.starshield.containers.SatelliteWorkstationContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SatelliteWorkstationScreen extends AbstractContainerScreen<SatelliteWorkstationContainer> {

    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(Starshield.MODID, "textures/gui/satellite_workstation.png");

    private Inventory playerInventory;

    public SatelliteWorkstationScreen(SatelliteWorkstationContainer menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        this.playerInventory = playerInventory;
        this.imageWidth = 197;
        this.imageHeight = 207;

        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics, mouseX, mouseY, partialTick);

        super.render(graphics, mouseX, mouseY, partialTick);

        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        guiGraphics.blit(
                GUI_TEXTURE,
                this.leftPos, this.topPos,
                0, 0,
                this.imageWidth, this.imageHeight,
                256, 256
        );

        renderAvailableModules(guiGraphics);
    }

    private void renderAvailableModules(GuiGraphics guiGraphics) {
        for(int i = 0; i < 3; i++) {
            if(!this.menu.isModuleSlotAvailable(i)) {
                drawLockedModule(guiGraphics, 15, 26 + i * 23);
            }
        }
        for(int i = 0; i < 3; i++) {
            if(!this.menu.isModuleSlotAvailable(3 + i)) {
                drawLockedModule(guiGraphics, 141, 26 + i * 23);
            }
        }
    }

    private void drawLockedModule(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(
                GUI_TEXTURE,
                this.leftPos + x, this.topPos + y,
                199, 1,
                16, 16,
                256, 256
        );
    }
}
