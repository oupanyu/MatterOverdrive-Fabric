package matteroverdrive.common.events;

import matteroverdrive.MatterOverdrive;
import matteroverdrive.cores.blocks.TestPowerBlock;
import matteroverdrive.cores.blocks.TritaniumCrateBlock;
import matteroverdrive.cores.energy.battery.BatteryItemWithToolTip;
import matteroverdrive.cores.items.EnergyItems.Tools.IonSniper;
import matteroverdrive.cores.items.EnergyItems.Tools.OmniTool;
import matteroverdrive.cores.items.EnergyItems.Tools.PhaserRifleItemWithToolTip;
import matteroverdrive.cores.items.EnergyItems.Tools.PlasmaShotgun;
import matteroverdrive.cores.items.armors.TritaniumArmorMaterial;
import matteroverdrive.cores.tools.TritaniumAxeItem;
import matteroverdrive.cores.tools.TritaniumHoeItem;
import matteroverdrive.cores.tools.TritaniumPickaxeItem;
import matteroverdrive.cores.tools.TritaniumToolMaterial;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import team.reborn.energy.api.base.InfiniteEnergyStorage;

public class MOContent {
    //Armors
    public static final ArmorMaterial TRITANIUM_ARMOR_MATERIAL = new TritaniumArmorMaterial();
    public static final Item TRITANIUM_HELMET = new ArmorItem(TRITANIUM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item TRITANIUM_CHESTPLATE = new ArmorItem(TRITANIUM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item TRITANIUM_LEGGINGS = new ArmorItem(TRITANIUM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item TRITANIUM_BOOTS = new ArmorItem(TRITANIUM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(MatterOverdrive.GROUP_MAIN));


    //Items
    public static final Item tritanium_ingot = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item tritanium_nugget = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item tritanium_dust = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item tritanium_plate = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item dilithium_crystal = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item MATTER_DUST = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item MATTER_DUST_REFINED = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item ISOLINEAR_CIRCUIT_MK1 = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item ISOLINEAR_CIRCUIT_MK2 = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item ISOLINEAR_CIRCUIT_MK3 = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static final Item ISOLINEAR_CIRCUIT_MK4 = new Item(new Item.Settings().group(MatterOverdrive.GROUP_MAIN));


    public static final BatteryItemWithToolTip BATTERY_ITEM = new BatteryItemWithToolTip(524288, 10000, 10000);
    public static final BatteryItemWithToolTip HC_BATTERY_ITEM = new BatteryItemWithToolTip(1048576, 10000, 10000);

    //Tools
    public static ToolItem TRITANIUM_SHOVEL = new ShovelItem(TritaniumToolMaterial.INSTANCE,1.5F,-3.0F,new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static ToolItem TRITANIUM_SWORD = new SwordItem(TritaniumToolMaterial.INSTANCE,3,-2.4F,new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static ToolItem TRITANIUM_PICKAXE = new TritaniumPickaxeItem(TritaniumToolMaterial.INSTANCE,1,-2.8F,new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static ToolItem TRITANIUM_AXE = new TritaniumAxeItem(TritaniumToolMaterial.INSTANCE,7.0F,-3.2F,new Item.Settings().group(MatterOverdrive.GROUP_MAIN));
    public static ToolItem TRITANIUM_HOE = new TritaniumHoeItem(TritaniumToolMaterial.INSTANCE,-1,-3.2F,new Item.Settings().group(MatterOverdrive.GROUP_MAIN));

    public static final PhaserRifleItemWithToolTip PHASER_RIFLE_ITEM = new PhaserRifleItemWithToolTip(1000000,100000,0);
    public static final PlasmaShotgun PLASMA_SHOTGUN = new PlasmaShotgun(1000000,100000,0);
    public static final IonSniper ION_SNIPER = new IonSniper(1000000,100000,0);
    public static final OmniTool OMNI_TOOL = new OmniTool(1000000,100000,0);

    //Blocks & machines
    public static final Block TRITANIUM_CRATE_BLOCK = new TritaniumCrateBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());
    public static final Block TRITANIUM_CRATE_BLOCK_BLUE = new TritaniumCrateBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());

    public static final Block INSCRIBER_BLOCK = new TestPowerBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());



    //decos
    public static final Block TRITANIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f).requiresTool());
    public static final Block tritanium_smooth_plate_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block TRITANIUM_PLATE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block TRITANIUM_PLATE_GUIDED_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block yellow_stripes_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block VENT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block dark_vent_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block holographic_matrix_block = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block CARBON_FIBER_PLATE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block FLOOR_TILES_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block FLOOR_TILES_GREEN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block GREEN_FLOOR_TILES_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block FLOOR_NOISE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block MATTER_TUBE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());
    public static final Block TRITANIUM_GRATE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(3.0f).requiresTool());

    public static final Block INDUSTRIAL_GLASS_BLOCK = new Block(FabricBlockSettings.of(Material.GLASS).hardness(3.0f).nonOpaque().requiresTool());
    public static final Block TRITANIUM_GLASS_BLOCK = new Block(FabricBlockSettings.of(Material.GLASS).hardness(3.0f).nonOpaque().requiresTool());


}
