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
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public class TritaniumOre {
  public static final Block tritanium_ore = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());
  public static final Block DEEPSLATE_TRIATNIUM_ORE = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE));


  public TritaniumOre(){

  }
  
  private static ConfiguredFeature<?, ?> OVERWORLD_ORE_CONFIGURED_FEATURE = Feature.ORE
      .configure(new OreFeatureConfig(
          OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
          tritanium_ore.getDefaultState(),
          9)); // vein size
 
  private static PlacedFeature OVERWORLD_ORE_PLACED_FEATURE = OVERWORLD_ORE_CONFIGURED_FEATURE.withPlacement(
      CountPlacementModifier.of(20), // number of veins per chunk
      SquarePlacementModifier.of(), // spreading horizontally
      HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(48)));


  private static ConfiguredFeature<?, ?> DEEPSLATE_TRITANIUM_ORE_CONFIGURED_FEATURE = Feature.ORE
          .configure(new OreFeatureConfig(
                  OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                  DEEPSLATE_TRIATNIUM_ORE.getDefaultState(),
                  9)); // vein size

  private static PlacedFeature DEEPSLATE_TRITANIUM_ORE_PLACED_FEATURE = DEEPSLATE_TRITANIUM_ORE_CONFIGURED_FEATURE.withPlacement(
          CountPlacementModifier.of(20), // number of veins per chunk
          SquarePlacementModifier.of(), // spreading horizontally
          HeightRangePlacementModifier.uniform(YOffset.fixed(-56), YOffset.fixed(0)));

  public static void gen_tritanium()
    {
      Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", "tritanium_ore"), tritanium_ore);
      Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_ore"), new BlockItem(tritanium_ore, new Item.Settings().group(MatterOverdrive.GROUP_MAIN)));

      Registry.register(Registry.BLOCK, new Identifier("matteroverdrive", "deepslate_tritanium_ore"), DEEPSLATE_TRIATNIUM_ORE);
      Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "deepslate_tritanium_ore"), new BlockItem(DEEPSLATE_TRIATNIUM_ORE, new Item.Settings().group(MatterOverdrive.GROUP_MAIN)));

      //生成三钛矿

      Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
              new Identifier("matteroverdrive", "tritanium_ore"), OVERWORLD_ORE_CONFIGURED_FEATURE);
      Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("matteroverdrive", "tritanium_ore"),
              OVERWORLD_ORE_PLACED_FEATURE);
      BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
              RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                      new Identifier("matteroverdrive", "tritanium_ore")));


      Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
        new Identifier("matteroverdrive", "deepslate_tritanium_ore"), DEEPSLATE_TRITANIUM_ORE_CONFIGURED_FEATURE);
      Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("matteroverdrive", "deepslate_tritanium_ore"),
          DEEPSLATE_TRITANIUM_ORE_PLACED_FEATURE);
      BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
      RegistryKey.of(Registry.PLACED_FEATURE_KEY,
          new Identifier("matteroverdrive", "deepslate_tritanium_ore")));
        }


}
