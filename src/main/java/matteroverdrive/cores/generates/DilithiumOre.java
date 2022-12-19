package matteroverdrive.cores.generates;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.common.events.MainGroupReg;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class DilithiumOre {
    public static final Block DILITHIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block DEEPSLATE_DILITHIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE));


  public DilithiumOre(){

  }

  private static ConfiguredFeature<?, ?> DILITHIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
          (Feature.ORE, new OreFeatureConfig(
                  OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                  DILITHIUM_ORE.getDefaultState(),
                  9)); // vein size



  private static ConfiguredFeature<?, ?> DEEPSLATE_DILITHIUM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
          (Feature.ORE, new OreFeatureConfig(
                  OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                  DEEPSLATE_DILITHIUM_ORE.getDefaultState(),
                  9)); // vein size
  public static PlacedFeature DILITHIUM_ORE_PLACED_FEATURE = new PlacedFeature(
          RegistryEntry.of(DILITHIUM_ORE_CONFIGURED_FEATURE),
          Arrays.asList(
                  CountPlacementModifier.of(20), // number of veins per chunk
                  SquarePlacementModifier.of(), // spreading horizontally
                  HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(50))
          )); // height

  public static PlacedFeature DEEPSLATE_DILITHIUM_ORE_PLACED_FEATURE = new PlacedFeature(
          RegistryEntry.of(DEEPSLATE_DILITHIUM_ORE_CONFIGURED_FEATURE),
          Arrays.asList(
                  CountPlacementModifier.of(20), // number of veins per chunk
                  SquarePlacementModifier.of(), // spreading horizontally
                  HeightRangePlacementModifier.uniform(YOffset.fixed(-56), YOffset.fixed(0))
          )); // height
 
 
  public static void gen_dilithium()
    {
      Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", "dilithium_ore"), DILITHIUM_ORE);
      Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "dilithium_ore"), new BlockItem(DILITHIUM_ORE, new Item.Settings().group(MatterOverdrive.GROUP_MAIN)));

        Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", "deepslate_dilithium_ore"), DEEPSLATE_DILITHIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "deepslate_dilithium_ore"), new BlockItem(DEEPSLATE_DILITHIUM_ORE, new Item.Settings().group(MatterOverdrive.GROUP_MAIN)));


        //生成二锂矿
      Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
        new Identifier("matteroverdrive", "dilithium_ore"), DILITHIUM_ORE_CONFIGURED_FEATURE);
    Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("matteroverdrive", "dilithium_ore"),
        DILITHIUM_ORE_PLACED_FEATURE);
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        RegistryKey.of(Registry.PLACED_FEATURE_KEY,
            new Identifier("matteroverdrive", "dilithium_ore")));


      Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
              new Identifier("matteroverdrive", "deepslate_dilithium_ore"), DEEPSLATE_DILITHIUM_ORE_CONFIGURED_FEATURE);
      Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("matteroverdrive", "deepslate_dilithium_ore"),
              DEEPSLATE_DILITHIUM_ORE_PLACED_FEATURE);
      BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
              RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                      new Identifier("matteroverdrive", "deepslate_dilithium_ore")));
  
        }

}
