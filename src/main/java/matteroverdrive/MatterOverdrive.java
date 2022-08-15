package matteroverdrive;

import matteroverdrive.client.screen.ScreenRegistian;
import matteroverdrive.common.events.MOContent;
import matteroverdrive.common.utils.BlockUtils;
import matteroverdrive.common.utils.ItemUtils;
import matteroverdrive.cores.blocks.blockentity.MOBlockEntityType;
import matteroverdrive.cores.recipe.ModRecipe;
import net.fabricmc.api.ModInitializer;
import matteroverdrive.cores.generates.GenInit;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static matteroverdrive.common.events.MOContent.dilithium_crystal;


public class MatterOverdrive implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("MatterOverdrive");
	public static final String monamespace = "matteroverdrive";

	public static final ItemGroup GROUP_MAIN = FabricItemGroupBuilder.build(
			new Identifier("matteroverdrive", "main"),
			() -> new ItemStack(dilithium_crystal));
	public static final ItemGroup GROUP_DECO = FabricItemGroupBuilder.build(
			new Identifier("matteroverdrive", "deco"),
			() -> new ItemStack(MOContent.dark_vent_block));


	@Override
	public void onInitialize(){
		GenInit.geninit();
		ItemUtils.init();
		BlockUtils.init();
		MOBlockEntityType.init();
		ModRecipe.registerRecipes();
	  }
}
