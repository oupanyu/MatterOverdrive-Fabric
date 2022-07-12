package matteroverdrive.utils;

import net.minecraft.item.ItemStack;
import team.reborn.energy.api.base.SimpleBatteryItem;

public class ToolTipUtils {
    public static String getStoredEnergyFormated(ItemStack itemStack){
        String tooltip = "";
        double energy = SimpleBatteryItem.getStoredEnergyUnchecked(itemStack);
        if (energy >= 1000){
            energy /= 1000;
            tooltip = "k";
        }
        if (energy >= 1000){
            energy /= 1000;
            tooltip = "M";
        }

        return String.format("%.1f",energy) + tooltip;
    }
    public static String getNumberFormated(double capacity){
        String tooltip = "";
        if (capacity >= 1000){
            capacity /= 1000;
            tooltip = "k";
        }
        if (capacity >= 1000){
            capacity /= 1000;
            tooltip = "M";
        }
        return String.format("%.1f",capacity) + tooltip;
    }
}
