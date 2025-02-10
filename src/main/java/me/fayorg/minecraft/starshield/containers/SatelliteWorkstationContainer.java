package me.fayorg.minecraft.starshield.containers;

import me.fayorg.minecraft.starshield.items.SatelliteComponent;
import me.fayorg.minecraft.starshield.items.SatelliteComponentType;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class SatelliteWorkstationContainer extends AbstractContainerMenu {
    private final Container container;
    private IItemHandler dataInventory;

    // Client constructor
    public SatelliteWorkstationContainer(int windowId, Container playerInventory) {
        this(windowId, playerInventory, new ItemStackHandler(11));
    }

    // Server constructor
    public SatelliteWorkstationContainer(int windowId, Container playerInventory, IItemHandler dataInventory) {
        super(StarshieldContainers.SATELLITE_WORKSTATION_CONTAINER.get(), windowId);

        this.container = playerInventory;
        this.dataInventory = dataInventory;

        // Data slots -- module -- left then right
        for(int i = 0; i < 3; i++) {
            this.addSlot(new SlotItemHandler(dataInventory, i, 15, 26 + i * 23) {
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return isModuleSlotAvailable(this.getSlotIndex());
                }
            });
        }
        for(int i = 0; i < 3; i++) {
            this.addSlot(new SlotItemHandler(dataInventory, 3 + i, 141, 26 + i * 23) {
                @Override
                public boolean mayPlace(@NotNull ItemStack stack) {
                    return isModuleSlotAvailable(this.getSlotIndex());
                }
            });
        }

        // Data slots -- components
        this.addSlot(new SlotItemHandler(dataInventory, 6, 51, 22) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                if (!(stack.getItem() instanceof SatelliteComponent)) return false;
                return ((SatelliteComponent) stack.getItem()).getType() == SatelliteComponentType.SATELLITE_ANTENNA;
            }
        });
        this.addSlot(new SlotItemHandler(dataInventory, 7, 51, 76) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                if (!(stack.getItem() instanceof SatelliteComponent)) return false;
                return ((SatelliteComponent) stack.getItem()).getType() == SatelliteComponentType.SATELLITE_BATTERY;
            }
        });
        this.addSlot(new SlotItemHandler(dataInventory, 8, 105, 22) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                if (!(stack.getItem() instanceof SatelliteComponent)) return false;
                return ((SatelliteComponent) stack.getItem()).getType() == SatelliteComponentType.SATELLITE_ENGINE;
            }
        });
        this.addSlot(new SlotItemHandler(dataInventory, 9, 105, 76) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                if (!(stack.getItem() instanceof SatelliteComponent)) return false;
                return ((SatelliteComponent) stack.getItem()).getType() == SatelliteComponentType.SATELLITE_ENERGY;
            }
        });

        this.addSlot(new SlotItemHandler(dataInventory, 10, 78, 49) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return false;
            }
        });

        // Data inventory
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 126 + y * 18));
            }
        }
        for (int x = 0; x < 9; x++) {
            this.addSlot(new Slot(playerInventory, x, 8 + x * 18, 184));
        }
    }

    public IItemHandler getDataInventory() {
        return dataInventory;
    }

    public void setDataInventory(IItemHandler dataInventory) {
        this.dataInventory = dataInventory;
    }

    public int getModuleMaxAmount() {
        return 6;
    }

    public int getModuleAvailableAmount() {
        int n = 0;
        for (int i = 6; i < 10; i++) {
            if (dataInventory.getStackInSlot(i).getItem() instanceof SatelliteComponent) {
                n += ((SatelliteComponent) dataInventory.getStackInSlot(i).getItem()).getModulesDelta();
            }
        }

        return Math.max(n, 0);
    }

    public boolean isModuleSlotAvailable(int slot) {
        if (slot < 0 || slot >= getModuleMaxAmount()) {
            return false;
        }

        return slot < getModuleAvailableAmount();
    }

    @Override
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();

            if (i < 11) {
                if (!this.moveItemStackTo(itemStack1, 11, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (itemStack1.getItem() instanceof SatelliteComponent) {
                    if (!this.moveItemStackTo(itemStack1, 6, 10, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    if (!this.moveItemStackTo(itemStack1, 0, 6, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            }

            if (itemStack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.container.stillValid(player);
    }
}
