package net.oupanyu.Items;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

//三钛衍生物
//derivatives of tritanium

public class tritanium_derivatives{
    public static final Item tritanium_ingot = new Item(new Item.Settings().group(iteminit.BLOCK_AND_ITEMS));
    public static final Item tritanium_nugget = new Item(new Item.Settings().group(iteminit.BLOCK_AND_ITEMS));
    public static final Item tritanium_dust = new Item(new Item.Settings().group(iteminit.BLOCK_AND_ITEMS));
    public static final Item tritanium_plate = new Item(new Item.Settings().group(iteminit.BLOCK_AND_ITEMS));

    public tritanium_derivatives()
    {
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_ingot"), tritanium_ingot);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_nugget"), tritanium_nugget);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_dust"), tritanium_dust);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_plate"), tritanium_plate);
    }
}
