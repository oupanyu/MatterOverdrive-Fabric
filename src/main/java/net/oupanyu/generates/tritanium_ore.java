package net.oupanyu.generates;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.oupanyu.Items.iteminit;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class tritanium_ore{
  public static final Block tritanium_ore = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());
  public tritanium_ore(){

  }
  private static ConfiguredFeature<?, ?> genOREs = Feature.ORE
    .configure(new OreFeatureConfig(
      OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
      tritanium_ore.getDefaultState(),
      9)) // Vein size
    .range(new RangeDecoratorConfig(
      // You can also use one of the other height providers if you don't want a uniform distribution
      UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))) // Inclusive min and max height
    .spreadHorizontally()
    .repeat(20); // Number of veins per chunk
 
 
  public static void gen_tritanium()
    {
      Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", "tritanium_ore"), tritanium_ore);
      Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_ore"), new BlockItem(tritanium_ore, new Item.Settings().group(iteminit.BLOCK_AND_ITEMS)));

      //生成三钛矿
      RegistryKey<ConfiguredFeature<?, ?>> oreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
          new Identifier("matteroverdrive","tritanium_ore"));
          Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreOverworld.getValue(), genOREs);
          BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreOverworld);
  }


}
