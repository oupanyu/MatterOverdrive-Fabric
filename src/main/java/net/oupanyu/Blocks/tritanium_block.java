package net.oupanyu.Blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.oupanyu.Items.iteminit;

public class tritanium_block {
    public static final Block tritanium_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());
    public static void reg(){
        Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", "tritanium_block"), tritanium_block);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_block"), new BlockItem(tritanium_block, new Item.Settings().group(iteminit.BLOCK_AND_ITEMS)));
    }
}
