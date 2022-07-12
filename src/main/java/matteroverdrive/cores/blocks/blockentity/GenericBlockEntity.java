package matteroverdrive.cores.blocks.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

import net.minecraft.util.math.BlockPos;

public class GenericBlockEntity extends BlockEntity {
    public GenericBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public static void tick() {

    }
}
