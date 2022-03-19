package net.oupanyu.Items;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class dilithium_crystal{
    public static final Item dilithium_crystal = new Item(new Item.Settings().group(iteminit.BLOCK_AND_ITEMS));

    public dilithium_crystal()
    {
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "dilithium_crystal"), dilithium_crystal);
    }
}
