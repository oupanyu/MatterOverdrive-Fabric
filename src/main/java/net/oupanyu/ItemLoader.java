package net.oupanyu;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.oupanyu.generates.dilithium_ore;
import net.oupanyu.generates.tritanium_ore;



//该模块已废弃，不要更改此处内容



public class ItemLoader
{
    //public static final Item tritanium_ingot = new Item(new Item.Settings().group(ItemGroup.MISC));
   // public static final Block tritanium_ore = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));


    public ItemLoader()
    {
        //register("tritanium_ingot", tritanium_ingot);
        //regblock("tritanium_ore", tritanium_ore);
        tritanium_ore.gen_tritanium();
        dilithium_ore.gen_dilithium();
    }
 
    private void register(String name, Item item)
    {
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", name), item);
    }

    /*private static ConfiguredFeature<?, ?> genOREs = Feature.ORE
    .configure(new OreFeatureConfig(
      OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
      tritanium_ore.getDefaultState(),
      9)) // Vein size
    .range(new RangeDecoratorConfig(
      // You can also use one of the other height providers if you don't want a uniform distribution
      UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))) // Inclusive min and max height
    .spreadHorizontally()
    .repeat(20); // Number of veins per chunk
 
    public void genOres() 
    {
        //生成三钛矿
        RegistryKey<ConfiguredFeature<?, ?>> oreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
            new Identifier("matteroverdrive","tritanium_ore"));
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreOverworld.getValue(), genOREs);
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreOverworld);
    }
    */
}