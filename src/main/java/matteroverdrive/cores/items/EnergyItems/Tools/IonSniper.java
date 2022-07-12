package matteroverdrive.cores.items.EnergyItems.Tools;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import matteroverdrive.cores.energy.battery.BatteryItemWithToolTip;

public class IonSniper extends BatteryItemWithToolTip {

    public IonSniper(long capacity, long maxInput, long maxOutput) {
        super(capacity, maxInput, maxOutput);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
            System.out.println("IonSniper");
        return new TypedActionResult<>(ActionResult.SUCCESS,user.getStackInHand(hand));
    }
}
