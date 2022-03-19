package net.oupanyu;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Additem {
    public static final Logger LOGGER = LogManager.getLogger("MO-Remake");
    public Additem(){

    }

	public static final Item tritanium_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
	public static final Block tritanium_ore = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	 
	public void register()
	{
			
		Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_ingot"), tritanium_ingot);
		Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", "tritanium_ore"), tritanium_ore);
		Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_ore"), new BlockItem(tritanium_ore, new Item.Settings().group(ItemGroup.MISC)));
	}

    
}
