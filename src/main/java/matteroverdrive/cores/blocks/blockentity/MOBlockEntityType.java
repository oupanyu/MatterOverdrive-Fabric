package matteroverdrive.cores.blocks.blockentity;


import matteroverdrive.common.events.MOContent;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class MOBlockEntityType {
    public static final BlockEntityType<TritaniumCrateEntity> TRITANIUM_CRATE_BLOCK_ENTITY_BLOCK_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, "matteroverdrive:tritaniumcrate", FabricBlockEntityTypeBuilder.create(TritaniumCrateEntity::new, MOContent.TRITANIUM_CRATE_BLOCK).build(null));
    public static final BlockEntityType<TestPowerBlockEntity> TEST_POWER_BLOCK_ENTITY_TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, "matteroverdrive:test", FabricBlockEntityTypeBuilder.create(TestPowerBlockEntity::new, MOContent.TEST_POWER_BLOCK).build(null));

    public static void init(){
    System.out.println("Block Entity Done!");
}
}
