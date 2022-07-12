package matteroverdrive.cores.energy.battery;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.common.utils.ItemUtils;
import matteroverdrive.utils.ToolTipUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleBatteryItem;

import java.util.List;

public class BatteryItemWithToolTip extends Item implements SimpleBatteryItem {
	private final long capacity, maxInput, maxOutput;

	public BatteryItemWithToolTip(long capacity, long maxInput, long maxOutput) {
		super(new Item.Settings().maxCount(1).group(MatterOverdrive.GROUP_MAIN));
		this.capacity = capacity;
		this.maxInput = maxInput;
		this.maxOutput = maxOutput;
	}

	@Override
	public long getEnergyCapacity() {
		return capacity;
	}

	@Override
	public long getEnergyMaxInput() {
		return maxInput;
	}

	@Override
	public long getEnergyMaxOutput() {
		return maxOutput;
	}

	@Environment(EnvType.CLIENT)
	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

		tooltip.add(new TranslatableText("item.matteroverdrive.battery.energy", ToolTipUtils.getStoredEnergyFormated(itemStack),ToolTipUtils.getNumberFormated(capacity)).formatted(Formatting.GOLD));
	}

	@Override
	public int getItemBarStep(ItemStack stack) {
		return ItemUtils.getPowerForDurabilityBar(stack);
	}

	@Override
	public boolean isItemBarVisible(ItemStack stack) {
		return true;
	}

	@Override
	public int getItemBarColor(ItemStack stack) {
		return ItemUtils.getColorForDurabilityBar(stack);
	}
}
