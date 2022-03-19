package net.oupanyu.Blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.oupanyu.Items.iteminit;

public class adornments {
    private static final Block yellow_stripes_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    private static final Block tritanium_smooth_plate_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    private static final Block vent_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    private static final Block dark_vent_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    private static final Block holographic_matrix_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    private static final Block tritanium_plate_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    private static final Block tritanium_plate_guided_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    private static final Block carbon_fiber_plate_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    private static final Block floor_tiles_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());



    private static void registry(String name,Block block){
        Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", name), block);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", name), new BlockItem(block, new Item.Settings().group(iteminit.BLOCK_AND_ITEMS)));
    }

    public static void reg()
    {
        registry("yellow_stripes_block", yellow_stripes_block);
        registry("tritanium_smooth_plate_block", tritanium_smooth_plate_block);
        registry("vent_block", vent_block);
        registry("dark_vent_block", dark_vent_block);
        registry("holographic_matrix_block", holographic_matrix_block);
        registry("tritanium_plate_block", tritanium_plate_block);
        registry("tritanium_plate_guided_block", tritanium_plate_guided_block);
        registry("carbon_fiber_plate_block", carbon_fiber_plate_block);
        registry("floor_tiles_block", floor_tiles_block);

    }
}
