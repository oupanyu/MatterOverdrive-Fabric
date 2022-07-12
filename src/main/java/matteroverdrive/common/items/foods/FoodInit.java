package matteroverdrive.common.items.foods;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FoodInit {



    public static final Item EMERGENCY_RATION = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.3F).build()).maxCount(64));
    public static final Item EARL_GRAY_TEA = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()).maxCount(64));
    public static final Item ROMULAN_ALE = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()).maxCount(64));

    /*public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("matteroverdrive", "Food"))
            .icon(() -> new ItemStack(FOOD_UNIT))
            .appendItems(stacks)
            .build();
*/
    public static final ItemGroup FOOD_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("matteroverdrive", "food"))
            .icon(() -> new ItemStack(EMERGENCY_RATION))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(EMERGENCY_RATION));
                stacks.add(new ItemStack(EARL_GRAY_TEA));
                stacks.add(new ItemStack(ROMULAN_ALE));
            })
            .build();

    public static void regfood(){
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "emergency_ration"), EMERGENCY_RATION);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "earl_gray_tea"), EARL_GRAY_TEA);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "romulan_ale"), ROMULAN_ALE);

    }
}
