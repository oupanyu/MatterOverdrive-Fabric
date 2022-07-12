package matteroverdrive.common.blocks;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.common.events.MOContent;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Adornments {


    private static void registry(String name,Block block){
        Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", name), block);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", name), new BlockItem(block, new Item.Settings().group(MatterOverdrive.GROUP_DECO)));
    }
    
    public static void reg()
    {
        Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", "tritanium_block"), MOContent.TRITANIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_block"), new BlockItem(MOContent.TRITANIUM_BLOCK, new Item.Settings().group(MatterOverdrive.GROUP_MAIN)));
        registry("tritanium_smooth_plate_block", MOContent.tritanium_smooth_plate_block);
        registry("tritanium_plate_block", MOContent.TRITANIUM_PLATE_BLOCK);
        registry("tritanium_plate_guided_block", MOContent.TRITANIUM_PLATE_GUIDED_BLOCK);
        registry("yellow_stripes_block", MOContent.yellow_stripes_block);
        registry("vent_block", MOContent.VENT_BLOCK);
        registry("dark_vent_block", MOContent.dark_vent_block);
        registry("holographic_matrix_block", MOContent.holographic_matrix_block);
        registry("carbon_fiber_plate_block", MOContent.CARBON_FIBER_PLATE_BLOCK);
        registry("floor_tiles_block", MOContent.FLOOR_TILES_BLOCK);
        registry("floor_tiles_green_block",MOContent.FLOOR_TILES_GREEN_BLOCK);
        registry("green_floor_tiles_block",MOContent.GREEN_FLOOR_TILES_BLOCK);
        registry("floor_noise_block",MOContent.FLOOR_NOISE_BLOCK);
        registry("matter_tube_block",MOContent.MATTER_TUBE_BLOCK);
        registry("industrial_glass_block",MOContent.INDUSTRIAL_GLASS_BLOCK);
        registry("tritanium_glass_block",MOContent.TRITANIUM_GLASS_BLOCK);
        registry("tritanium_grate_block",MOContent.TRITANIUM_GRATE_BLOCK);

    }
}
