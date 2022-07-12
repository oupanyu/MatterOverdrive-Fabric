package matteroverdrive.common.events;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.cores.blocks.blockentity.MOBlockEntityType;
import matteroverdrive.cores.blocks.blockentity.TestPowerBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import team.reborn.energy.api.EnergyStorage;

public class MORegistry {
    public static void regBlockInGroupMain(Block block, String name) {
        Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", name), block);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", name), new BlockItem(block, new Item.Settings().group(MatterOverdrive.GROUP_MAIN)));
    }
    public static void regBlockInGroupDeco(Block block, String name) {
        Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", name), block);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", name), new BlockItem(block, new Item.Settings().group(MatterOverdrive.GROUP_DECO)));
    }
    public static void regEnergyBlock(Block block, String name){
        Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", name), block);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", name), new BlockItem(block, new Item.Settings().group(MatterOverdrive.GROUP_MAIN)));
        EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.EnergyStorage, MOBlockEntityType.TEST_POWER_BLOCK_ENTITY_TYPE);
    }
    public static void regItem(Item item, String name) {
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", name),item);
    }
}
