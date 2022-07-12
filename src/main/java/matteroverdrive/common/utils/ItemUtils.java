package matteroverdrive.common.utils;

import matteroverdrive.common.events.MainGroupReg;
import matteroverdrive.common.items.foods.FoodInit;
import matteroverdrive.cores.powerSystem.MOEnergyItem;
import net.minecraft.item.ItemStack;
import team.reborn.energy.api.base.SimpleBatteryItem;

public class ItemUtils {
    public static void init(){
        MainGroupReg.init();
        FoodInit.regfood();
    }
    public static int getPowerForDurabilityBar(ItemStack stack) {
        if (!(stack.getItem() instanceof SimpleBatteryItem energyItem)) {
            throw new UnsupportedOperationException();
        }

        return Math.round((energyItem.getStoredEnergy(stack) * 100f / energyItem.getEnergyCapacity()) * 13) / 100;
    }

    public static int getColorForDurabilityBar(ItemStack stack) {
        return 0xff8006;
    }

}
