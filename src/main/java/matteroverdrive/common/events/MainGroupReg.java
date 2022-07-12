package matteroverdrive.common.events;

import matteroverdrive.cores.blocks.blockentity.TestPowerBlockEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.reborn.energy.api.base.InfiniteEnergyStorage;


import static matteroverdrive.MatterOverdrive.monamespace;
import static matteroverdrive.common.events.MOContent.*;

//三钛衍生物
//derivatives of tritanium

public class MainGroupReg {

/*
    public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("matteroverdrive", "maingroup"))
            .icon(() -> new ItemStack(dilithium_crystal))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(dilithium_crystal));
                stacks.add(new ItemStack(TRITANIUM_BLOCK));
                stacks.add(new ItemStack(tritanium_ingot));
                stacks.add(new ItemStack(tritanium_nugget));
                stacks.add(new ItemStack(tritanium_dust));
                stacks.add(new ItemStack(tritanium_plate));
                stacks.add(new ItemStack(tritanium_ore));
                stacks.add(new ItemStack(DEEPSLATE_TRIATNIUM_ORE));
                stacks.add(new ItemStack(DILITHIUM_ORE));
                stacks.add(new ItemStack(DEEPSLATE_DILITHIUM_ORE));
                stacks.add(new ItemStack(MATTER_DUST));
                stacks.add(new ItemStack(MATTER_DUST_REFINED));

                //Batteries
                stacks.add(new ItemStack(BATTERY_ITEM));
                stacks.add(new ItemStack(HC_BATTERY_ITEM));
                stacks.add(new ItemStack(ION_SNIPER));
                stacks.add(new ItemStack(OMNI_TOOL));
                stacks.add(new ItemStack(PHASER_RIFLE_ITEM));
                stacks.add(new ItemStack(PLASMA_SHOTGUN));


                //Tools & armors
                stacks.add(new ItemStack(TRITANIUM_PICKAXE));
                stacks.add(new ItemStack(TRITANIUM_AXE));
                stacks.add(new ItemStack(TRITANIUM_SHOVEL));
                stacks.add(new ItemStack(TRITANIUM_SWORD));
                stacks.add(new ItemStack(TRITANIUM_HOE));
                stacks.add(new ItemStack(TRITANIUM_HELMET));
                stacks.add(new ItemStack(TRITANIUM_CHESTPLATE));
                stacks.add(new ItemStack(TRITANIUM_LEGGINGS));
                stacks.add(new ItemStack(TRITANIUM_BOOTS));


            })
            .build();
    */

    public static void init()
    {
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_ingot"), tritanium_ingot);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_nugget"), tritanium_nugget);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_dust"), tritanium_dust);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "tritanium_plate"), tritanium_plate);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "dilithium_crystal"), dilithium_crystal);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "matter_dust"), MATTER_DUST);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "matter_dust_refined"), MATTER_DUST_REFINED);
        MORegistry.regItem(ISOLINEAR_CIRCUIT_MK1,"isolinear_circuit_mk1");
        MORegistry.regItem(ISOLINEAR_CIRCUIT_MK2,"isolinear_circuit_mk2");
        MORegistry.regItem(ISOLINEAR_CIRCUIT_MK3,"isolinear_circuit_mk3");
        MORegistry.regItem(ISOLINEAR_CIRCUIT_MK4,"isolinear_circuit_mk4");


        //Machines & Blocks
        MORegistry.regBlockInGroupMain(TRITANIUM_CRATE_BLOCK,"tritanium_crate_black");
        MORegistry.regBlockInGroupMain(TRITANIUM_CRATE_BLOCK_BLUE,"tritanium_crate_blue");
        MORegistry.regEnergyBlock(TEST_POWER_BLOCK,"test");



        //Batteries
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "battery"), BATTERY_ITEM);
        Registry.register(Registry.ITEM, new Identifier("matteroverdrive", "hc_battery"), HC_BATTERY_ITEM);


        //Tools(electic)
        Registry.register(Registry.ITEM,new Identifier("matteroverdrive","phaser_rifle"),PHASER_RIFLE_ITEM);
        Registry.register(Registry.ITEM,new Identifier("matteroverdrive","plasma_shotgun"),PLASMA_SHOTGUN);
        Registry.register(Registry.ITEM,new Identifier("matteroverdrive","ion_sniper"),ION_SNIPER);
        Registry.register(Registry.ITEM,new Identifier("matteroverdrive","omni_tool"),OMNI_TOOL);

        //Tools(valinna)
        Registry.register(Registry.ITEM,new  Identifier("matteroverdrive","tritanium_pickaxe"),TRITANIUM_PICKAXE);
        Registry.register(Registry.ITEM,new  Identifier("matteroverdrive","tritanium_axe"),TRITANIUM_AXE);
        Registry.register(Registry.ITEM,new  Identifier("matteroverdrive","tritanium_shovel"),TRITANIUM_SHOVEL);
        Registry.register(Registry.ITEM,new  Identifier("matteroverdrive","tritanium_sword"),TRITANIUM_SWORD);
        Registry.register(Registry.ITEM,new  Identifier("matteroverdrive","tritanium_hoe"),TRITANIUM_HOE);





        //Armors
        Registry.register(Registry.ITEM, new Identifier(monamespace, "tritanium_helmet"), TRITANIUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier(monamespace, "tritanium_chestplate"), TRITANIUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(monamespace, "tritanium_leggings"), TRITANIUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(monamespace, "tritanium_boots"), TRITANIUM_BOOTS);

    }
    
}

