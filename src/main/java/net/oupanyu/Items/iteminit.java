package net.oupanyu.Items;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class iteminit {
    //物品组的新建
    public static final Item tritanium_ingot = new Item(new Item.Settings());
    public static final ItemGroup BLOCK_AND_ITEMS = FabricItemGroupBuilder.build(
		new Identifier("matteroverdrive", "blocks_and_items"),
		() -> new ItemStack(tritanium_ingot));
 
	public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
		new Identifier("matteroverdrive", "foods"))
		.icon(() -> new ItemStack(Items.BOWL))
		.build();

    public static void init()
    {
        new tritanium_derivatives();
        new dilithium_crystal();
    }
}
