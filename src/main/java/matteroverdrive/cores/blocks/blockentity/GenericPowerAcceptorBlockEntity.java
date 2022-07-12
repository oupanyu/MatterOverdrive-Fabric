package matteroverdrive.cores.blocks.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import javax.annotation.Nullable;

public class GenericPowerAcceptorBlockEntity extends GenericBlockEntity {
    private long capacity;
    private long maxInsert;
    private long maxOutput;

    public GenericPowerAcceptorBlockEntity(BlockEntityType<?> type,BlockPos pos, BlockState state,long capacity,long maxInsert,long maxOutput) {
        super(type, pos, state);
        this.capacity = capacity;
        this.maxInsert = maxInsert;
        this.maxOutput = maxOutput;
    }
    public final SimpleEnergyStorage EnergyStorage = new SimpleEnergyStorage(this.capacity,this.maxInsert,this.maxOutput){
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };



}
